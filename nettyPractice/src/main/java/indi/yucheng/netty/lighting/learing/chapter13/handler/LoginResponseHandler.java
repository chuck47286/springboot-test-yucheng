package indi.yucheng.netty.lighting.learing.chapter13.handler;

import indi.yucheng.netty.lighting.learing.chapter13.util.LoginUtil;
import indi.yucheng.netty.lighting.learing.chapter8.LoginResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;

public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket loginResponsePacket) throws Exception {
        // 0.标记登录状态
        LoginUtil.markAsLogin(ctx.channel());
        ctx.channel().writeAndFlush(login(loginResponsePacket));
    }

    private Object login(LoginResponsePacket packet) {
        LoginResponsePacket loginResponsePacket = (LoginResponsePacket) packet;
        if (loginResponsePacket.isSuccess()) {
            /**
             *              // 0.标记登录状态
             *             LoginUtil.markAsLogin(ctx.channel());
             */

            System.out.println(new Date() + ": 客户端登录成功");
        } else {
            System.out.println(new Date() + ": 客户端登录失败，原因： " + loginResponsePacket.getReason());
        }
        return loginResponsePacket;
    }
}
