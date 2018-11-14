package com.realtimechaser.rudpserver;

import java.nio.charset.Charset;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;

public class DefaultServerHandler extends SimpleChannelInboundHandler<DatagramPacket> {
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        ctx.write("Server Connected");
        ctx.flush();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket packet) {
        ByteBuf buf = packet.content();
        String bufToStr = buf.toString(Charset.forName("utf-8"));
        System.out.println("received: " + bufToStr);
        ctx.write(new DatagramPacket(Unpooled.copiedBuffer(bufToStr, Charset.forName("utf-8")), packet.sender()));
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }
}
