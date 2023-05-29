package indi.yucheng.netty.lighting.learing.chapter10.handler;

import indi.yucheng.netty.lighting.learing.chapter10.data.MessageRequestPacket;
import indi.yucheng.netty.lighting.learing.chapter10.data.MessageResponsePacket;
import indi.yucheng.netty.lighting.learing.chapter8.LoginRequestPacket;
import indi.yucheng.netty.lighting.learing.chapter8.LoginResponsePacket;
import indi.yucheng.netty.lighting.learing.chapter8.Packet;
import indi.yucheng.netty.lighting.learing.chapter8.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

public class ServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        /**
         * 逻辑 before
         *         // 接收数据逻辑
         *         ByteBuf bytebuf = (ByteBuf) msg;
         *         System.out.println(new Date() +":服务端读到数据 -->" +bytebuf.toString(Charset.forName("utf-8")));
         *         // 返回数据到客户端
         *         System.out.println(new Date() + ":服务端写出数据");
         *         ByteBuf out = getByteBuf(ctx);
         *         ctx.channel().writeAndFlush(out);
         *
         *
         * private ByteBuf getByteBuf(ChannelHandlerContext ctx) {
         *         byte[] bytes = "您好，欢迎关注我的微信公众号，《闪电侠blog》!".getBytes(Charset.forName("utf-8"));
         *         ByteBuf buffer = ctx.alloc().buffer();
         *         buffer.writeBytes(bytes);
         *         return buffer;
         *     }
         *
         */

        /**
         * 2.服务端处理登录请求
         * 2.1 获取到msg转为ByteBuf
         * 2.2 解码
         * 2.3 处理对象
         *
         * ==========
         * 2.4 对于登录响应的处理(封装在handleResponse)
         *
         */
        ByteBuf requestByteBuf = (ByteBuf) msg;
        // 解码
        Packet packet = PacketCodeC.getInstance().decode(requestByteBuf);

        // 判断 请求数据包 类型
        if (packet instanceof LoginRequestPacket) {
            // 登录请求
            LoginRequestPacket loginRequestPacket = (LoginRequestPacket) packet;
            /**
             * LoginRequestPacket loginRequestPacket = (LoginRequestPacket) packet;
             *             // 登录校验
             *             if (valid(loginRequestPacket)) {
             *                 // 校验成功
             *             } else {
             *                 // 校验失败
             *                 System.out.println("校验失败");
             *             }
             */
            handleLoginRequest(ctx, loginRequestPacket);
        } else if (packet instanceof MessageRequestPacket) {
            // 消息请求
            handleMessageRequest(ctx, packet);
            /**
             * 封装到方法 handleMessageResponse
             * MessageRequestPacket messageRequestPacket = (MessageRequestPacket) packet;
             *             System.out.println(new Date() + " : 收到客户端消息： " + messageRequestPacket.getMessage());
             *
             *             MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
             *             messageResponsePacket.setMessage("服务端回复【"+messageResponsePacket.getMessage()+"】");
             *             ByteBuf byteBuf = PacketCodeC.getInstance().encode(ctx.alloc(), messageResponsePacket);
             *             ctx.channel().writeAndFlush(byteBuf);
             */

        }


    }

    private void handleMessageRequest(ChannelHandlerContext ctx, Packet packet) {
        MessageRequestPacket messageRequestPacket = (MessageRequestPacket) packet;
        System.out.println(new Date() + " : 收到客户端消息： " + messageRequestPacket.getMessage());

        MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
        messageResponsePacket.setMessage("服务端回复 【"+messageRequestPacket.getMessage()+"】done~");

        ByteBuf byteBuf = PacketCodeC.getInstance().encode(ctx.alloc(), messageResponsePacket);
        ctx.channel().writeAndFlush(byteBuf);
    }

    private void handleLoginRequest(ChannelHandlerContext ctx , LoginRequestPacket packet) {
        LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
        loginResponsePacket.setVersion(packet.getVersion());
        loginResponsePacket.setVersion(packet.getVersion());
        if (valid(packet)) {
            loginResponsePacket.setSuccess(true);
        } else {
            loginResponsePacket.setReason("账户密码校验失败");
            loginResponsePacket.setSuccess(false);
        }
        // 编码
        ByteBuf responseByteBuf = PacketCodeC.getInstance().encode(ctx.alloc(), loginResponsePacket);
        ctx.channel().writeAndFlush(responseByteBuf);
    }

    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return true;
    }


}
