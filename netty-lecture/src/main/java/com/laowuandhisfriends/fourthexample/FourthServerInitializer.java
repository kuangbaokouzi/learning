package com.laowuandhisfriends.fourthexample;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

public class FourthServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline channelPipeline = ch.pipeline();

        // 空闲状态处理器，监控读、写、读写空闲
        channelPipeline.addLast(new IdleStateHandler(5,7,10, TimeUnit.SECONDS));
        channelPipeline.addLast(new FourthServerHandler());
    }
}
