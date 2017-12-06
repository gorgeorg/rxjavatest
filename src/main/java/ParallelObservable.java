import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import java.util.Timer;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * https://praveer09.github.io/technology/2016/02/29/rxjava-part-3-multithreading/
 */
public class ParallelObservable {
    public static void main(String[] args) {
        ParallelObservable app = new ParallelObservable();
        Observable.fromCallable(thatReturnsNumberOne())     // the Observable
                .subscribeOn(Schedulers.newThread())        // method tells the RxJava to perform the computation, declared as part of the Observable
                .map(numberToString())                      // the Operator
                .observeOn(Schedulers.newThread())          // subscriber on different thread
                .subscribe(printResult());                  // the Subscriber
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static Callable<Integer> thatReturnsNumberOne() {
        return () -> {
            System.out.println("Observable thread: " + Thread.currentThread().getName());
            return 1;
        };
    }

    private static Function<Integer, String> numberToString() {
        return number -> {
            System.out.println("Operator thread: " + Thread.currentThread().getName());
            return String.valueOf(number);
        };
    }

    private static Consumer<String> printResult() {
        return result -> {
            System.out.println("Subscriber thread: " + Thread.currentThread().getName());
            System.out.println("Result: " + result);
        };
    }
}
