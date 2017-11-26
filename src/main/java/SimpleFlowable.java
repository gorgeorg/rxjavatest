import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Iterator;

/**
 * Created by gorge on 26.11.2017.
 */
public class SimpleFlowable {
    public static void main(String[] args) {
        Flowable.range(1, 1000)
                .subscribe(new Subscriber<Integer>() {


                    @Override
                    public void onSubscribe(Subscription subscription) {
                        subscription.request(200);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println(integer);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
