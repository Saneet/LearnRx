package com.saneet.LearnRx;

import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ObservableFactory {

    private Random random;

    public ObservableFactory(Random random) {
        this.random = random;
    }

    public Observable<Integer> singleItemObservable() {
        return Observable.just(random.nextInt());
    }

    public Observable<Integer> seriesObservable() {
        return Observable.fromCallable(() -> random.nextInt()).repeat(5);
    }

    public Observable<Integer> additionObservable(int num) {
        return Observable.just(num + random.nextInt());
    }

    public Observable<Integer> subtractionObservable(int num) {
        return Observable.just(Math.max(0, num - random.nextInt()));
    }

    public Observable<String> convertToString(int num) {
        return Observable.just("" + num);
    }

    public Observable<Integer> delayObservable() {
        return Observable.fromCallable(() -> random.nextInt())
                .delay(1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.newThread());
    }
}