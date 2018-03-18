import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.server.*;

public class MyRemoteImp extends UnicastRemoteObject implements MyRemote
{

	public String SayHello()
	{
		return "Hello from Section!";
	}
	public boolean DoStaff()
	{
		return true;
	}
	
	public MyRemoteImp() throws RemoteException   //Required
	{}
	
	public static void main(String[] args) {
		try {
			
			MyRemote service = new MyRemoteImp();
			Naming.rebind("remotehello", service);
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
	}

}
