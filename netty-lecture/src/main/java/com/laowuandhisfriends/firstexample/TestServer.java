package com.laowuandhisfriends.firstexample;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class TestServer {
    public static void main(String[] args) {

        // 创建两个事件循环线程组
        // boss线程组，接收请求，并转发请求给worker线程组
        // Nio内置一个死循环，用来不断接收请求，并在适当的时候以一种优雅的方式结束该循环
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // worker线程组，处理请求
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            // 便捷启动服务端的对象
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            // group：设置acceptor（parent）和client（child），用来处理ServerChannel和Channel的所有时间和IO
            // channel：设置Channel实例来源
            // childHandler：子处理，一般是自定义处理器
            serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new TestServerInitializer());

            // bind：绑定端口
            // sync：获取sync IO操作结果
            ChannelFuture channelFuture = serverBootstrap.bind(8899).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 优雅关闭
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
