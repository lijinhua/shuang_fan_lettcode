package executor;

import java.util.concurrent.*;

public class SynchronousQueueTest {
   static ExecutorService executorService;
    public static void main(final String[] arguments){
//        try {
//        SynchronousQueue<Integer> queue = new SynchronousQueue<>();
//
//        new Thread(()->{
//            try {
//                queue.put(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//
//
//        Thread.sleep(500);
//        System.out.println(queue.take());
////        System.out.println("start");
////            queue.put(1);
////        System.out.println("put 1");
////        queue.put(2);
////        System.out.println("put 2");
////        System.out.println(queue.take());
////        System.out.println("end");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }



        executorService =  executorService();
        for(int i=0;i<10;i++){
            int j = i;
           executorService.execute(new Runnable() {
               @Override
               public void run() {
                   try {
                       Thread.sleep(1000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   System.out.println(j+"");
               }
           });
        }
    }

    public static  synchronized ExecutorService executorService() {
        if (executorService == null) {
            executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS,
                    new SynchronousQueue<Runnable>(), /*Util.threadFactory("OkHttp Dispatcher", false)*/
                    new ThreadFactory() {
                        @Override public Thread newThread(Runnable runnable) {
                            Thread result = new Thread(runnable, "OkHttp Dispatcher");
                            result.setDaemon(false);
                            return result;
                        }
                    });
        }
        return executorService;
    }
}
