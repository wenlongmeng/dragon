package dragon.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 测试服务基类
 *
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2016-01-11 01:40
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:config/app-root.xml"
})
public abstract class BaseTester {

        static {
                Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
                        @Override
                        public void run() {
                                System.out.println("Warnning: JVM shut down.");
                        }
                }));
        }

        public static void main(String[] args) throws Exception {
                testLoad();
        }


        public static void testLoad(){
                ExecutorService executorService = Executors.newFixedThreadPool(10);
                final AtomicLong count = new AtomicLong();
                executorService.submit(new Runnable() {
                        @Override
                        public void run() {
                                while(count.incrementAndGet() < Long.MAX_VALUE){
                                        System.out.println(count.get() + " / " + Long.MAX_VALUE);
                                }
                        }
                });
                executorService.submit(new Runnable() {
                        @Override
                        public void run() {
                                while(count.incrementAndGet() < Long.MAX_VALUE){
                                        System.out.println(count.get() + " / " + Long.MAX_VALUE);
                                }
                        }
                });
                executorService.submit(new Runnable() {
                        @Override
                        public void run() {
                                while(count.incrementAndGet() < Long.MAX_VALUE){
                                        System.out.println(count.get() + " / " + Long.MAX_VALUE);
                                }
                        }
                });

                executorService.shutdown();

        }

}
