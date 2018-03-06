import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;



public class Main {

	public static void main(String[] args) {
		  //In case of local machine
		  String serverName = "127.0.0.1";
	      int port = 889;
	      
	      Employee emp = new Employee();
	      emp.name = "Reyan Ali";
	      emp.address = "Phokka Kuan";
	      emp.SSN = 11122333;
	      emp.number = 101;
	      
	      try
	      {
	         System.out.println("Connecting to " + serverName
	                             + " on port " + port);
	         
	         //Trying to connect to the server.
	         Socket client = new Socket(serverName, port);
	         
	         //Connected to the server
	         System.out.println("Just connected to "
	                      + client.getRemoteSocketAddress());
	         
	         OutputStream outToServer = client.getOutputStream();
	         
//	         DataOutputStream out =
//	                       new DataOutputStream(outToServer);
	         //Sending a message to the server.
//	         out.writeUTF("Hello from "
//	                      + client.getLocalSocketAddress());
	         
	         ObjectOutputStream out = new ObjectOutputStream(outToServer);
	         out.writeObject(emp);
	         
	         //Taking response from the server.
	         InputStream inFromServer = client.getInputStream();
	         DataInputStream in =
	                        new DataInputStream(inFromServer);
	         System.out.println("Server says " + in.readUTF());
	         
	         client.close();
	      }catch(IOException e)
	      {
	         e.printStackTrace();
	      }
	}

}
