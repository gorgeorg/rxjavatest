package java9;

import io.reactivex.Flowable;
import io.reactivex.subscribers.DisposableSubscriber;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

/**
 * Created by gorge on 26.11.2017.
 */
public class SimpleParallelFlowable {
    public static void main(String[] args) {
        Flowable.range(0, 100)
                .subscribe(new Subscriber<Integer>() {

                    @Override
                    public void onSubscribe(Subscription subscription) {
                        //subscription.request(10);
                    }

                    @Override
                    public void onNext(Integer i) {
                        System.out.println(i);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println(throwable);
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("complete");
                    }
                });
    }
}
