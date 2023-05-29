package indi.yucheng.netty.lighting.learing.chapter13.data;


import io.netty.util.AttributeKey;

public interface Attributes {
    AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");

}
