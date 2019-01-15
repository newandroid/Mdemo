package css.com.applab.rxjava2;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;

/**
 * create by css on 2019/1/15
 */
public class FooSendAndReceive {
    public static void main(String[] args) {
//        normal();
        rxImplement();
    }


    static class MyObservable {
        CallBack callBack;

        void sendData() {
            //send cmd
        }

        void setCallBack(CallBack callBack) {
            this.callBack = callBack;
        }

        void receiveDataFromServer() {
            notifyObserver();
        }

        private void notifyObserver() {
            if (callBack != null) callBack.onCallBack("this is from server");
        }
    }

    interface CallBack {
        void onCallBack(String data);
    }

    static void normal() {

        MyObservable myObserverable = new MyObservable();
        //send data
        myObserverable.sendData();
        //receive callback
        myObserverable.setCallBack(new CallBack() {
            @Override
            public void onCallBack(String data) {
                System.out.println(data);
            }
        });

        //touch event happen
        myObserverable.receiveDataFromServer();
    }

    static void rxImplement() {

        //send data return a observable and subscribe
        MyRxWrapper myRxWrapper = new MyRxWrapper();
        myRxWrapper.sendData().subscribe(s -> System.out.println(s));

        //touch event happen
        myRxWrapper.receiveDataFromServer();

    }

    static class MyRxWrapper {
        FlowableEmitter<String> e;

        Flowable<String> sendData() {
            //wait for server data
            Flowable<String> stringFlowable = Flowable.create(new FlowableOnSubscribe<String>() {
                @Override
                public void subscribe(FlowableEmitter<String> e) throws Exception {
                    MyRxWrapper.this.e = e;
                }
            }, BackpressureStrategy.LATEST);
            return stringFlowable;
        }

        void receiveDataFromServer() {
//            notifyObserver();
            if (e!=null){
                e.onNext("this is from server");
            }
        }
    }


}
