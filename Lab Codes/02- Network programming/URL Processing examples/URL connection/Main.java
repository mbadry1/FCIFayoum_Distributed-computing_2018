import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;




public class Main {

	public static void main(String[] args) {
		try
	      {
	         URL url = new URL("http://www.amrood.com");
	         URLConnection urlConnection = url.openConnection();
	         HttpURLConnection connection = null;
	         if(urlConnection instanceof HttpURLConnection)
	         {
	            connection = (HttpURLConnection) urlConnection;
	         }
	         else
	         {
	            System.out.println("Please enter an HTTP URL.");
	            return;
	         }
	         BufferedReader in = new BufferedReader(
	         new InputStreamReader(connection.getInputStream()));
	         String urlString = "";
	         String current;
	         while((current = in.readLine()) != null)
	         {
	            urlString += current;
	         }
	         System.out.println(urlString);
	      }catch(IOException e)
	      {
	         e.printStackTrace();
	      }

	}

}
