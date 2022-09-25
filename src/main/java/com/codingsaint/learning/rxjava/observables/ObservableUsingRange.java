package com.codingsaint.learning.rxjava.observables;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codingsaint.learning.rxjava.observer.DemoObserver;

import io.reactivex.Observable;

public class ObservableUsingRange {

	private static final Logger LOGGER = LoggerFactory.getLogger(ObservableUsingRange.class);
	
	
	public static void main(String[] args) {
		Observable.range(1, 10)
			.subscribe(new DemoObserver());
	}
}
