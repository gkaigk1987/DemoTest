package com.gk.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemoTest1 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CallableDemo demo = new CallableDemo();
		FutureTask<Integer> future = new FutureTask<>(demo);
		new Thread(future).start();
		if(!future.isDone()) {
			System.out.println("callable 还未执行完成");
		}
		Integer result = future.get();	//此处会阻塞调用线程
		System.out.println("执行结果：" + result);
		System.out.println("主线程执行完成");
	}

}
