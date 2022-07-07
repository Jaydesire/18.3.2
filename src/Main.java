import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

public class Main {

    public static AtomicReference<BigDecimal> totalRevenue = new AtomicReference<>();
    public static void main(String[] args) {
        totalRevenue.set(new BigDecimal(0));
        int qtyShops = 3;
        Shop[] shops = new Shop[qtyShops];

        for (int i = 0; i < shops.length; i++) {
            Shop shop = new Shop();
            shops[i] = shop;
            shop.start();
        }

        for (int i = 0; i < shops.length; i++) {
            try {
                shops[i].join();
            } catch (InterruptedException e) {}
        }
        System.out.println("Общая выручка составила " + totalRevenue + "₽");
    }
}
