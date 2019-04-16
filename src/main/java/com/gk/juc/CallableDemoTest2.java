package com.gk.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class CallableDemoTest2 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CallableDemo demo = new CallableDemo();
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		// 方式一 使用Future
//		Future<Integer> future = executorService.submit(demo);
		// 方式二 使用FutureTask
		FutureTask<Integer> future = new FutureTask<>(demo);
		executorService.submit(future);
		executorService.shutdown();
		System.out.println("主线程执行任务。。。");
		if(!future.isDone()) {
			System.out.println("Callable 还未执行完成。。。");
		}
		Integer result = future.get();	//会阻塞调用线程
		System.out.println("执行结果：" + result);
		System.out.println("主线程执行完成");
	}

}
