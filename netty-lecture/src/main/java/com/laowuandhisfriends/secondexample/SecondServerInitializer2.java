package com.laowuandhisfriends.secondexample;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;


public class SecondServerInitializer3 extends ChannelInitializer<SocketChannel>{
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline cp = ch.pipeline();

        cp.addLast(new LengthFieldBasedFrameDecoder(
                Integer.MAX_VALUE, 0, 4, 0, 4));
        cp.addLast(new LengthFieldPrepender(4));
        cp.addLast(new StringDecoder(CharsetUtil.UTF_8));
        cp.addLast(new StringEncoder(CharsetUtil.UTF_8));
        cp.addLast(new SecondServerHandler3());
    }
}
