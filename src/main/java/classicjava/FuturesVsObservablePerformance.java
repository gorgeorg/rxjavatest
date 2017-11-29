package classicjava;

import io.reactivex.Observable;
import io.reactivex.Single;

import java.util.concurrent.*;

public class FuturesVsObservablePerformance {

    private static void runTwoFeatures() throws Exception {
        long start = System.currentTimeMillis();
        ExecutorService executor = new ThreadPoolExecutor(4, 4, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());
        Future<String> f1 = executor.submit(new CallToRemoteServiceA());
        Future<String> f2 = executor.submit(new CallToRemoteServiceB());
        System.out.println("Init Features: " + (System.currentTimeMillis() - start) + "ms");
        System.out.println(f1.get() + " - " + f2.get() + " finished in " + (System.currentTimeMillis() - start) + " ms");
        System.out.println("*********************** finish runTwoFeatures");


    }

    private static void runTwoObservable() throws Exception {
        long start = System.currentTimeMillis();
        Single<String> o1 = Single.fromCallable(new CallToRemoteServiceA());
        Single<String> o2 = Single.fromCallable(new CallToRemoteServiceB());
        System.out.println("Init Observables: " + (System.currentTimeMillis() - start) + " ms");
        Single.zip(o1, o2, (s1, s2) -> s1 + " - " + s2)
                .subscribe(s -> System.out.println(s + " finished in " + (System.currentTimeMillis() - start) + " ms"));
        System.out.println("*********************** finish runTwoObservable");
    }

    public static void main(String args[]) {
        try {
            runTwoFeatures();
            runTwoObservable();
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