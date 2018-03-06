
public class ThreadExample extends Thread{
		private String threadName;
	   PrintSomeNumbers  PD;

	   ThreadExample( String name,  PrintSomeNumbers pd){
	       threadName = name;
	        PD = pd;
	   }
	   public void run() {
		 System.out.println("Starting " +  threadName );
	     
//		 //No sync
//		 PD.printCount();
		 
		 //With sync
		 synchronized(PD) {
		        PD.printCount();
		 }
		 
	     System.out.println("Thread " +  threadName + " exiting.");
	   }
	   
}
