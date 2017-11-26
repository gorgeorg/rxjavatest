import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import org.reactivestreams.Subscriber;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Georgii_Goriachev on 8/15/2017.
 */
public class SimpleObservableAndObserver {
    public static void main(String[] args) {
//        Observable.create(
//                e -> {
//                    e.onNext(1);
//                    e.onNext(2);
//                    e.onNext(3);
//                    e.onError(new Throwable());
//                    e.onComplete();
//                })
//                .subscribe(new Observer<Object>() {
//                    Disposable disposable;
//
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        disposable = d;
//                        System.out.println("Disposable = " + d);
//                    }
//
//                    @Override
//                    public void onNext(Object o) {
//                        //if (o.equals(1)) disposable.dispose(); //terminate stream
//                        System.out.println(o);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        System.out.println(e);
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        System.out.println("complete");
//                    }
//                });


    }
}