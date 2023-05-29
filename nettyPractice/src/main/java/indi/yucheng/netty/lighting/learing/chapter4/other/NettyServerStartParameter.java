package indi.yucheng.netty.lighting.learing.chapter4.other;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

public class NettyServerStartParameter {
    public static void main(String[] args) {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        // boss 对应中IOServer中 创建新链接
        NioEventLoopGroup boss = new NioEventLoopGroup();
        // worker 对应IOServer中，读取数据以及业务逻辑
        NioEventLoopGroup worker = new NioEventLoopGroup();

        serverBootstrap.group(boss, worker).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel ch) throws Exception {
                ch.pipeline().addLast(new StringDecoder());
                ch.pipeline().addLast(new SimpleChannelInboundHandler<String>() {
                    @Override
                    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String msg) throws Exception {
                        System.out.println(msg);
                    }
                });
            }
        });
        // 服务端channel NioServerSocketChannel指定一些自定义属性
        serverBootstrap.attr(AttributeKey.newInstance("serverName"), "nettyServer");
        // 每一个连接都指定自定义属性
        serverBootstrap.childAttr(AttributeKey.newInstance("clientKey"), "clientValue");


        // 服务端channel设置TCP参数 ：表示系统临时存放已完成三次握手的请求队列的最大长度（如果服务端创建连接较慢，则可以适当调大这个参数）
        serverBootstrap.option(ChannelOption.SO_BACKLOG,1024);
        // 每个连接设置TCP参数
        /**
         * 1.是否开启TCP底层心跳机制， true开启
         * 2.是否开启nagle算法， true关闭（如果要求高实时性，有数据发送时立即发送，设置为关闭）
         */
        serverBootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
        serverBootstrap.childOption(ChannelOption.TCP_NODELAY, true);
    }
}
