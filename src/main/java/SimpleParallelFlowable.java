import io.reactivex.Flowable;
import io.reactivex.parallel.ParallelFlowable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Arrays;

/**
 * Created by gorge on 26.11.2017.
 */
public class SimpleParallelFlowable {
    public static void main(String[] args) {
        ParallelFlowable<Integer> source = Flowable.range(1, 1000).parallel();

    }
}
