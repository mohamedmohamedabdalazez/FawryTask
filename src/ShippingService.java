import java.util.List;

public class ShippingService {
    public static void printShippingNotice(List<CartItem> items) {
        if (items.isEmpty()) {
            System.out.println("No items to be shipped.");
            return;
        }

        System.out.println("** Shipment notice **");

        double totalWeight = 0.0;

        for (CartItem item : items) {
            Product product = item.getProduct();
            int quantity = item.getQuantity();

            if (product.isShippable()) {
                double weightPerItemKg = product.getWeight();
                double weightPerItemGrams = weightPerItemKg * 1000;
                totalWeight += weightPerItemKg * quantity;

                System.out.println(quantity + "x " + product.getName() + " " + (int) weightPerItemGrams + "g");

            }
        }
        System.out.println("Total package weight " + totalWeight + "kg");
    }
}
