package rxjavaintro.flowables;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import rxjavaintro.models.Item;

import static java.lang.Thread.sleep;

public class Flowables {
    
    public void synchronousObservableExample() {
        Observable.range(1, 1000000)
                .map(id -> new Item(id))
                .subscribe(item -> {
                    sleep(1000);
                    System.out.println(String.format("Received item %1$s", item.id));
                });
    }

    public void asyncObservableExample() {
        Observable.range(1, 1000000)
                .map(id -> new Item(id))
                .observeOn(Schedulers.io())
                .subscribe(item -> {
                    sleep(1000);
                    System.out.println(String.format("Received item %1$s", item.id));
                });
        
        try {
            sleep(Long.MAX_VALUE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void asyncFlowableExample() {
        // by using flowable we apply back pressure to this example
        Flowable.range(1, 1000000)
                .map(Item::new)
                .observeOn(Schedulers.io())
                .subscribe(item -> {
                    sleep(1000);
                    System.out.println(String.format("Received item %1$s", item.id));
                });
        
        try {
            sleep(Long.MAX_VALUE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
