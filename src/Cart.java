import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void add(Product product, int quantity) throws Exception {
        items.add(new CartItem(product, quantity));
    }

    public List<CartItem> getItems() {
        return items;
    }

    public double getSubtotal() {
        double subtotal = 0.0;
        for (CartItem item : items) {
            subtotal += item.getTotalPrice();
        }
        return subtotal;
    }

    public double getTotalShippingWeight() {
        double total = 0.0;
        for (CartItem item : items) {
            total += item.getTotalWeightInKg();
        }
        return total;
    }
    public List<CartItem> getShippableItems() {
        List<CartItem> shippableItems = new ArrayList<>();
        for (CartItem item : items) {
            if (item.getProduct().isShippable()) {
                shippableItems.add(item);
            }
        }
        return shippableItems;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
