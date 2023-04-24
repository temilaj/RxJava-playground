/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package rxjavaintro;

import java.util.Scanner;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import rxjavaintro.completables.CompletableFactories;
import rxjavaintro.flowables.Flowables;
import rxjavaintro.observables.ObservableFactories;
import rxjavaintro.observers.Observers;

public class App {
    public static void basicObservable() {
        Observable<String> observable = Observable.create(emitter -> {
            emitter.onNext("clicked once");
            emitter.onNext("clicked twice");
            emitter.onNext("clicked thrice");
        });

        observable.subscribe(item -> {
            System.out.println(item);
        }, throwable -> {
            System.out.println(throwable.getMessage());
        }, () -> {
            System.out.println("completed!");
        });

    }

    public static void main(String[] args) {
        // basicObservable();
        ObservableFactories observableFactories = new ObservableFactories();
        Observers observers = new Observers();
        CompletableFactories completableFactories = new CompletableFactories();
        Flowables flowables = new Flowables();

        // observableFactories.itemObservable.subscribe(observers.itemObserver);
        // observableFactories.listObserverable.subscribe(observers.listObserver);
        // observableFactories.rangeObservable.subscribe(item -> {
        //     System.out.println(item);
        // });

        // observableFactories.intervalObservable.subscribe(item -> {
        //     System.out.println(item);
        // });

        // observableFactories.timerObservable.subscribe(item -> {
        //     System.out.println("5 seconds passed");
        // });
        // new Scanner(System.in).nextLine();

        

        // completableFactories.printCompletable.subscribe(() -> {
        //     System.out.println("Action ends");
        // });

        // observableFactories.userSingle.subscribe(observers.userObserver);

        // observableFactories.fileMaybe.subscribe(observers.filMaybeObserver);

        // completableFactories.deleteItemFromDBCompletable.subscribe(observers.dbCompletableObserver);
        
        // flowables.synchronousObservableExample();
        // flowables.asyncObservableExample();
        // flowables.asyncFlowableExample();


        // /*
        //  * cold obserables: each subscribed obsercer sees all the data emitted by the obserable
        //  */
        // observableFactories.itemObservable.subscribe((item) -> System.out.println(String.format("Observer 1 - %s ", item)));
        // observableFactories.itemObservable.subscribe((item) -> System.out.println(String.format("Observer 2 - %s ", item)));
        // observableFactories.itemObservable.subscribe((item) -> System.out.println(String.format("Observer 3 - %s ", item)));


        /*
         * hot obserables: new subscribed observers only see data from the point at which they subscribed.
         */
        // ConnectableObservable<Long> connectableObservable = observableFactories.intervalObservable.publish();

        // connectableObservable.connect();

        // connectableObservable.subscribe((item) -> System.out.println(String.format("Observer 1, sec: %s", item)));
       
        // try {
        //     Thread.sleep(5000);
        // } catch (InterruptedException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }

        // connectableObservable.subscribe((item) -> System.out.println(String.format("Observer 2, sec: %s", item)));

        // try {
        //     Thread.sleep(10000);
        // } catch (InterruptedException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }

        // connectableObservable.subscribe((item) -> System.out.println(String.format("Observer 3, sec: %s", item)));
        // new Scanner(System.in).nextLine();

        /*
         * Disposing observables with disposables
         */
        // Disposable itervalDisposable =  observableFactories.intervalObservable.subscribe(l -> System.out.println(String.format("item: %s", l)));

        // if (itervalDisposable.isDisposed()) {
        //     System.out.println("itervalDisposable calling dispose");
        //     itervalDisposable.dispose();
        // }
        // new Scanner(System.in).nextLine();

        // CompositeDisposable compositeDisposable = new CompositeDisposable();
        // Observer<Integer> disposableObserver = observers.createDisposableObserver(compositeDisposable);
        // observableFactories.rangeObservable.subscribe(disposableObserver);
        // System.out.println(" disposableObserver calling dipose");
        // compositeDisposable.dispose();

        // observableFactories.intervalObservable.subscribe(observers.itemResourceObserver);
        // if (observers.itemResourceObserver.isDisposed()) {
        //     System.out.println("itemResourceObserver calling dispose");
        //     observers.itemResourceObserver.dispose();
        // }
        // new Scanner(System.in).nextLine();




        /*
         * filtering operators
         */
        // observableFactories.wordsObservable
        //         .filter(item -> item.length() != 2)
        //         .skip(3)
        //         .distinct()
        //         .take(2)
        //         // .first("emtpy")
        //         // .last("emtpy")
        //         .subscribe(item -> System.out.println("item: "+ item));

        
        // observableFactories.numbersObservable
        //             // .takeWhile(item -> item % 2 ==0)
        //             .skipWhile(item -> item < 5)
        //             // .all(item -> item % 2 ==0)
        //             // .any(item -> item % 2 ==0)
        //             .defaultIfEmpty(-9999999)
        //             .switchIfEmpty(Observable.just(1,2,3))
        //             .subscribe(item -> System.out.println("value: "+ item));

        /*
         * transforming operators
         */
        observableFactories.rangeObservable
                .sorted()
                .scan((accum, item) -> accum + item)
                .buffer(3)
                .map(String::valueOf)
                .subscribe(item -> System.out.println("item: "+ item));

        observableFactories.lettersObservable
                .sorted()
                .groupBy(String::length)
                .flatMapSingle(group -> group.toList())
                .subscribe(item -> System.out.println("letter: "+ item));

        observableFactories.rangeObservable
                .map(item -> item * 2)
                .flatMap(item -> Observable.just(item * 2))
                .toList()
                .subscribe(item -> System.out.println("item: "+ item));


        
    }
}
