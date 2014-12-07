package cn.edu.seu.eye.core.Httpserver;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.util.SelfSignedCertificate;


/**
 * Created by zwb on 2014/12/5.
 */
public class HttpServer {
//	static final boolean SSL = System.getProperty("ssl") != null;
//	static final int PORT = Integer.parseInt(System.getProperty("port",SSL ? "8443" : "8080"));
	static final int PORT = 8080;

	public static void main(String[] args) throws Exception{
//		final SslContext sslCtx;
//		if(SSL){
//			SelfSignedCertificate ssc = new SelfSignedCertificate();
//			sslCtx = SslContext.newServerContext(ssc.certificate(),ssc.privateKey());
//		}
//		else {
//			sslCtx = null;
//		}

		EventLoopGroup bossGroup = new NioEventLoopGroup(1);
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.option(ChannelOption.SO_BACKLOG,1024);
			b.group(bossGroup,workerGroup)
					.channel(NioServerSocketChannel.class)
					.handler(new LoggingHandler(LogLevel.INFO))
					.childHandler(new HttpServerInitializer());

			Channel ch = b.bind(PORT).sync().channel();
			ch.closeFuture().sync();
		}
		finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}
}
