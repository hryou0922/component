package com.hry.component.netty.byte2message;

import com.alibaba.fastjson.JSON;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;


public class RpcClient {
	
	public static void main(String[] args) throws InterruptedException {
		EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group).channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    public void initChannel(SocketChannel channel) throws Exception {
                        channel.pipeline()
                            .addLast(new RpcEncoder()) // 将 RPC 请求进行编码（为了发送请求）
                            .addLast(new RpcDecoder()) // 将 RPC 响应进行解码（为了处理响应）
//                            .addLast(RpcClient.this); // 使用 RpcClient 发送 RPC 请求
                            ;
                    }
                })
                .option(ChannelOption.SO_KEEPALIVE, true);
 
            ChannelFuture future = bootstrap.connect("127.0.0.1", 7007).sync();
            RpcRequest req = new RpcRequest();
            
            int num = 100;
            while(num-- > 0){
            	req.setName("nass22222" + num);
            	future.channel().writeAndFlush(JSON.toJSONString(req)).sync();
            	Thread.sleep(500);
            }
 
//            synchronized (obj) {
//                obj.wait(); // 未收到响应，使线程等待
//            }
// 
//            if (response != null) {
//                
//            }
            
            future.channel().closeFuture().sync();
//            System.out.println(response);
        } finally {
            group.shutdownGracefully();
        }
	}
}
