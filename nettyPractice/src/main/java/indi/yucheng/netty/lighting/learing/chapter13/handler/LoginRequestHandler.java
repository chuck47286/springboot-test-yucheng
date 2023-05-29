package indi.yucheng.netty.lighting.learing.chapter13.handler;

import indi.yucheng.netty.lighting.learing.chapter8.LoginRequestPacket;
import indi.yucheng.netty.lighting.learing.chapter8.LoginResponsePacket;
import indi.yucheng.netty.lighting.learing.chapter8.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket loginRequestPacket) throws Exception {
        ctx.channel().writeAndFlush(login(loginRequestPacket));
    }

    private Object login(LoginRequestPacket packet) {
        LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
        loginResponsePacket.setVersion(packet.getVersion());
        if (valid(packet)) {
            loginResponsePacket.setSuccess(true);
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
