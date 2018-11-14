package com.realtimechaser.rudpserver;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.nio.NioDatagramChannel;

public class ServerInitializer extends ChannelInitializer<NioDatagramChannel> {
    private static final DefaultServerHandler SERVER_HANDLER = new DefaultServerHandler();

    @Override
    public void initChannel(NioDatagramChannel ch) {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(SERVER_HANDLER);
    }
}
