package com.codingsaint.learning.rxjava.operators.transform;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codingsaint.learning.rxjava.observer.DemoObserver;
import com.codingsaint.learning.rxjava.utils.RxUtils;

import io.reactivex.Observable;

public class ScanOperator {

	private static final Logger LOGGER = LoggerFactory.getLogger(ScanOperator.class);
	
	public static void main(String[] args) {
		LOGGER.info("Scan Operator");
		List<Integer> numbers = RxUtils.postiveNumbers(10);
		Observable.fromIterable(numbers)
			.scan((integer, integer2) -> {
				return integer + integer2;
			})
			.subscribe(new DemoObserver());
		
	}
	
}
