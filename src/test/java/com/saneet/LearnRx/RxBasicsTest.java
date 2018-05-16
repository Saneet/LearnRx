package com.saneet.LearnRx;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class RxBasicsTest {

    private ObservableFactory observableFactory;

    @Mock
    Random random;

    private RxBasics subject;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        ObservableFactory observableFactory = new ObservableFactory(random);
        this.observableFactory = spy(observableFactory);
        subject = new RxBasics(this.observableFactory);
    }

    @Test
    public void listenToSingleSubscriber() {
        when(random.nextInt()).thenReturn(6);

        subject.listenToSingleSubscriber();

        assertThat(subject.getOutputs().get(0)).isEqualTo(6);
    }

    @Test
    public void listenToSequentialObservable() {
        when(random.nextInt()).thenReturn(6, 7);

        subject.listenToSequentialCall();

        assertThat(subject.getOutputs().get(0)).isEqualTo(13);
    }

    @Test
    public void listenTo3SequentialObservable() {
        when(random.nextInt()).thenReturn(6, 7, 8);

        subject.listenTo3SequentialCall();

        assertThat(subject.getOutputs().get(0)).isEqualTo(5);
    }

    //flatmap transformation
    //map transformation
    //map.asList()
    //concurrentSubscibers - zip and merge
    //all subjects
    //replay refcount
    //manual caching
    //cache()
    //cache() vs replay()
    //debounce
    //cancelling subscription halfway
}