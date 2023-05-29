package indi.yucheng.netty.lighting.practice.chapter15.handler;

import indi.yucheng.netty.lighting.practice.base.util.LoginUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class AuthHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (!LoginUtil.hasLogin(ctx.channel())) {
            ctx.channel().close();
        } else {
            // 实现逻辑的删除，避免之后重复校验
            ctx.pipeline().remove(this);
            super.channelRead(ctx,msg);
        }
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) {
        if (LoginUtil.hasLogin(ctx.channel())) {
            System.out.println("当前连接登录验证完毕，无须再次验证， AuthHandler 被移除");
        } else {
            System.out.println("无登录验证，强制关闭连接！");
        }
    }
}
