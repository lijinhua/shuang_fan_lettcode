package executor;

import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPoolExecutor中默认的拒绝策略就是CallerRunsPolicy，只要线程池未关闭，会调用当前线程池的所在的线程去执行被拒绝的任务。如果是线程池所在的线程就是主线程
 *
 * 这个策略的缺点就是可能会阻塞主线程。
 * https://blog.csdn.net/qq_25806863/article/details/71172823
 */
public class CallerRunsPolicyTest {

    public static void main(final String[] arguments)
    {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 30,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(2),
                new ThreadPoolExecutor.CallerRunsPolicy());


        for (int i = 0; i < 6; i++) {
            System.out.println("添加第"+i+"个任务");
            executor.execute(new MyAbortolicyThread("线程"+i));
            Iterator iterator = executor.getQueue().iterator();
            while (iterator.hasNext()){
                MyAbortolicyThread thread = (MyAbortolicyThread) iterator.next();
                System.out.println("列表：-----------"+thread.name);
            }
        }


    }
    static class MyAbortolicyThread implements Runnable {
        String name;
        public MyAbortolicyThread(String name) {
            this.name = name;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程:"+Thread.currentThread().getName() +" 执行:"+name +"  run");
        }
    }

}
