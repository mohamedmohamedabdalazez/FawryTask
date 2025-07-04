public abstract class Product {
    protected String name;
    protected double price;
    protected int quantity;
    protected boolean requireShipping;
    protected double weight;
    public Product(String name, double price, int quantity, boolean requireShipping, double weight) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.requireShipping = requireShipping;
        this.weight = requireShipping ? weight : 0.0;
    }

    public boolean isAvailable(int requestedQuantity ) {
        return requestedQuantity <= quantity;
    }

    public void reduceQuantity(int qty) {
        this.quantity -= qty;
    }

    public boolean isShippable() {
        return requireShipping;
    }

    public double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
