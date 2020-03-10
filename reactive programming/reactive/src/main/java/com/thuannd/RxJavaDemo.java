package com.thuannd;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import rx.Observable;
import rx.Subscriber;

public class RxJavaDemo {

    public static void main(final String[] args) {
        method1();
        method2();
    }

    // su dung Subcriber lam subcriber va Observable lam publisher
    public static void method1(){
        final Observable<Integer> publisherB = Observable.just(3, 1); // luong du lieu phat ra thay doi (publisher)
        final Integer c = 6;
        final Subscriber subcriberA = new Subscriber<Integer>() { // doi tuong lang nghe su thay doi du lieu (subcriber)

            Integer a = 0;

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(final Throwable e) {

            }

            @Override
            public void onNext(final Integer t) {
                System.out.println("method 1---------------");
                a = t + c;
                System.out.println(a);
			}
        };
        publisherB.subscribe(subcriberA);
    }

    // su dung Comsumer lam subcriber va Flowable lam publisher
    public static void method2(){
        final Flowable<Integer> publisherB = Flowable.just(3, 1);
        final Integer c = 6;
        final Consumer<Integer> subcriberA = new Consumer<Integer>(){
        
            Integer a = 0;

            @Override
            public void accept(Integer t) throws Exception {
                System.out.println("method 2---------------");
                a = t + c;
                System.out.println(a);
            }
        };
        publisherB.subscribe(subcriberA);
    }


}