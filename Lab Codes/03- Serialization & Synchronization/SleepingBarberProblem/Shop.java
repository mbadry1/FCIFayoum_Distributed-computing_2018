import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


public class Shop {
	private Barber barber;
	//Maximum number of customer
    private Semaphore semaphore;
    private AtomicInteger count = new AtomicInteger(0);

    public Shop() {
        semaphore = new Semaphore(3);
    }

    public void init() {
        barber = new Barber(this);
        //init delay & period
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(barber, 100,
                1000, TimeUnit.MILLISECONDS);
    }

    public void acquireChair(Customer customer) throws InterruptedException {
        boolean acquired = semaphore.tryAcquire(1, 100, TimeUnit.MILLISECONDS);
        if (acquired) {
            count.getAndIncrement();
            barber.addCustomerToQueue(customer);
            return;
        }
        System.out.println("Turning customer " + customer.Id + " away");
    }

    public void releaseChair() {
        semaphore.release(1);
    }

    public int getSuccessfulHaircutCount() {
        return count.intValue();
    }
}
