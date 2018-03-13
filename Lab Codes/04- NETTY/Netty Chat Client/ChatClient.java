import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;


public class ChatClient {
	
	private final String _host;
	private final int _port;
	
	public ChatClient(String host,int port)
	{
		this._host = host;
		this._port = port;
	}
	
	/**
	 * Main chat method
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public void Run() throws InterruptedException, IOException
	{
		//For incoming
		EventLoopGroup group = new NioEventLoopGroup();
		
		try
		{
			Bootstrap bootstrap = new Bootstrap()
				.group(group)
				.channel(NioSocketChannel.class)
				.handler(new ChatClientInit());
			
			Channel channel = bootstrap.connect(_host,_port).sync().channel();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
			while(true)
			{
				channel.write(in.readLine()+"\r\n");
			}
		}
		finally
		{
			group.shutdownGracefully();
		}
	}
}
