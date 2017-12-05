import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by gorge on 05.12.2017.
 */
public class ParallelObservable {
    public static void main(String[] args) {
        Observable.range(0, 10)
                .flatMap(i -> Observable.just(longOperation(i)))
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.computation())
                //.observeOn(Schedulers.newThread())
                .subscribe(i -> System.out.println(Thread.currentThread() + " :" + i));

    }

    private static Integer longOperation(Integer i) {
        Integer res = i += 2;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread() + " i=" + i);
        return res;
    }
}
