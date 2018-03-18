import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class Main {

	public static void main(String[] args) {
		new Main().Go();
	}

	public void Go()
	{
		try {
			MyRemote service =
				(MyRemote) Naming.lookup("rmi://127.0.0.1/remotehello");
			
			Boolean s = service.DoStaff();
			System.out.println(s);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
