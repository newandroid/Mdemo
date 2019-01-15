package css.com.applab.rxjava2;

import java.util.Observable;
import java.util.Observer;

/**
 * create by css on 2019/1/15
 */
public class MyObservableDesignPatener {
    public static void main(String[] args){
//        normal();
        rxImplement();
    }

    public static class MyObservable extends Observable{
        @Override
        public synchronized void setChanged() {
            super.setChanged();
        }
    }

    public static void normal(){
        MyObservable myObservable = new MyObservable();
        myObservable.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println("MyObservableDesignPatener11111.update");
            }
        });
        myObservable.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println("MyObservableDesignPatener222.update");
            }
        });
        myObservable.setChanged();
        myObservable.notifyObservers();
    }

    public static void rxImplement(){
        io.reactivex.Observable<String> eventHappen = io.reactivex.Observable.just("event happen");
        eventHappen.subscribe(s -> {
            System.out.println("MyObservableDesignPatener11111.update");
        });
        eventHappen.subscribe(s -> {
            System.out.println("MyObservableDesignPatener222.update");
        });
    }
}
