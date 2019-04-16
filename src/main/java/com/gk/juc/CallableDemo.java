package com.gk.juc;

import java.util.concurrent.Callable;

public class CallableDemo implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		System.out.println("callable 线程执行任务。。。");
		Thread.sleep(1000);
		int sum = 0;
		for(int i = 0; i < 5000; i++) {
			sum += i;
		}
		System.out.println("callable 线程执行任务完成。。。");
		return sum;
	}

}
