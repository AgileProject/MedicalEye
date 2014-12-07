package cn.edu.seu.eye.core.Httpserver;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslHandler;


/**
 * Created by zwb on 2014/12/5.
 */
public class HttpServerInitializer extends ChannelInitializer<SocketChannel>{
//	private final SslContext sslCtx;
//	public HttpServerInitializer(SslContext sslCtx){
//		this.sslCtx = sslCtx;
//	}

	@Override
	public void initChannel(SocketChannel ch){
		ChannelPipeline p = ch.pipeline();
//		if(sslCtx != null){
//			p.addFirst(new SslHandler(sslCtx.newEngine(ch.alloc())));
//		}
		p.addLast(new HttpServerCodec());
		p.addLast(new HttpServerHandler());
	}
}
