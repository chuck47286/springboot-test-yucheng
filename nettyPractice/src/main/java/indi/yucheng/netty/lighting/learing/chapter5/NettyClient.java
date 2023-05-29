package indi.yucheng.netty.lighting.learing.chapter5;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Date;

public class NettyClient {
    public static void main(String[] args) throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();


        bootstrap
                // 1.指定线程模型
                .group(group)
                // 2.指定IO类型为NIO
                .channel(NioSocketChannel.class)
                // 3.IO处理逻辑
                .handler(new ChannelInitializer<Channel>() {
            @Override
            protected void initChannel(Channel ch) throws Exception {
                ch.pipeline().addLast(new StringEncoder());

            }
        });
        // 4.建立连接
        bootstrap.connect("127.0.0.1", 8000).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println("连接成功~");
            } else {
                System.out.println("连接失败！");
            }
        });
        /**
         * Channel channel = bootstrap.connect("127.0.0.1", 8000).channel();
         *         while (true) {
         *             channel.writeAndFlush(new Date() + ":hello world~");
         *             Thread.sleep(2000);
         *         }
         */

    }
}
