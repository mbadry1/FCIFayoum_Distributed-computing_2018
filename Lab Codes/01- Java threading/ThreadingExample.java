
public class ThreadingExample {

	public static void main(String[] args) {
		Count cnt = new Count();
	       try
	       {
	          while(cnt.mythread.isAlive())
	          {
	            System.out.println("Main thread will be alive till the child thread is live"); 
	            Thread.sleep(1500);
	          }
	       }
	       catch(InterruptedException e)
	       {
	          System.out.println("Main thread interrupted");
	       }
	       System.out.println("Main thread run is over" );
	}

}
