package com.codingsaint.learning.rxjava.observables;

import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codingsaint.learning.rxjava.observer.DemoObserver;

import io.reactivex.Observable;

public class ObservableUsingCallable {

	private static final Logger LOGGER = LoggerFactory.getLogger(ObservableUsingCallable.class);
	
	
	public static String doSomething() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Hello";
	}
	
	public static void main(String[] args) {
		
		Callable<String> callable = new Callable<String>() {

			@Override
			public String call() throws Exception {
				return doSomething();
			}
		};
		
		Observable.fromCallable(callable)
			.subscribe(new DemoObserver());
	}
}
