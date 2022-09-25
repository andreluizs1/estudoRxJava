package com.codingsaint.learning.rxjava.observables;

import java.util.concurrent.atomic.AtomicInteger;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codingsaint.learning.rxjava.observer.DemoObserver;
import com.codingsaint.learning.rxjava.utils.RxUtils;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class FlowableWithBackpressure {

	private static final Logger LOGGER = LoggerFactory.getLogger(ObservableWithoutBackpressure.class);
	
	public static void main(String[] args) {
		
		Flowable<Integer> flowablePositiveNumbers = Flowable.fromIterable(RxUtils.postiveNumbers(1000000))
			.repeat()
			.observeOn(Schedulers.newThread(), false, 5)
			.subscribeOn(Schedulers.newThread())
			.doOnNext(integer -> LOGGER.info("emmiting integer => {}", integer));
		
		flowablePositiveNumbers.subscribe(new Subscriber<Integer>() {
			
			private Subscription subscription;
			private AtomicInteger counter = new AtomicInteger(0);

			@Override
			public void onSubscribe(Subscription subscription) {
				LOGGER.info("onSubscribe");
				this.subscription = subscription;
				subscription.request(5);
			}

			@Override
			public void onNext(Integer integer) {
				LOGGER.info("onNext {} -> ", integer);
				RxUtils.sleep(100L);
				subscription.request(5);
			}

			@Override
			public void onError(Throwable throwable) {
				LOGGER.info("onError {}", throwable.getMessage());
			}

			@Override
			public void onComplete() {
				LOGGER.info("onComplete");
			}
		});
		
		RxUtils.sleep(10000);
	}
}
