import io.reactivex.Observable;

import java.util.Iterator;

/**
 * Created by gorge on 26.11.2017.
 */
public class Simple {
    public static void main(String[] args) {
        Observable<Integer> just = Observable.just(1);
        System.out.println(just.getClass());
    }
}
