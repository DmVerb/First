import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static int regionCode = 99;
    private static int countPool = Runtime.getRuntime().availableProcessors();
    private static int part = regionCode / countPool;

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(countPool);
        int count = regionCode / countPool;
        int first;
        int last = 1;
        for (int i = 1; i <= countPool; i++) {
            first = last;
            if (i == countPool) {
                last = regionCode + 1;
            } else {
                last = first + count;
            }
            int regionStart = first;
            int regionEnd = last;
            executorService.submit(new Loader(i, regionStart, regionEnd));
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);
        System.out.println((System.currentTimeMillis() - start) + " ms");
        /*      1 поток 35320мс
                2 потока 44810мс
                3 потока 41632мc
                4 потока 46520мс
                5 потока 57573мс
                6 потока 59323мс
                7 потока 71690мс
                8 потока 70499мс
                9 потока 74725мс*/


    }
}
