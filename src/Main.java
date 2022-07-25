import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.LongAdder;

public class Main {

    static LongAdder totalRevenue = new LongAdder();

    public static void main(String[] args)  {

        int[][] shopsRevenue = {
                {1_000, 2_000, 3_000},
                {4_000, 10_000, 6_000},
                {7_000, 8_000, 9_000}
        };

        List<Thread> threads = new ArrayList<>();

        //Создание потоков
        for (int i = 0; i < shopsRevenue.length; i++) {
            int finalI = i;
            threads.add(
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            //Генерация массива выручки по каждому магазину
                            int[] shopRevenue = new int[shopsRevenue[finalI].length];
                            for (int j = 0; j < shopsRevenue[finalI].length; j++) {
                                shopRevenue[j] = shopsRevenue[finalI][j];
                            }
                            calculateRevenue(shopRevenue);
                        }
                    })
            );
        }

        //Старт потоков
        for (Thread t : threads) {
            t.start();
        }

        //Ожидание завершения работы потоков
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Общая выручка составила " + totalRevenue + "₽");
    }

    public static void calculateRevenue(int[] revenue) {
        for (int i = 0; i < revenue.length; i++) {
            totalRevenue.add(revenue[i]);
        }
    }
}
