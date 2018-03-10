package com.laowuandhisfriends.fifthexample;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * websocket通道初始化类
 */
public class WebSocketChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        // 因为websocket基于http，所以需要http相关的处理器
        pipeline.addLast(new HttpServerCodec());
        // 以块的方式写的处理器
        pipeline.addLast(new ChunkedWriteHandler());
        // 对Http请求或响应的内容块进行聚合操作的处理器
        pipeline.addLast(new HttpObjectAggregator(8192));
        // 完成繁重任务的websocket服务器的处理器
        // 负责websocket握手并处理控制阵（关闭，乒，乓）
        // 参数websocketPath：http请求时的uri地址，比如：ws://localhost:8899/ws
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));

        // 自定义handler
        pipeline.addLast(new TextWebsocketFrameHandler());
    }
}
