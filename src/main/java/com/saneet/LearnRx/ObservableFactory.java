package com.saneet.LearnRx;

import rx.Observable;

import java.util.Random;

public class ObservableFactory {

    private Random random;

    public ObservableFactory(Random random) {
        this.random = random;
    }

    public Observable<Integer> singleObservable() {
        return Observable.just(random.nextInt());
    }

    public Observable<Integer> additionObservable(int num) {
        return Observable.just(num + random.nextInt());
    }

    public Observable<Integer> subtractionObservable(int num) {
        return Observable.just(num - random.nextInt());
    }
}