package rxjavaintro.observables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import rxjavaintro.utils.Util;

public class ObservableFactories {

    public Observable<String> itemObservable = Observable.just("item 1", "item 2", "item 3");

    public Observable<String> wordsObservable = Observable.just("Hello", "Hi", "Observable", "World!", "Hello!", "Hello");
    public Observable<String> lettersObservable = Observable.just("a", "aa", "bb", "bb", "ccc", "ccc", "bbb", "ccc");
    private List<Integer> numbers = new ArrayList<>(Arrays.asList(0,1,2,3));
    public Observable<Integer> listObserverable = Observable.fromIterable(numbers);

    public Observable<Integer> rangeObservable = Observable.range(2, 5);
    public Observable<Integer> numbersObservable = Observable.range(0, 20);

    public Observable<Long> intervalObservable = Observable.interval(1, TimeUnit.SECONDS);
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
