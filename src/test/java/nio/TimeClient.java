package nio;

/**
 * Author: chunxing
 * Date: 2018/7/28  下午11:05
 * Description:
 */
public class TimeClient {

    public static void main(String[] args) {

        TimeClientHandle timeClientHandle = new TimeClientHandle("127.0.0.1", 8080);
        new Thread(timeClientHandle, "timeClientHandle").start();
    }
}
