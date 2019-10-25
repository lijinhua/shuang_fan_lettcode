package executor;

import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPoolExecutor中默认的拒绝策略就是DiscardOldestPolicy策略的作用是，当任务呗拒绝添加时，会抛弃任务队列中最旧的任务也就是最先加入队列的，再把这个新任务添加进去。
 *
 * https://blog.csdn.net/qq_25806863/article/details/71172823
 */
public class DiscardOldestPolicyTest {

    public static void main(final String[] arguments)
    {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 30,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(2),
                new ThreadPoolExecutor.DiscardOldestPolicy());



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
