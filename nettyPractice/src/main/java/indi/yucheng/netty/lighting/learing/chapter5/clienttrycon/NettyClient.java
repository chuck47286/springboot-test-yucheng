package indi.yucheng.netty.lighting.learing.chapter5.clienttrycon;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class NettyClient {
    private static final Integer MAX_RETRY = 5;

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
        connect(bootstrap, "127.0.0.1", 80, new RetryHolder(MAX_RETRY));

    }
    static class RetryHolder {
        int val;
        public RetryHolder() {
            val = 0;
        }
        public RetryHolder(int val) {
            this.val = val;
        }
        public void increment() {
            val++;
        }
        public void release() {
            val--;
        }
        public int getVal() {
            return this.val;
        }
    }

    private static void connect(Bootstrap bootstrap, String host, int port, RetryHolder retry) {
        bootstrap.connect(host, port).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println("连接成功~");
            } else if (0 == retry.getVal()) {
                System.out.println(new Date() + "重连此时次数已用完，放弃连接！");
            } else {
                // 第几次重连
                int order = (MAX_RETRY - retry.getVal()) + 1;
                // 本次重连的间隔
                int delay = 1 << order;
                System.err.println(new Date() + ":连接失败，第" + order+"次重连。。。");
                retry.release();
                bootstrap.config().group().schedule(()->
                    connect(bootstrap, host, port, retry)
                , delay, TimeUnit.SECONDS);
            }
        });
    }
}
