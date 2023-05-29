package indi.yucheng.netty.lighting.practice.base.serializer;


public interface Serializer {
    byte JSON_SERIALIZER = 1;

    Serializer DEFAULT = new JSONSerializer();

    /**
     * 序列化算法
     * @return
     */
    byte getSerializerAlgorithm();

    /**
     * Java 对象转换成二进制数据
     * @return
     */
    byte[] serialize(Object object);

    /**
     * 二进制数据转换成Java对象
     * @param clazz
     * @param bytes
     * @param <T>
     * @return
     */
    <T> T deserialize(Class<T> clazz, byte[] bytes);
}
