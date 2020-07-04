package com.imalvisc.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * @author chenjiaming
 * @version Id: SimpleNettyClient.java, v 0.1 2020-07-04 16:49 chenjiaming Exp $$
 */
public class SimpleNettyClient {

	public static void main(String[] args) throws Exception {
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			Bootstrap bootstrap = new Bootstrap();
			bootstrap.group(group)
					.channel(NioSocketChannel.class)
					.remoteAddress(new InetSocketAddress("127.0.0.1", 6888))
					.handler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast(new SimpleClientHandler());
						}
					});
			ChannelFuture f = bootstrap.connect().sync();
			f.channel().closeFuture().sync();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			group.shutdownGracefully().sync();
		}
	}

}
