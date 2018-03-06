import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;


public class Barber implements Runnable{
	Queue<Customer> customers;

	//Reference to the shop he's working at
    private Shop shop;

    public Barber(Shop shop) {
        this.shop = shop;
        customers = new LinkedBlockingQueue<Customer>();
    }

    public void addCustomerToQueue(Customer customer) {
        customers.add(customer);
    }

    public void run() {
       
            
            try {
            	 while (!customers.isEmpty()) {
            	Customer customer = customers.remove();
				performHaircut(customer);
	            shop.releaseChair();
	            }
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

    }

    private void performHaircut(Customer customer) throws InterruptedException {
    	Thread.sleep(2000);
        System.out.println("From Barber: Customer " + customer.Id
                + " has got a haircut");

    }
}
