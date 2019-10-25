package executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 此线程池支持定时以及周期性执行任务的需求
 * 
 * @author Peter 延迟10秒执行任务
 */
public class ThreadPool_newScheduledThreadPool {

	public static void main(String[] args) {
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(10);

		for (int i = 0; i < 10; i++) {

			// 延迟10秒执行任务
			// pool.schedule(new Runnable(){
			// @Override
			// public void run() {
			// System.out.println(Thread.currentThread().getName() +
			// "\t 延迟10秒开始发车了……");
			// }
			// }, 10, TimeUnit.SECONDS);
			//
			// 每秒执行一次任务
			pool.scheduleAtFixedRate(new Runnable() {
				public void run() {
					System.out.println(Thread.currentThread().getName()
							+ "\t 每秒一次发车……");
				}
			}, 1, 1, TimeUnit.SECONDS);
		}
	}
}