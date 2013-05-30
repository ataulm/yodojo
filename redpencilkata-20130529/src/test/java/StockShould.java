import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by ataulm on 29/05/13.
 */
public class StockShould {

    private final StockSystem stockSystem = new StockSystem();
    private static final double SHAMPOO_START_PRICE = 1;
    private static final int SHAMPOO_START_QUANTITY = 10000;
    private static final String SHAMPOO_START_ID = "Shampoo";

    private Product addShampooToStock() {
        return stockSystem.addProduct(SHAMPOO_START_ID,
                SHAMPOO_START_PRICE, SHAMPOO_START_QUANTITY);
    }

    @Test
    public void add_product_should_update_inventory() {
        Product product = addShampooToStock();

        double actualPrice = product.getPrice();
        int actualQuantity = product.getQuantity();

        assertThat(actualPrice, is(SHAMPOO_START_PRICE));
        assertThat(actualQuantity, is(SHAMPOO_START_QUANTITY));
    }

    @Test
    public void change_the_price_of_existing_item() {
        Product product = addShampooToStock();
        double newPrice = 20;

        stockSystem.modifyPrice(id, newPrice);
        double actualPrice = stockSystem.getPrice(id);

        assertThat(actualPrice, is(newPrice));
    }

    @Test
    public void price_reduction_of_five_percent_or_more_trigger_red_pencil_promo() {
        String id = "Shampoo";
        double price = 1;
        int quantity = 10;

        stockSystem.addProduct(id, price, quantity);
        assertThat(stockSystem.getProduct(id).isPromo(), is(false));

        double newPrice = 0.95;

        stockSystem.modifyPrice(id, newPrice);

        assertThat(stockSystem.getProduct(id).isPromo(), is(true));
    }

    @Test
    public void only_allow_steal_promo_on_red_promo() {
        String id = "Shampoo";
        double price = 1;
        int quantity = 10;

        stockSystem.addProduct(id, price, quantity);
        stockSystem.getProduct(id).setStealPromo(true);

        assertThat(stockSystem.getProduct(id).isStealPromo(), is(false));

        double newPrice = 0.95;
        stockSystem.modifyPrice(id, newPrice);
        stockSystem.getProduct(id).setStealPromo(true);

        assertThat(stockSystem.getProduct(id).isStealPromo(), is(true));
    }

    @Test
    public void should_not_allow_steal_promo_price_increase() {
        String id = "Shampoo";
        double price = 1;
        int quantity = 10;

        stockSystem.addProduct(id, price, quantity);

        double newPrice = 0.95;
        stockSystem.modifyPrice(id, newPrice);
        stockSystem.getProduct(id).setStealPromo(true);

        stockSystem.modifyPrice(id, 1.20);

        assertThat(stockSystem.getProduct(id).getPrice(), is(newPrice));
    }

    @Test
    public void reduce_steal_promo_by
}
