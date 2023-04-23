package rxjavaintro.observers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class Observers {
    
    public Observer<String> itemObserver = new Observer<String>() {

        @Override
        public void onSubscribe(@NonNull Disposable d) {
        }

        @Override
        public void onNext(@NonNull String t) {
            System.out.println(t);
        }

        @Override
        public void onError(@NonNull Throwable e) {
            System.out.println(e);
        }

        @Override
        public void onComplete() {
            System.out.println("On complete called " + this.getClass().getName());
        }
    };

    public Observer<Integer> listObserver = new Observer<Integer>() {

        @Override
        public void onSubscribe(@NonNull Disposable d) {
        }

        @Override
        public void onNext(@NonNull Integer t) {
            System.out.println(t);
        }

        @Override
        public void onError(@NonNull Throwable e) {
            System.out.println(e);
        }

        @Override
        public void onComplete() {
            System.out.println("On complete called " + this.getClass().getName());
        }
        
    };
}
