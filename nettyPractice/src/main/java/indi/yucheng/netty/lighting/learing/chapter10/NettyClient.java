package indi.yucheng.netty.lighting.learing.chapter10;

import indi.yucheng.netty.lighting.learing.chapter10.data.MessageRequestPacket;
import indi.yucheng.netty.lighting.learing.chapter10.handler.ClientHandler;
import indi.yucheng.netty.lighting.learing.chapter10.util.LoginUtil;
import indi.yucheng.netty.lighting.learing.chapter8.PacketCodeC;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Scanner;

public class NettyClient {
    public static void main(String[] args) throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();

        bootstrap.group(group).channel(NioSocketChannel.class).handler(new ChannelInitializer<Channel>() {
            @Override
            protected void initChannel(Channel ch) throws Exception {
                ch.pipeline().addLast(new ClientHandler());

            }
        });
        // TODO：启动改造
//        bootstrap.connect("127.0.0.1", 8000);
        String host = "127.0.0.1";
        int port = 8000;
        connect(bootstrap, host, port, 3);

    }
    private static void connect(Bootstrap bootstrap, String host, int port, int retry) {
        bootstrap.connect(host, port).addListener(future -> {
            if (future.isSuccess()) {
                Channel channel = ((ChannelFuture)future).channel();
                //连接成功之后，启动控制台线程
                startConsoleThread(channel);
            } else {
                // ...
                System.out.println("客户端启动失败");
            }
        });
    }

    private static void startConsoleThread(Channel channel) {
        new Thread(() -> {
            while (!Thread.interrupted()) {
                if (LoginUtil.hasLogin(channel)) {
                    System.out.println("输入消息发送至服务端： ");
                    Scanner sc = new Scanner(System.in);
                    String line = sc.nextLine();

                    MessageRequestPacket packet = new MessageRequestPacket();
                    packet.setMessage(line);
                    ByteBuf byteBuf = PacketCodeC.getInstance()
                            .encode(channel.alloc(), packet);
                    channel.writeAndFlush(byteBuf);
                }
            }
        }).start();
    }
}
