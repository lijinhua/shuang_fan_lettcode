package executor;

import java.util.concurrent.*;

/**
 * 创建固定大小的线程池，每次提交任务就创建一个线程，直到线程达到线程池的最大大小
 * 线程池的大小一旦达到最大值就会保持不变，如果某个线程因为执行异常而结束，那么线程池一定会补充一个新线程
 * @author Peter
 *
 *
 * ThreadPoolExecutor(nThreads, nThreads,
 *                                       0L, TimeUnit.MILLISECONDS,
 *                                       new LinkedBlockingQueue<Runnable>());
 */
public class ThreadPool_newFixedThreadPool {

	public static void main(String[] args) {
//		ExecutorService pool = Executors.newFixedThreadPool(1);
		ThreadPoolExecutor executor = 	new ThreadPoolExecutor(10, 10,
				0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>());
		for(int i = 0; i < 2000; i++){
			executor.execute(new Runnable(){
				@Override
				public void run() {

					System.out.println(Thread.currentThread().getName() + "\t开始发车了……");
					try {
						Thread.sleep(1000000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});

			while (true) {
				System.out.println("线程池中线程数目：" + executor.getQueue().size()+ "，队列中等待执行的任务数目：" +
						executor.getQueue().size() + "，已执行完的任务数目：" + executor.getCompletedTaskCount());
			}


		}
	}
}