package com.codingsaint.learning.rxjava.operators.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codingsaint.learning.rxjava.observer.DemoObserver;
import com.codingsaint.learning.rxjava.utils.RxUtils;

import io.reactivex.Observable;

public class TakeWhileOperator {

	private static final Logger LOGGER = LoggerFactory.getLogger(TakeWhileOperator.class);

	public static void main(String[] args) {
		LOGGER.info("SkipWhile Operator");

		Observable<Integer> positiveNumbers = Observable.fromIterable(RxUtils.postiveNumbers(10));
		
		positiveNumbers.takeWhile(integer -> {
			return integer < 4;
		}).subscribe(new DemoObserver());
	}
}
