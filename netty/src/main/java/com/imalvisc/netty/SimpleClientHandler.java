package com.imalvisc.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @author chenjiaming
 * @version Id: SimpleServerHandler.java, v 0.1 2020-07-04 16:40 chenjiaming Exp $$
 */
public class SimpleClientHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf buf = (ByteBuf) msg;
		System.out.println("接收到响应:" + buf.toString(CharsetUtil.UTF_8) + "，当前线程：" + Thread.currentThread().getName());
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		ctx.channel().writeAndFlush(Unpooled.copiedBuffer("您好，我是客户端".getBytes(CharsetUtil.UTF_8)));
	}
}
