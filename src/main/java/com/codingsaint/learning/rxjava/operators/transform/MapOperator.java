package com.codingsaint.learning.rxjava.operators.transform;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codingsaint.learning.rxjava.observer.DemoObserver;
import com.codingsaint.learning.rxjava.utils.RxUtils;

import io.reactivex.Observable;

public class MapOperator {

	private static final Logger LOGGER = LoggerFactory.getLogger(MapOperator.class);
	
	public static void main(String[] args) {
		Observable.fromIterable(RxUtils.postiveNumbers(10))
			.map(integer -> {return integer * 2;})
			.subscribe(new DemoObserver());
		
	}

}
