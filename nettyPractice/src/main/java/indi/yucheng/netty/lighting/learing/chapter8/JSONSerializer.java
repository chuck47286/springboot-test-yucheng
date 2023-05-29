package indi.yucheng.netty.lighting.learing.chapter8;

import com.alibaba.fastjson.JSON;
import indi.yucheng.netty.lighting.learing.chapter8.serializer.SerializerAlgorithm;
import indi.yucheng.netty.lighting.learing.chapter8.serializer.Serializer;

public class JSONSerializer implements Serializer {
    @Override
    public byte getSerializerAlgorithm() {
        return SerializerAlgorithm.JSON;
    }

    @Override
    public byte[] serialize(Object object) {
        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {
        return JSON.parseObject(bytes, clazz);
    }
}
