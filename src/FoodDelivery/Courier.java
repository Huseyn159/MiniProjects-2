package FoodDelivery;

public class Courier extends Thread {

    private OrderQueue queue;
    private String name;

    public Courier(OrderQueue queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Order order = queue.takeOrder();
                System.out.println(name + " is delivering " + order);
                Thread.sleep(1000);
                System.out.println(name + " delivered " + order);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
