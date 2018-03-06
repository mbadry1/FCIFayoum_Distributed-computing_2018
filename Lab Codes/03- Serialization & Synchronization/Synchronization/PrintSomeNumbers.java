
public class PrintSomeNumbers {
	public void printCount(){
	    try {
	         for(int i = 100; i > 0; i--) {
	            System.out.println("Counter   ---   "  + i );
	         }
	     } catch (Exception e) {
	         System.out.println("Thread  interrupted.");
	     }
	   }
}
