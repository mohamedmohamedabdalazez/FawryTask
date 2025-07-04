import java.util.List;

public class Customer {
    private String name;
    private double balance;
    private Cart cart = new Cart();

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }
    public void deduct(double amount) throws Exception{
        if (amount > balance) {
            throw new Exception("Not enough balance.");
        }
        balance -= amount;
    }

    public void addToCart(Product product, int quantity) throws Exception {
        cart.add(product, quantity);
    }
    public void checkout() throws Exception {
        if (cart.isEmpty()) {
            throw new Exception("Cart is empty");
        }

        double subtotal = cart.getSubtotal();
        List<CartItem> shippableItems = cart.getShippableItems();
        double shippingFee = calculateShippingFee(shippableItems);
        double total = subtotal + shippingFee;

        if (balance < total) {
            throw new Exception("Not enough balance");
        }

        balance -= total;

        System.out.println("---- Checkout Details ----");
        System.out.printf("Subtotal: $%.2f\n", subtotal);
        System.out.printf("Shipping Fees: $%.2f\n", shippingFee);
        System.out.printf("Total Paid: $%.2f\n", total);
        System.out.printf("Remaining Balance: $%.2f\n", balance);

        ShippingService.printShippingNotice(shippableItems);
    }

    private double calculateShippingFee(List<CartItem> items) {
        double totalWeight = 0.0;
        for (CartItem item : items) {
            totalWeight += item.getTotalWeightInKg();
        }
        return totalWeight;
    }
}
