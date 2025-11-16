package FoodDelivery;

import java.util.LinkedList;
import java.util.Queue;

public class OrderQueue {

    private final int CAPACITY = 5;
    private Queue<Order> queue = new LinkedList<>();

    public synchronized void placeOrder(Order order) throws InterruptedException {
        while (queue.size() == CAPACITY) {
            System.out.println("OrderQueue FULL. Restaurant waiting...");
            wait();
        }
        queue.add(order);
        System.out.println("New order added: " + order);
        notifyAll();
    }

    public synchronized Order takeOrder() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println("Courier waiting: No orders...");
            wait();
        }
        Order order = queue.poll();
        notifyAll();
        return order;
    }
}
