package com.realtimechaser.rudpserver;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;

public class Client {
    public static void main(String[] args) throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
             .channel(NioDatagramChannel.class)
             .handler(new ServerInitializer());

            ChannelFuture f = b.bind("localhost", 0).sync();
            f.channel().writeAndFlush(new DatagramPacket(
                    Unpooled.copiedBuffer("hello~", Charset.forName("utf-8")),
                    new InetSocketAddress("localhost", 8080)));
            f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }
}
