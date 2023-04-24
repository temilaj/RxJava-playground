package rxjavaintro.completables;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.functions.Action;

public class CompletableFactories {
    
    Action printAction = () -> System.out.println("hello completable");
    public Completable printCompletable = Completable.fromAction(printAction);
    public Completable deleteItemFromDBCompletable = Completable.fromAction(deleteItemFromDBAction());

    private static Action deleteItemFromDBAction() {
        return new Action() {

            // method called after subscribing to the completable
            @Override
            public void run() throws Throwable {
                System.out.println("Deleting Item From DB");
            }
            
        };
    }
}
