import java.util.ArrayList;

/**
 * Created by ataulm on 29/05/13.
 */
public class StockSystem {
    private final ArrayList<Product> stock = new ArrayList<Product>();

    /**
     * Adds Product to stock system.
     * @param id
     * @param price
     * @param quantity
     */
    public Product addProduct(String id, double price, int quantity) {
        Product product = new Product(id, price, quantity);
        stock.add(product);
    }

    public Product getProduct(String id) {
        for (Product product:stock) {
            if (product.getId().equalsIgnoreCase(id)) return product;
        }
        return null;
    }

    public double getPrice(String id) {
        Product product = getProduct(id);
        if (product != null) return product.getPrice();
        return -1;
    }

    public int getQuantity(String id) {
        Product product = getProduct(id);
        if (product != null) return product.getQuantity();
        return -1;
    }



}
