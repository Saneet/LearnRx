package com.saneet.LearnRx;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

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
    public void listenToObservable() {
        when(random.nextInt()).thenReturn(6);

        subject.listenToObservable();

        verify(observableFactory).singleItemObservable();
        verifyNoMoreInteractions(observableFactory);
        assertThat(subject.getOutputs()).isNotEmpty();
        assertThat(subject.getOutputs().get(0)).isEqualTo(6);
    }

    @Test
    public void chainObservables() {
        when(random.nextInt()).thenReturn(6, 7, 8);

        subject.chainObservables();

        verify(observableFactory).singleItemObservable();
        verify(observableFactory).additionObservable(6);
        verify(observableFactory).subtractionObservable(13);
        verify(observableFactory).convertToString(5);
        verifyNoMoreInteractions(observableFactory);
        assertThat(subject.getOutputs()).isNotEmpty();
        assertThat(subject.getOutputs().get(0)).isEqualTo("5");
    }

    @Test
    public void modifyEmissionsReturnList() {
        when(random.nextInt()).thenReturn(6, 7, 8, 9, 0);

        List<String> result = subject.modifyEmissionsReturnList();

        verify(observableFactory).seriesObservable();
        verifyNoMoreInteractions(observableFactory);
        assertThat(result).isEqualTo(Arrays.asList("6", "7", "8", "9", "0"));
    }

    @Test
    public void chainWithCarryOverValue() {
        when(random.nextInt()).thenReturn(5, 6);

        subject.chainWithCarryOverValue();
        giveItASecond();
        giveItASecond();

        verify(observableFactory, times(2)).delayObservable();
        verifyNoMoreInteractions(observableFactory);
        assertThat(subject.getOutputs()).isNotEmpty();
        assertThat(subject.getOutputs().get(0)).isEqualTo(11);
    }

    @Test
    public void parallelObservables() {
        when(random.nextInt()).thenReturn(5, 6);

        subject.parallelObservables();
        giveItASecond();

        verify(observableFactory, times(2)).delayObservable();
        verifyNoMoreInteractions(observableFactory);
        assertThat(subject.getOutputs()).isNotEmpty();
        assertThat(subject.getOutputs().get(0)).isEqualTo(11);
    }

    private void giveItASecond() {
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}