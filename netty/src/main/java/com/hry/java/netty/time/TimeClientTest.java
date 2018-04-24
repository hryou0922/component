package com.hry.java.netty.time;

import java.util.Random;

import com.hry.java.netty.NettyConstants;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class TimeClientTest {
	private static boolean first = true;
	
    public static void main(String[] args) throws Exception {
    	int num = 1;
    	while(num-- > 0){
    		new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						run2();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
    	}
    	Thread.sleep(1000 * 20);
    }

	public static void run2() throws InterruptedException {
		int port = NettyConstants.NETTY_PORT;
        String host = NettyConstants.NETTY_HOST;
        
        EventLoopGroup workerGroup = new NioEventLoopGroup(1);

        try {
            Bootstrap b = new Bootstrap(); // (1)
            b.group(workerGroup); // (2)
            b.channel(NioSocketChannel.class); // (3)
            b.option(ChannelOption.SO_KEEPALIVE, true); // (4)
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new TimeClientHandler());
                }
            });
            
            int num = 120;
            
            while(num-- > 0){
            	
            	new Thread(new Runnable() {
					public void run() {
			            // Start the client.
			            ChannelFuture f;
						try {
							if(first){
								Thread.sleep(1000);
//								first = false;
							}else{
								Random rd = new Random();
								Thread.sleep(rd.nextInt(1000));
							}
							long time = System.currentTimeMillis();
							f = b.connect(host, port).sync();
							// Wait until the connection is closed.
							f.channel().closeFuture().sync(); // (5)
							System.out.println("cost = " + (System.currentTimeMillis() - time));
							  
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}).start();;
            	
            }
        } finally {
        	Thread.sleep(1000 * 20);
            workerGroup.shutdownGracefully();
        }
	}
}