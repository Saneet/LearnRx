package com.saneet.LearnRx;

import java.util.ArrayList;
import java.util.List;

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

    public List<String> modifyEmissionsReturnList() {
        return new ArrayList<>();
    }

    public void chainWithCarryOverValue() {
    }

    public void parallelObservables() {
    }

    public ArrayList<Object> getOutputs() {
        return outputs;
    }
}
