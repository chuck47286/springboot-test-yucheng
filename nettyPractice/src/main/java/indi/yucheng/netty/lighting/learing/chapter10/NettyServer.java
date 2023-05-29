package indi.yucheng.netty.lighting.learing.chapter10;

import indi.yucheng.netty.lighting.learing.chapter10.handler.ServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

public class NettyServer {
    public static void main(String[] args) {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        // boss 对应中IOServer中 创建新链接
        NioEventLoopGroup boss = new NioEventLoopGroup();
        // worker 对应IOServer中，读取数据以及业务逻辑
        NioEventLoopGroup worker = new NioEventLoopGroup();

        int port = 8000;
        serverBootstrap.group(boss, worker).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel ch) throws Exception {
                ch.pipeline().addLast(new ServerHandler());
            }
        }).bind(port).addListener(new GenericFutureListener<Future<? super Void>>() {
            @Override
            public void operationComplete(Future<? super Void> future) throws Exception {
                if (future.isSuccess()) {
                    System.out.println("端口["+ port +"]绑定成功~");
                } else {
                    System.out.println("端口["+port+"]绑定失败！");
                }
            }
        });

    }


}
