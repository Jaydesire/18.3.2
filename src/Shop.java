import java.math.BigDecimal;
import java.math.RoundingMode;

//public class Shop extends Thread {
//    public ThreadLocal<BigDecimal> calculateRevenue() {
//        var revenue = new ThreadLocal<BigDecimal>();
//        revenue.set(new BigDecimal(1).setScale(2, RoundingMode.DOWN));//.setScale(2));
//        System.out.println("Выручка " + Thread.currentThread().getName()
//                + " составила " + revenue.get() + "₽");
//        return revenue;
//    }
//
//    @Override
//    public void run() {
//        Main.totalRevenue.set(calculateRevenue()
//                .get()
//                .add(Main.totalRevenue.get()));
//    }
//}

public class Shop  {

   private int[] revenue;
    Shop(int[] revenue){
     this.revenue = revenue;
    }
    public int[] getRevenue() {
        return revenue;
    }


}