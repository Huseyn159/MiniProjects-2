package FoodDelivery;

import java.util.Random;

public class Restaurant extends Thread {

    private OrderQueue queue;
    private String restaurantName;
    private static int counter = 1;
    private Random rnd = new Random();

    public Restaurant(OrderQueue queue, String restaurantName) {
        this.queue = queue;
        this.restaurantName = restaurantName;
    }

    @Override
    public void run() {
        try {
            while (counter <= 20) {
                Thread.sleep(rnd.nextInt(700) + 500);

                Order order = new Order(counter++,
                        "Customer-" + counter,
                        "Food-" + rnd.nextInt(5));

                System.out.println(restaurantName + " prepared: " + order);
                queue.placeOrder(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
