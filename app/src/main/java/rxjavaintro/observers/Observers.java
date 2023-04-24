package rxjavaintro.observers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
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
            System.out.println("itemObserver: On complete called ");
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
            System.out.println("listObserver: On complete called ");
        }
        
    };

    public SingleObserver<String> userObserver = new SingleObserver<String>() {

        @Override
        public void onSubscribe(@NonNull Disposable d) {
        }

        @Override
        public void onSuccess(@NonNull String t) {
            System.out.println(t);
        }

        @Override
        public void onError(@NonNull Throwable e) {
            System.out.println("error: " + e);
        }

    };

    public MaybeObserver<String> filMaybeObserver = new MaybeObserver<String>() {

        @Override
        public void onSubscribe(@NonNull Disposable d) {
        }

        @Override
        public void onSuccess(@NonNull String t) {
            System.out.println(t);
        }

        @Override
        public void onError(@NonNull Throwable e) {
            System.out.println("error: " + e);

        }

        @Override
        public void onComplete() {
            System.out.println("filMaybeObserver: On complete called ");

        }
        
    };

    public CompletableObserver dbCompletableObserver = new CompletableObserver() {

        @Override
        public void onSubscribe(@NonNull Disposable d) {
        }

        @Override
        public void onComplete() {
            System.out.println("item removed successfully");
        }

        @Override
        public void onError(@NonNull Throwable e) {
        }
        
    };

}
