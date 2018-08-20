/**
 * Author: chunxing
 * Date: 2018/8/1  下午5:45
 * Description:
 */
public class ThreadLocalTest {

    private static final ThreadLocal<Integer> threadLocal = new ThreadLocal<>();


    public static void main(String[] args) throws InterruptedException {
        int GROUP_SIZE = 5;
        for (int i = 0; i < GROUP_SIZE; i++) {
            int finalI = i;
            new Thread("name:" + String.valueOf(finalI)) {
                public void run() {
                    for (int j = 0; j < GROUP_SIZE; j++) {
                        Integer integer = threadLocal.get();
                        if (integer == null) {
                            threadLocal.set(0);
                        } else {
                            threadLocal.set(integer + 1);
                            System.out.println("name:" + String.valueOf(finalI) + "----获取到：" + integer);
                        }
                    }
                }
            }.start();
        }
        Thread.sleep(1000);
    }


}
