package indi.yucheng.netty.lighting.learing.chapter11.data;

public enum MessageEnum {
    MESSAGE_REQUEST(Byte.valueOf("1"), "客户端发送的信息");

    private Byte command;
    private String desc;

    MessageEnum(Byte cmd, String desc) {
        this.command = cmd;
        this.desc = desc;
    }

    public Byte getCommand() {
        return command;
    }


    public String getDesc() {
        return desc;
    }

}
