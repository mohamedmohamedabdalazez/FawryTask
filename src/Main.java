import java.util.*;

public class Main {
    public static void checkout(Customer customer, Cart cart) throws Exception {
        if (cart.isEmpty()) {
            throw new Exception("Cart is empty");
        }

        List<CartItem> items = cart.getItems();
        double subtotal = cart.getSubtotal();
        double totalWeight = cart.getTotalShippingWeight();
        double shippingFee = totalWeight * 27;
        double total = subtotal + shippingFee;

        customer.deduct(total);

        ShippingService.printShippingNotice(items);

        System.out.println("** Checkout receipt **");
        for (CartItem item : items) {
            System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + " " + (int) item.getTotalPrice());
        }

        System.out.println("----------------------");
        System.out.printf("Subtotal %.0f\n", subtotal);
        System.out.printf("Shipping %.0f\n", shippingFee);
        System.out.printf("Amount %.0f\n", total);
    }

    public static void main(String[] args) throws Exception {
        Product cheese = new Product("Cheese", 100, 5, true, 0.2) {};
        Product tv = new Product("TV", 500, 3, true, 2.0) {};
        Product scratchCard = new Product("Biscuits", 150, 10, true, 0.7) {};

        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(scratchCard, 1);

        Customer customer = new Customer("Mohammed", 1000);
        checkout(customer, cart);
    }
}
