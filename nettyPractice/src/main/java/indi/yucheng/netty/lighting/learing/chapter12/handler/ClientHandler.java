package indi.yucheng.netty.lighting.learing.chapter12.handler;

import indi.yucheng.netty.lighting.learing.chapter12.data.MessageResponsePacket;
import indi.yucheng.netty.lighting.learing.chapter12.util.LoginUtil;
import indi.yucheng.netty.lighting.learing.chapter8.LoginRequestPacket;
import indi.yucheng.netty.lighting.learing.chapter8.LoginResponsePacket;
import indi.yucheng.netty.lighting.learing.chapter8.Packet;
import indi.yucheng.netty.lighting.learing.chapter8.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;
import java.util.UUID;

public class ClientHandler extends ChannelInboundHandlerAdapter {
    // 写数据逻辑
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println(new Date() + ": 客户端开始登录");
        /** 逻辑 before
         *         // 1.获取数据
         *         ByteBuf buffer = getByteBuf(ctx);
         *         // 2.写数据
         *         ctx.channel().writeAndFlush(buffer);
         */
        /**
         * 1.客户端发送登录请求
         * 1.1 创建对象
         * 1.2 编码
         * 1.3 刷入tcp通道
         */
        // 创建登录对象
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        loginRequestPacket.setUserId(UUID.randomUUID().toString());
        loginRequestPacket.setUsername("flash");
        loginRequestPacket.setPassword("pwd");

        // 编码
        ByteBuf buffer = PacketCodeC.getInstance().encode(ctx.alloc(), loginRequestPacket);

        // 写数据
        ctx.channel().writeAndFlush(buffer);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        /**
         * 逻辑 before
         *         ByteBuf byteBuf = (ByteBuf) msg;
         *         System.out.println(new Date() +":客户端读到数据--》" + byteBuf.toString(Charset.forName("utf-8")));
         *
         *         private ByteBuf getByteBuf(ChannelHandlerContext ctx) {
         *         // 1.获取二进制抽象ByteBuf
         *         ByteBuf buffer = ctx.alloc().buffer();
         *         // 2.准备数据，指定字符串的字符集UTF-8
         *         byte[] bytes = "你好，闪电侠！".getBytes(Charset.forName("utf-8"));
         *         // 3.填充数据到ByteBuf
         *         buffer.writeBytes(bytes);
         *         return buffer;
         *     }
         *
         */

        /**
         * 4.客户端处理服务端的response
         */
        ByteBuf byteBuf = (ByteBuf) msg;
        Packet packet = PacketCodeC.getInstance().decode(byteBuf);
        if (packet instanceof LoginResponsePacket) {
            // 处理登录
            handleLoginResponsePacket(ctx , packet);
        } else if (packet instanceof MessageResponsePacket) {
            // 处理消息
            handleMessageResponsePacket(ctx, packet);
        }
    }

    private void handleMessageResponsePacket(ChannelHandlerContext ctx, Packet packet) {
        MessageResponsePacket messageResponsePacket =  (MessageResponsePacket) packet;
        System.out.println(new Date() + ": 收到服务端消息： " + messageResponsePacket.getMessage());
    }

    private void handleLoginResponsePacket(ChannelHandlerContext ctx, Packet packet) {
        LoginResponsePacket loginResponsePacket = (LoginResponsePacket) packet;
        if (loginResponsePacket.isSuccess()) {
            // 0.标记登录状态
            LoginUtil.markAsLogin(ctx.channel());
            System.out.println(new Date() + ": 客户端登录成功");
        } else {
            System.out.println(new Date() + ": 客户端登录失败，原因： " + loginResponsePacket.getReason());
        }
    }


}
