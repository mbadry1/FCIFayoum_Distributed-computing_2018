import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundMessageHandlerAdapter;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;


public class ChatServerHandler extends ChannelInboundMessageHandlerAdapter<String>{

	private static final ChannelGroup _channels = new DefaultChannelGroup();
	
	@Override
	public void messageReceived(ChannelHandlerContext arg0, String arg1)
			throws Exception {
		Channel incoming = arg0.channel();
		
		for(Channel ch : _channels)
		{
			if(ch != incoming)
			{
				ch.write("["+ incoming.remoteAddress() +"] " + arg1 + "\n");
			}
		}
		
	}
	
	
	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		Channel incoming = ctx.channel();
		for(Channel ch : _channels)
		{
			ch.write("[Server] - "+ incoming.remoteAddress() + " has joined!\n");
		}
		
		_channels.add(incoming);
	}
	
	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		Channel incoming = ctx.channel();
		for(Channel ch : _channels)
		{
			ch.write("[Server] - "+ incoming.remoteAddress() + " has left!\n");
		}
		_channels.remove(incoming);
	}
	
}
