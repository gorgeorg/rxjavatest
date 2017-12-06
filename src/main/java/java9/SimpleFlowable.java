package java9;

import io.reactivex.Flowable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * Created by gorge on 26.11.2017.
 */
public class SimpleFlowable {
    public static void main(String[] args) {
        Flowable.range(0, 100)
                .subscribe(new Subscriber<Integer>() {
                    public Subscription subscription;

                    @Override
                    public void onSubscribe(Subscription subscription) {
                        this.subscription = subscription;
                        subscription.request(10);
                    }

                    @Override
                    public void onNext(Integer i) {
                        System.out.println(i);
                        if (i.intValue() == 5) {
                            subscription.request(10);
                        }
                        if (i.intValue() == 20) {
                            subscription.cancel();
                        }
                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }

                    @Override
                    public void onComplete() {
                        System.out.println("complete");
                    }
                });
    }
}
