package executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 一个单线程的线程池，这个线程池只有一个线程在工作，即相当于单线程串行执行所有任务。
 * 如果这个唯一的线程因为异常结束，那么会有一个新的线程来替代它。
 * 此线程池保证所有任务的执行顺序是按照任务的提交顺序执行的。
 * @author Peter
 *
 * 源码解析，里面的参数
 * (new ThreadPoolExecutor(1, 1,
 * 0L, TimeUnit.MILLISECONDS,
 *                                     new LinkedBlockingQueue<Runnable>()));
 *
 * 线程因为异常结束，那么会有一个新的线程来替代它
 *
 * LinkedBlockingQueue
 *    LinkedBlockingQueue就是其中之一，是一个阻塞的线程安全的队列，底层采用链表实现
 *    LinkedBlockingQueue构造的时候若没有指定大小，则默认大小为Integer.MAX_VALUE，当然也可以在构造函数的参数中指定大小。LinkedBlockingQueue不接受nul
 *
 *    threadPoolExecutor 中的 shutdown() 、 shutdownNow() 、 awaitTermination() 的用法和区别
 *    https://blog.csdn.net/cxfly957/article/details/80741581
 *
 *    使用线程池的时候要注意，里面使用的linkedBlock,提交任务到里面的时候，如果没有手动移除，这个任务还是在队列里面的，因为华为有一个最大的线程数限制是，2百多吧
 */
public class ThreadPool_newSingleThreadExecutor {

	public static void main(String[] args) {
//		ExecutorService pool = Executors.newSingleThreadExecutor();
//		for (int i = 0; i < 10; i++) {
//			//实现一个runnable匿名内部类
//			pool.execute(new Runnable(){
//				public void run() {
//					System.out.println(Thread.currentThread().getName() + "\t开始发车了……");
//				}
//			});
//		}

		/**
		 * 单线程化的线程池
		 */
		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 1; i++) {
			final int index = i;
			singleThreadExecutor.execute(new Runnable() {
				@Override
				public void run() {
					Thread.currentThread().setName("Thread i = " + index);
					System.out.println(Thread.currentThread().getName() + " index = " + index);

					try {
						Thread.sleep(500);
					} catch (Exception e) {
						System.out.println("ssss");
					}

				}
			});
		}
		singleThreadExecutor.shutdown();
		for (int i = 1; i < 2; i++) {
			final int index = i;
			singleThreadExecutor.execute(new Runnable() {
				@Override
				public void run() {
					Thread.currentThread().setName("Thread i = " + index);
					System.out.println(Thread.currentThread().getName() + " index = " + index);

					try {
						Thread.sleep(500);
					} catch (Exception e) {
						System.out.println("ssss");
					}
					singleThreadExecutor.shutdownNow();
				}
			});
		}


		System.out.println("on the main thread...");


	}
	
}