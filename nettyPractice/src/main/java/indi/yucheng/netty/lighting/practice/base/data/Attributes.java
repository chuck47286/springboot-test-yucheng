package indi.yucheng.netty.lighting.practice.base.data;


import io.netty.util.AttributeKey;

public interface Attributes {
    AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");

}
