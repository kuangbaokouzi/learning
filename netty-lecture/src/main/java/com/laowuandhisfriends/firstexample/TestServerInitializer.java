package com.laowuandhisfriends.firstexample;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * 自定义管道初始化，继承ChannelInitializer<C>
 */
public class TestServerInitializer extends ChannelInitializer<SocketChannel> {
    /**
     * 管道初始化方法
     *
     * @param ch
     * @throws Exception
     */
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        // pipeline：返回ChannelHandler列表对象
        ChannelPipeline channelPipeline = ch.pipeline();

        // addLast：追加一个ChannelHandler
        // HttpServerCodec：http编程中特别重要的一个组件
        channelPipeline.addLast("httpServerCodec", new HttpServerCodec());
        // 追加一个自定义ChannelHandler
        channelPipeline.addLast("testHttpServerHandler", new TestHttpServerHandler());
    }
}
