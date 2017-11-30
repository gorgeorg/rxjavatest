package java9;

import io.reactivex.Flowable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * Created by gorge on 26.11.2017.
 */
public class SimpleParallelFlowable {
    public static void main(String[] args) {
        Flowable.range(0, 100)
                .onBackpressureBuffer(2, () -> System.out.println("overflow"))
                .subscribe(new Subscriber<Integer>() {
                    public Subscription subscription;

                    @Override
                    public void onSubscribe(Subscription subscription) {
                        this.subscription = subscription;
                        subscription.request(2);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println(integer);
                        if (integer.intValue() % 3 == 0) {
                            try {
                                System.out.println("wait ");
                                Thread.sleep(1000);
                                subscription.request(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
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
