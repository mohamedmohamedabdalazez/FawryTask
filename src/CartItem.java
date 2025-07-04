public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) throws Exception {
        if (!product.isAvailable(quantity)) {
           throw new Exception("The product is not available");
        }
        this.product = product;
        this.quantity = quantity;
        product.reduceQuantity(quantity);
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }

    public double getTotalWeightInKg() {
        return product.isShippable() ? product.getWeight() * quantity : 0.0;
    }
}
