import java.io.IOException;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
	      {
			GreetingServer t = new GreetingServer();
	        t.start();
	      }catch(IOException e)
	      {
	         e.printStackTrace();
	      }
	}

}
