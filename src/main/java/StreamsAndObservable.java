import io.reactivex.Observable;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by gorge on 26.11.2017.
 */
public class StreamsAndObservable {
    public static void main(String[] args) {
        IntStream.range(1, 10).boxed()
                .skip(3)
                .limit(5)
                .map(i -> i + " transformed")
                .flatMap(
                        s -> Arrays.stream(s.split("")))
                .forEach(
                        it -> System.out.println("=> " + it));

        Observable.range(1, 10)
                .skip(3)
                .take(5)
                .map(i -> i + " transformed")
                .flatMap(
                        s -> Observable.fromArray(s.split("")))
                .subscribe(
                        it -> System.out.println("=> " + it));
    }
}
