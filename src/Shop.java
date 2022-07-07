import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.locks.Lock;
import java.util.function.BinaryOperator;

public class Shop extends Thread {
    public ThreadLocal<BigDecimal> calculateRevenue() {
        var revenue = new ThreadLocal<BigDecimal>();
        revenue.set(new BigDecimal(Math.random() * 10_000_000).setScale(2, RoundingMode.DOWN));//.setScale(2));
        System.out.println("Выручка " + Thread.currentThread().getName()
                + " составила " + revenue.get() + "₽");
        return revenue;
    }

    @Override
    public void run() {
        Main.totalRevenue.set(calculateRevenue()
                .get()
                .add(Main.totalRevenue.get()));
    }
}
