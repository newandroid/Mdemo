package css.com.applab.rxjava2;

import java.util.concurrent.TimeUnit;

import io.reactivex.schedulers.Schedulers;

/**
 * create by css on 2019/1/15
 */
public class AsynchronousCallBack {
    public static void main(String[] args){
//        MyRunnable runnable = new MyRunnable();
//        runnable.setListner(new Listner() {
//            @Override
//            public void onListener() {
//                taskResult();
//            }
//        });
//        new Thread(runnable).start();


        io.reactivex.Observable.just("111")
                .subscribeOn(Schedulers.io())
                .delay(2,TimeUnit.SECONDS)
                .subscribe(s -> taskResult());
    }

    public interface Listner{
        void onListener();
    }

    public static class MyRunnable implements Runnable{
        Listner listner;

        public void setListner(Listner listner) {
            this.listner = listner;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                eventHappen(listner);
            }
        }
    }

    static void eventHappen(Listner listner){
        try {
            Thread.sleep(300);
            if (listner!=null)listner.onListener();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static void taskResult(){
        System.out.println(Thread.currentThread().getName()+" this is a long time task call back");
    }



}
