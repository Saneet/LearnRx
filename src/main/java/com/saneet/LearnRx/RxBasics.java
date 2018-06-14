package com.saneet.LearnRx;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.schedulers.Schedulers;

public class RxBasics {
    private ArrayList<Object> outputs = new ArrayList<>();
    private ObservableFactory observableFactory;

    public RxBasics(ObservableFactory observableFactory) {
        this.observableFactory = observableFactory;
    }

    public void listenToObservable() {
    }

    public void chainObservables() {
    }

    public Observable<String> modifyEmissions() {
        return null;
    }

    public Observable<Integer> combineEmmissions() {
        return null;
    }

    public List<Integer> convertAsyncToSync() {
        return null;
    }

    public void chainWithCarryOverValue() {
    }

    public void combineObservables() {
    }

    public void parallelObservables_takeAsTheyCome() {
    }

    public void parallelObservables_groupEmissions() {
    }

    public Observable<Integer> multipleSubscribersScenario1() {
        return null;
    }

    public Observable<Integer> multipleSubscribersScenario2() {
        return null;
    }

    public Observable<Integer> multipleSubscribersScenario3() {
        return null;
    }

    public Observable<Integer> multipleSubscribersScenario4() {
        return null;
    }

    public Observable<String> multiThreading() {
        return null;
    }

    public List<Object> getOutputs() {
        return outputs;
    }
}
