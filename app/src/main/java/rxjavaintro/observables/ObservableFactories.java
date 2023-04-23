package rxjavaintro.observables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class ObservableFactories {

    public Observable<String> itemObservable = Observable.just("item1", "item2");

    private List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3));
    public Observable<Integer> listObserverable = Observable.fromIterable(numbers);

    public Observable<Integer> rangeObservable = Observable.range(2, 5);
    // public Observable<Long> intervalObservable = Observable.interval(1, TimeUnit.SECONDS);
    public Observable<Long> timerObservable = Observable.timer(5, TimeUnit.SECONDS);
}
