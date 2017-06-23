package com.saneet.LearnRx;

import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

import java.util.Calendar;
import java.util.concurrent.Callable;

public class ReplayRefCount {

    public static void main(String... args) {
        //        Observable<Long> mObservable = Observable.defer(new Func0<Observable<Long>>() {
//            public Observable<Long> call() {
//                return getObservable();
//            }
//        }).replay().refCount();

        Observable<Long> mObservable = getObservable().replay().refCount();

        mObservable = mObservable.subscribeOn(Schedulers.io());
        mObservable.subscribe(new MySubscriber("sub1"));
        mObservable.subscribe(new MySubscriber("sub2"));
        mObservable.subscribe(new MySubscriber("sub3"));
        mObservable.subscribe(new MySubscriber("sub4"));
        mObservable.subscribe(new MySubscriber("sub5"));
        mObservable.subscribe(new MySubscriber("sub6"));
        mObservable.subscribe(new MySubscriber("sub7"));
        mObservable.subscribe(new MySubscriber("sub8"));
        mObservable.subscribe(new MySubscriber("sub9"));
        mObservable.subscribe(new MySubscriber("sub10"));
        mObservable.subscribe(new MySubscriber("sub11"));
        mObservable.subscribe(new MySubscriber("sub12"));

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mObservable.subscribe(new MySubscriber("bub1"));
        mObservable.subscribe(new MySubscriber("bub2"));
        mObservable.subscribe(new MySubscriber("bub3"));
        mObservable.subscribe(new MySubscriber("bub4"));
        mObservable.subscribe(new MySubscriber("bub5"));
        mObservable.subscribe(new MySubscriber("bub6"));
        mObservable.subscribe(new MySubscriber("bub7"));
        mObservable.subscribe(new MySubscriber("bub8"));
        mObservable.subscribe(new MySubscriber("bub9"));
        mObservable.subscribe(new MySubscriber("bub10"));
        mObservable.subscribe(new MySubscriber("bub11"));
        mObservable.subscribe(new MySubscriber("bub12"));

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Observable<Long> getObservable() {
        return Observable.fromCallable(new Callable<Long>() {
            public Long call() throws Exception {
                Thread.sleep(5000);
                return Calendar.getInstance().getTimeInMillis();
            }
        });
    }
}

class MySubscriber extends Subscriber<Long> {
    private StringBuilder s = new StringBuilder();
    private String name;

    public MySubscriber(String name) {
        this.name = name;
    }

    public void onCompleted() {
        s.insert(0, name + ": ");
        System.out.println(s.toString());
    }

    public void onError(Throwable e) {

    }

    public void onNext(Long aLong) {
        s.append(aLong);
        s.append(" ");
    }
}
