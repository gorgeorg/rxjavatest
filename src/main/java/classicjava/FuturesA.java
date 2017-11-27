package classicjava;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FuturesA {

    public static void runTwoFeatures() throws Exception {
        ExecutorService executor = new ThreadPoolExecutor(4, 4, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());
        long start = System.currentTimeMillis();
        Future<String> f1 = executor.submit(new CallToRemoteServiceA());
        Future<String> f2 = executor.submit(new CallToRemoteServiceB());
        System.out.println((System.currentTimeMillis() - start));
        System.out.println(f1.get() + " - " + f2.get() + " finished in " + (System.currentTimeMillis() - start) + " ms");
        System.out.println("finish");
    }

    public static void main(String args[]) {
        try {
            runTwoFeatures();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final class CallToRemoteServiceA implements Callable<String> {
        @Override
        public String call() throws Exception {
            // simulate fetching data from remote service
            Thread.sleep(100);
            return "responseA";
        }
    }

    private static final class CallToRemoteServiceB implements Callable<String> {
        @Override
        public String call() throws Exception {
            // simulate fetching data from remote service
            Thread.sleep(40);
            return "responseB";
        }
    }

}