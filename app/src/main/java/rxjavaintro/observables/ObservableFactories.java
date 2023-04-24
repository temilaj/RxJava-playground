package rxjavaintro.observables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import rxjavaintro.utils.Util;

public class ObservableFactories {

    public Observable<String> itemObservable = Observable.just("item1", "item2");

    private List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3));
    public Observable<Integer> listObserverable = Observable.fromIterable(numbers);

    public Observable<Integer> rangeObservable = Observable.range(2, 5);
    // public Observable<Long> intervalObservable = Observable.interval(1, TimeUnit.SECONDS);
    public Observable<Long> timerObservable = Observable.timer(5, TimeUnit.SECONDS);


    /* 
        single emits only one itme, so we don't need an onNext or onComplete, just an OnSuccess.
        great for HTTP responses.
    */ 
    public Single<String> userSingle = createUserSingle();

    public Maybe<String> fileMaybe = createFileMaybe();

    private static Single<String> createUserSingle() {
        return Single.create(emitter -> {
            String users = Util.fetchUsers();

            if (users != null) {
                emitter.onSuccess(users);
            } else {
                emitter.onError(new Exception("users not found"));
            }
        });
    }


    private static Maybe<String> createFileMaybe() {
        return Maybe.create(emitter -> {
            String fileContent = Util.readFile();

            if (fileContent != null) {
                emitter.onSuccess(fileContent);
            } else {
                emitter.onComplete();
            }
        });
    }

}
