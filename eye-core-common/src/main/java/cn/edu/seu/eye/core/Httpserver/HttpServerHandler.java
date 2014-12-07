package cn.edu.seu.eye.core.Httpserver;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;
import sun.nio.fs.WindowsFileSystemProvider;

import static io.netty.handler.codec.http.HttpHeaders.Names.CONNECTION;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_TYPE;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_LENGTH;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;


/**
 * Created by zwb on 2014/12/5.
 */
public class HttpServerHandler extends ChannelInboundHandlerAdapter{
	private static final byte[] CONTENT = {'H','e','l','l','o','W','o','r','l','d'};

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx){
		ctx.flush();
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx,Object msg){
//		if(msg instanceof HttpRequest){
//			HttpRequest req = (HttpRequest)msg;
//			if(HttpHeaders.is100ContinueExpected(req)){
//				ctx.write(new DefaultFullHttpResponse
//				(HTTP_1_1, OK, Unpooled.wrappedBuffer(CONTENT)));
//			}
//			boolean keepAlive = HttpHeaders.isKeepAlive(req);
//			FullHttpResponse response =
//					new DefaultFullHttpResponse
//							(HTTP_1_1,OK,Unpooled.copiedBuffer(req.getUri(), CharsetUtil.UTF_8));
//			response.headers().set(CONTENT_TYPE,"text/plain");
//			response.headers().set(CONTENT_LENGTH,response.content().readableBytes());
//
//			if(!keepAlive) {
//				ctx.write(response).addListener(ChannelFutureListener.CLOSE);
//			}
//			else{
//				response.headers().set(CONNECTION, HttpHeaders.Values.KEEP_ALIVE);
//				ctx.write(response);
//			}
//			System.out.println("**********" + req.getUri().toString());
//
//		}
		if(msg instanceof  HttpContent){
			HttpContent content = (HttpContent)msg;
			ByteBuf buf = content.content();
			String data = buf.toString(CharsetUtil.UTF_8);
			System.out.println("***********http content:" + data);
			buf.release();
		}
//		if(msg instanceof LastHttpContent){
//			System.out.println("**********last http content");
//		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
		cause.printStackTrace();
		ctx.close();
	}
}
