import java.util.Date;

public class ExpirableProduct extends Product {
    private Date expiryDate;

    public ExpirableProduct(String name, double price, int quantity, Date expiryDate, boolean requireShipping, double weight) {
        super(name, price, quantity, requireShipping, weight);
        this.expiryDate = expiryDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }
}
