package indi.yucheng.netty.lighting.practice.chapter15.handler;

import indi.yucheng.netty.lighting.practice.base.data.LoginRequestPacket;
import indi.yucheng.netty.lighting.practice.base.data.LoginResponsePacket;
import indi.yucheng.netty.lighting.practice.base.serializer.PacketCodeC;
import indi.yucheng.netty.lighting.practice.base.util.LoginUtil;



import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket loginRequestPacket) throws Exception {
        ctx.channel().writeAndFlush(login(ctx, loginRequestPacket));
    }

    private Object login(ChannelHandlerContext ctx, LoginRequestPacket packet) {
        LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
        loginResponsePacket.setVersion(packet.getVersion());
        if (valid(packet)) {
            loginResponsePacket.setSuccess(true);
            LoginUtil.markAsLogin(ctx.channel());
        } else {
            loginResponsePacket.setReason("账户密码校验失败");
            loginResponsePacket.setSuccess(false);
        }
        return loginResponsePacket;
    }

    private ByteBuf login(LoginRequestPacket packet, ChannelHandlerContext ctx) {
        LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
        loginResponsePacket.setVersion(packet.getVersion());
        if (valid(packet)) {
            loginResponsePacket.setSuccess(true);
        } else {
            loginResponsePacket.setReason("账户密码校验失败");
            loginResponsePacket.setSuccess(false);
        }
        // 编码
        ByteBuf responseByteBuf = PacketCodeC.getInstance().encode(ctx.alloc(), loginResponsePacket);
        return responseByteBuf;
    }
    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return true;
    }
}
