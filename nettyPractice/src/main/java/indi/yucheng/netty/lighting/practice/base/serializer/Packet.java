package indi.yucheng.netty.lighting.practice.base.serializer;

import lombok.Data;

@Data
public abstract class Packet implements Command {
    /**
     * 协议版本
     */
    private Byte version = 1;

    /**
     * 指令
     * @return
     */
    public abstract Byte getCommand();
}
