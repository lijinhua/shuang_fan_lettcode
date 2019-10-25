package executor;

import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPoolExecutor中默认的拒绝策略就是AbortPolicy。直接抛出异常。
 *
 * https://blog.csdn.net/qq_25806863/article/details/71172823
 */
public class AbortPolicyTest {

    public static void main(final String[] arguments)
    {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 0,TimeUnit.MICROSECONDS,new LinkedBlockingDeque<Runnable>(2),
                new ThreadPoolExecutor.AbortPolicy());

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
