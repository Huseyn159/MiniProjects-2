package FoodDelivery;

public class Main {
    public static void main(String[] args) {

        OrderQueue queue = new OrderQueue();

        Restaurant r1 = new Restaurant(queue, "McDonalds");
        Restaurant r2 = new Restaurant(queue, "BurgerKing");

        Courier c1 = new Courier(queue, "Courier-1");
        Courier c2 = new Courier(queue, "Courier-2");
        Courier c3 = new Courier(queue, "Courier-3");

        r1.start();
        r2.start();
        c1.start();
        c2.start();
        c3.start();
    }
}
