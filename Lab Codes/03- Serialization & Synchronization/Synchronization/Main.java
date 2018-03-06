
public class Main {

	public static void main(String[] args) {
		PrintSomeNumbers PD = new PrintSomeNumbers();

	      ThreadExample T1 = new ThreadExample( "Thread - 1 ", PD );
	      ThreadExample T2 = new ThreadExample( "Thread - 2 ", PD );

	      T1.start();
	      T2.start();

	      //wait for threads to end
	      try {
	         T1.join();
	         T2.join();
	      } catch( Exception e) {
	         System.out.println("Interrupted");
	      }

	}

}
