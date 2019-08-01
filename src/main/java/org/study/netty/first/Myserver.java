package org.study.netty.first;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.AttributeKey;

/**
 * Created by ArnoldLee on 18/9/11.
 */
public class Myserver {

    public static void main(String[] args) {
        EventLoopGroup bossGroup = new NioEventLoopGroup();//第一步建立bossGroup 接受数据然后转发给workerGroup ，是一个死循环
        EventLoopGroup workerGroup = new NioEventLoopGroup();//第二部 workerGroup 完成实际数据的处理，也是一个死循环
        try{
            ServerBootstrap serverBootstrap = new ServerBootstrap();//第三步。启动bossGroup和workerGroup
            serverBootstrap.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childOption(ChannelOption.TCP_NODELAY,true)
                    .childAttr(AttributeKey.newInstance("childAttr"),"childAttrValue")
                    .handler(new ServerHandler())
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
//                            ch.pipeline().addBefore();
                        }
                    });
            ChannelFuture channelFuture = serverBootstrap.bind(8899).sync();//第四部，指定服务端的端口。
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
