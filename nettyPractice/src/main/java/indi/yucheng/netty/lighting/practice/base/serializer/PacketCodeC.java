package indi.yucheng.netty.lighting.practice.base.serializer;

import indi.yucheng.netty.lighting.practice.base.data.LoginRequestPacket;
import indi.yucheng.netty.lighting.practice.base.data.LoginResponsePacket;
import indi.yucheng.netty.lighting.practice.base.data.MessageRequestPacket;
import indi.yucheng.netty.lighting.practice.base.data.MessageResponsePacket;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

public class PacketCodeC implements Command {
    /**
     *  1.懒汉式（线程不安全，不推荐）
     *  2.饿汉式
     *  3.静态内部类
     *  4.DCL双重检查饿汉式
     */


    /**
     * 2.饿汉式单例模式
     */
//    private static PacketCodeC INSTANCE = new PacketCodeC();
//    private PacketCodeC(){}
//    public static PacketCodeC getInstance() {
//        return INSTANCE;
//    }


    /**
     * 1。懒汉式
     */
//    private static PacketCodeC INSTANCE;
//    private PacketCodeC(){}
//    public static PacketCodeC getInstance() {
//        if (INSTANCE == null) {
//            INSTANCE = new PacketCodeC();
//        }
//        return INSTANCE;
//    }

    /**
     * 3.静态内部类（推荐）
     */
    private static class PacketCodeCHolder {
        private static final PacketCodeC INSTANCE = new PacketCodeC();
    }
    private PacketCodeC(){}
    public static final PacketCodeC getInstance() {
        return PacketCodeCHolder.INSTANCE;
    }


    /**
     * 4.DCL 双重检查
     */
//    private PacketCodeC() {
//    }
//    private static volatile PacketCodeC INSTANCE;
//    public static PacketCodeC getInstance() {
//        if (INSTANCE == null) {
//            synchronized (PacketCodeC.class) {
//                if (INSTANCE == null) {
//                    INSTANCE = new PacketCodeC();
//                }
//            }
//        }
//        return INSTANCE;
//    }

    public static final int MAGIC_NUMBER = 0x12345678;

    public ByteBuf encode(ByteBufAllocator alloc, Packet packet) {
        // 1.创建 ByteBuf 对象
//        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.ioBuffer();
        ByteBuf byteBuf = alloc.DEFAULT.ioBuffer();
        // 2.序列化 JAVA 对象
        byte[] bytes = Serializer.DEFAULT.serialize(packet);
        // 3.实际编码过程
        byteBuf.writeInt(MAGIC_NUMBER);
        byteBuf.writeByte(packet.getVersion());
        byteBuf.writeByte(Serializer.DEFAULT.getSerializerAlgorithm());
        byteBuf.writeByte(packet.getCommand());
        byteBuf.writeInt(bytes.length);
        byteBuf.writeBytes(bytes);
        return byteBuf;
    }

    /**
     * 重载encode 方法
     * @param byteBuf
     * @param packet
     * @return
     */
    public ByteBuf encode(ByteBuf byteBuf, Packet packet) {
        // 1.序列化 JAVA 对象
        byte[] bytes = Serializer.DEFAULT.serialize(packet);
        // 2.实际编码过程
        byteBuf.writeInt(MAGIC_NUMBER);
        byteBuf.writeByte(packet.getVersion());
        byteBuf.writeByte(Serializer.DEFAULT.getSerializerAlgorithm());
        byteBuf.writeByte(packet.getCommand());
        byteBuf.writeInt(bytes.length);
        byteBuf.writeBytes(bytes);
        return byteBuf;
    }

    public Packet decode(ByteBuf byteBuf) {
        // 跳过魔数
        byteBuf.skipBytes(4);
        // 跳过版本号
        byteBuf.skipBytes(1);
        // 序列化算法标识
        byte serializerAlgorithm = byteBuf.readByte();
        // 指令
        byte command = byteBuf.readByte();
        // 数据包长度
        int length = byteBuf.readInt();

        byte[] bytes = new byte[length];
        byteBuf.readBytes(bytes);

        Class<? extends Packet> requestType = getRequestType(command);
        Serializer serializer = getSerializer(serializerAlgorithm);

        if (requestType != null && serializer != null) {
            return serializer.deserialize(requestType, bytes);
        }

        return null;
    }

    private Serializer getSerializer(byte serializerAlgorithm) {
        return Serializer.DEFAULT;
    }

    private Class<? extends Packet> getRequestType(Byte command) {
        if (null == command) {
            return null;
        }

        switch (command) {
            case 1: return LoginRequestPacket.class;
            case 2: return LoginResponsePacket.class;
            case 3: return MessageRequestPacket.class;
            case 4: return MessageResponsePacket.class;
            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }
    }
}
