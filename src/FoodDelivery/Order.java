package FoodDelivery;

public class Order {
    private int id;
    private String customerName;
    private String foodName;

    public Order(int id, String customerName, String foodName) {
        this.id = id;
        this.customerName = customerName;
        this.foodName = foodName;
    }

    @Override
    public String toString() {
        return "Order-" + id + " (" + foodName + " for " + customerName + ")";
    }
}
