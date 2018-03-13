
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;


public class ChatServer {
	
	private final int _port;
	public ChatServer(int port)
	{
		this._port = port;
	}
	
	/**
	 * Main server method
	 * @throws InterruptedException 
	 */
	public void Run() throws InterruptedException
	{
		//For incoming
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		//For dispatching
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		
		try
		{
			ServerBootstrap bootstrap = new ServerBootstrap()
				.group(bossGroup,workerGroup)
				.channel(NioServerSocketChannel.class)
				.childHandler(new ChatServerInit());
			
			//Starting the server on the specified port
			bootstrap.bind(_port).channel().closeFuture().sync();
		}
		finally
		{
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}
}
