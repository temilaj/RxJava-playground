/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package rxjavaintro;

import java.util.Scanner;

import io.reactivex.rxjava3.core.Observable;
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

        observableFactories.itemObservable.subscribe(observers.itemObserver);
        observableFactories.listObserverable.subscribe(observers.listObserver);
        observableFactories.rangeObservable.subscribe(item -> {
            System.out.println(item);
        });

        // observableFactories.intervalObservable.subscribe(item -> {
        //     System.out.println(item);
        // });

        observableFactories.timerObservable.subscribe(item -> {
            System.out.println("5 seconds passed");
        });

        new Scanner(System.in).nextLine();
    }
}
