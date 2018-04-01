package com.hry.component.netty.byte2message;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class RpcServer {
	public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel channel) throws Exception {
                            channel.pipeline()
                                    .addLast(new RpcDecoder()) // 将 RPC 请求进行解码（为了处理请求）
                                    .addLast(new RpcEncoder()) // 将 RPC 响应进行编码（为了返回响应）
//                                    .addLast(new RpcHandler(handlerMap)); // 处理 RPC 请求
                                    ;
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
 
//            String[] array = serverAddress.split(":");
//            String host = array[0];
//            int port = Integer.parseInt(array[1]);
          
//              ChannelFuture future = bootstrap.bind(host, port).sync();
            	ChannelFuture future = bootstrap.bind(7007).sync();
//            System.out.println("server started on port " + port);
 
//            if (serviceRegistry != null) {
//                serviceRegistry.register(serverAddress); // 注册服务地址
//            }
 
            future.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
	}
}
