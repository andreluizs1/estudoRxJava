package com.codingsaint.learning.rxjava.observables;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codingsaint.learning.rxjava.observer.DemoObserver;
import com.codingsaint.learning.rxjava.utils.RxUtils;

import io.reactivex.Observable;

public class ObservableUsingDefer {

	private static final Logger LOGGER = LoggerFactory.getLogger(ObservableUsingDefer.class);
	
	public static void main(String[] args) {
		Observable<Integer> observableUsingDefer = Observable.defer(() -> {
			return Observable.fromIterable(RxUtils.postiveNumbers(5));
		});
		observableUsingDefer.subscribe(new DemoObserver());
		observableUsingDefer.subscribe(new DemoObserver());
	}
	
}
