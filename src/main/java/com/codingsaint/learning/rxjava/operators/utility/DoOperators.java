package com.codingsaint.learning.rxjava.operators.utility;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codingsaint.learning.rxjava.observer.DemoObserver;
import com.codingsaint.learning.rxjava.utils.RxUtils;

import io.reactivex.Observable;

public class DoOperators {

	private static final Logger LOGGER = LoggerFactory.getLogger(DoOperators.class);

	public static void main(String[] args) {
		LOGGER.info("Do Operator");
		Observable.fromIterable(RxUtils.shapes(10))
			.doOnSubscribe(disposable -> {
				LOGGER.info("Stream is subscribed");
			})
			.doOnEach(shapeNotification -> {
				LOGGER.info("current value {}", shapeNotification.getValue());
			})
			.doOnComplete(() -> {
				LOGGER.info("Completed");
			})
			.subscribe(new DemoObserver());
		
		RxUtils.sleep(5000);
	}
	
}
