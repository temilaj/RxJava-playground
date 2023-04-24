package rxjavaintro.subjects;

import io.reactivex.rxjava3.subjects.AsyncSubject;
import io.reactivex.rxjava3.subjects.BehaviorSubject;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.ReplaySubject;
import io.reactivex.rxjava3.subjects.Subject;

public class SubjectFactories {
    
    public Subject<Long> intervalPublishSubject = PublishSubject.create();

    public Subject<Integer> numbersBehaviourSubject = BehaviorSubject.create();

    public Subject<Integer> numbersReplaySubject = ReplaySubject.create();
    
    public Subject<Integer> numbersAsyncSubject = AsyncSubject.create();
}
