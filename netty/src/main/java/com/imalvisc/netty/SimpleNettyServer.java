package com.imalvisc.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author chenjiaming
 * @version Id: SimpleNettyServer.java, v 0.1 2020-07-04 16:35 chenjiaming Exp $$
 */
public class SimpleNettyServer {

	public static void main(String[] args) throws Exception {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {

			ServerBootstrap bootstrap = new ServerBootstrap()
					.group(bossGroup, workerGroup)
					.channel(NioServerSocketChannel.class)
					.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast(new SimpleServerHandler());
						}
					});
			for (int i = 0; i < 50; i++) {
				ChannelFuture f = bootstrap.bind(6888).sync();
				f.channel().closeFuture().sync();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			bossGroup.shutdownGracefully().sync();
			workerGroup.shutdownGracefully().sync();
		}
	}

}
