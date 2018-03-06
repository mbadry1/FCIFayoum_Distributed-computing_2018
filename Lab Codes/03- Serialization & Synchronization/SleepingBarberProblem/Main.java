
public class Main {

	public static void main(String[] args) {
		try {
			Shop shop = new Shop();
			shop.init();
			System.out.println("From Shop: Shop has opened..");
			
			//No customers for 5 seconds
			System.out.println("From Shop: No customers for 5 seconds..");
			Thread.sleep(5000);
			
			//Customer 1 arrived
			Customer customer1 = new Customer();
			customer1.Name = "customer1";
			customer1.Id = 1;
			System.out.println("From Shop: Customer 1 arrived..");
			shop.acquireChair(customer1);
			System.out.println("From Shop: Customer 1 has sit..");
			Thread.sleep(1000);
			
			//Customer 2 arrived
			Customer customer2 = new Customer();
			customer2.Name = "customer2";
			customer2.Id = 2;
			System.out.println("From Shop: Customer 2 arrived..");
			shop.acquireChair(customer2);
			System.out.println("From Shop: Customer 2 has sit..");
			Thread.sleep(1000);		
			
			//Customer 3 arrived
			Customer customer3 = new Customer();
			customer3.Name = "customer3";
			customer3.Id = 3;
			System.out.println("From Shop: Customer 3 arrived..");
			shop.acquireChair(customer3);
			System.out.println("From Shop: Customer 3 has sit..");
			Thread.sleep(1000);
			
			System.out.println("From Shop: No customers for 5 seconds..");
			Thread.sleep(5000);
			
			//Customer 4 arrived
			Customer customer4 = new Customer();
			customer4.Name = "customer4";
			customer4.Id = 4;
			System.out.println("From Shop: Customer 4 arrived..");
			shop.acquireChair(customer4);
			System.out.println("From Shop: Customer 4 has sit..");
			Thread.sleep(1000);
			
			System.out.println("From Shop:Shop is closing..No more customers are allowed..");
			System.out.println("From Shop:Finishing current customers..");
			Thread.sleep(3000);
			
			System.out.println();
			System.out.println();
			System.out.println("From Shop: Shop are closed.."+"Number of customers: " + shop.getSuccessfulHaircutCount());
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
