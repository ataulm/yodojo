/**
 * Created by ataulm on 29/05/13.
 */
public class Product {
    private String id;
    private int quantity;
    private double price;
    private boolean promo;
    private boolean stealPromo;

    public Product(String id, double price, int quantity) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns whether the item is currently on a Red Pencil Promo
     * @return
     */
    public boolean isPromo() {
        return promo;
    }

    public void setPromo(boolean promo) {
        this.promo = promo;
    }

    public boolean isStealPromo() {
        return stealPromo;
    }

    public void setStealPromo(boolean stealPromo) {
        if (isPromo())
            this.stealPromo = stealPromo;
    }

    /**
     * Updates the price of the product with the given id, with the given price
     * @param id
     * @param price
     */
    public void modifyPrice(double price) {
        double oldPrice = price;

        // Price increase is only allowed on non-steal promo items
        if (product.isStealPromo() && price > oldPrice) return;

        product.setPrice(price);

        // Check if 5% discount (or more) applied
        double difference = oldPrice - price;
        double reduction = difference / oldPrice * 100;
        if (reduction >= 5) product.setPromo(true);
    }
}
