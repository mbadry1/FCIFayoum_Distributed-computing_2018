import java.rmi.*;

public interface MyRemote extends Remote{
	public String SayHello() throws RemoteException; //Required Throws
	public boolean DoStaff() throws RemoteException;
}
