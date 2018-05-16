package com.saneet.LearnRx;

import java.util.ArrayList;

public class RxBasics {
    private ArrayList<Integer> outputs = new ArrayList<Integer>();
    private ObservableFactory observableFactory;

    public RxBasics(ObservableFactory observableFactory) {
        this.observableFactory = observableFactory;
    }

    public void listenToSingleSubscriber() {
        observableFactory.singleObservable().subscribe(i -> outputs.add(i));
    }

    public void listenToSequentialCall() {
        observableFactory.singleObservable()
                .flatMap(observableFactory::additionObservable)
                .subscribe(i -> outputs.add(i));
    }

    public void listenTo3SequentialCall() {
        observableFactory.singleObservable()
                .flatMap(observableFactory::additionObservable)
                .flatMap(observableFactory::subtractionObservable)
                .subscribe(i -> outputs.add(i));
    }
    public ArrayList<Integer> getOutputs() {
        return outputs;
    }
}
