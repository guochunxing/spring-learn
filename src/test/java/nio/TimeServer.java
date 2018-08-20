package nio;

import java.io.IOException;

/**
 * Author: chunxing
 * Date: 2018/7/28  下午9:41
 * Description:
 */
public class TimeServer {

    public static void main(String[] args) throws IOException {
        Integer port = 8080;

        MultiplexerTimeServer multiplexerTimeServer = new MultiplexerTimeServer(port);

        new Thread(multiplexerTimeServer, "TimeServer").start();
    }
}
