import java.io.IOException;


public class Main {

	public static void main(String[] args) throws InterruptedException, IOException {
		new ChatClient("localhost", 8000).Run();
	}

}
