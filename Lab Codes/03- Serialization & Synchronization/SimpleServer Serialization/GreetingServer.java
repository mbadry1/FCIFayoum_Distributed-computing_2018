import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * @author MBadry
 * This class represent a simple server that waits for a client
 * at port: 889
 */
public class GreetingServer extends Thread{
	/**
	 * Main server socket object
	 */
	private ServerSocket serverSocket;
	
	/**
	 * Class constructor that initializes the server socket object
	 * @param port
	 * @throws IOException
	 */
	public GreetingServer() throws IOException
	{
		//the server socket constructor Attempts
	    //to create a server socket bound to the specified port. 
	    serverSocket = new ServerSocket(889);
	    //Sets the time-out value for how long the server
	    //socket waits for a client during the accept()
	    serverSocket.setSoTimeout(10000);
	}
	
	/**
	 * Main thread method
	 */
	public void run()
	   {
	      while(true)
	      {
	         try
	         {
	        	//getLocalPort: Returns the port that the server 
	        	//socket is listening on
	            System.out.println("Waiting for client on port " +
	            serverSocket.getLocalPort() + "...");
	            
	            //This method blocks until either a client connects to
	            //the server on the specified port.
	            Socket server = serverSocket.accept();
	            
	            //getRemoteSocketAddress: Returns the address of the remote socket
	            System.out.println("Just connected to "
	                  + server.getRemoteSocketAddress());
	            
	            //Returns the input stream of the socket. The input stream is connected to
	            //the output stream of the remote socket.
//	            DataInputStream in =
//	                  new DataInputStream(server.getInputStream());
//	            System.out.println(in.readUTF());
	            
	            ObjectInputStream in = new ObjectInputStream(server.getInputStream());
	            try {
					Employee emp = (Employee) in.readObject();
					emp.mailCheck();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
	            //Returns the output stream of the socket. The output stream is connected
	            //to the input stream of the remote socket
	            DataOutputStream out =
	                 new DataOutputStream(server.getOutputStream());
	            
	            //getLocalSocketAddress: gets server address
	            out.writeUTF("Thank you for connecting to "
	              + server.getLocalSocketAddress() + "\nGoodbye!");
	            
	            server.close();
	         }catch(SocketTimeoutException s)
	         {
	            System.out.println("Socket timed out!");
	         }catch(IOException e)
	         {
	            e.printStackTrace();
	            //break;
	         }
	      }
	   }
}
