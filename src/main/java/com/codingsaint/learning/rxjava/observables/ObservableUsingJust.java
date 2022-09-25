package com.codingsaint.learning.rxjava.observables;

import com.codingsaint.learning.rxjava.observer.DemoObserver;

import io.reactivex.Observable;

public class ObservableUsingJust {
	
	
	public static void main(String args[]) {
		Observable.just("a", "b", "c", "d", "e", "f", "g", "h", "i", "j")
			.subscribe(new DemoObserver());
	}

}
