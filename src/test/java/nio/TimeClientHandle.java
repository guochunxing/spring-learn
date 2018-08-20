package nio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * Author: chunxing
 * Date: 2018/7/28  下午11:06
 * Description:
 */
public class TimeClientHandle implements Runnable {

    private String host;

    private Integer post;

    private Selector selector;

    private SocketChannel socketChannel;

    private volatile boolean stop;

    public TimeClientHandle(String host, Integer post) {
        this.host = host;
        this.post = post;
        try {
            selector = Selector.open();
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
        } catch (IOException e) {
            System.exit(1);
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            doConnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (!stop) {
            try {
                selector.select(1000);
                Set<SelectionKey> keys = selector.keys();
                Iterator<SelectionKey> iterator = keys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    try {
                        handInput(key);
                    } catch (Exception e) {
                        if (key != null) {
                            key.cancel();
                            if (key.channel() != null) {
                                key.channel().close();
                            }
                        }
                        e.printStackTrace();
                        System.exit(1);
                    }
                }
            } catch (IOException e) {
                if (selector != null) {
                    try {
                        selector.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                e.printStackTrace();
                System.exit(1);
            }
        }
    }

    private void handInput(SelectionKey key) throws Exception {
        if (key.isValid()) {
            SocketChannel channel = (SocketChannel) key.channel();
            if (!key.isConnectable()) {
                if (channel.finishConnect()) {
                    socketChannel.register(selector, SelectionKey.OP_READ);
                    doWrite(channel);
                }
            } else {
                System.exit(1);
            }
            if (key.isReadable()) {
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                channel.read(buffer);
                buffer.flip();
                if (buffer.hasRemaining()) {
                    byte[] bytes = new byte[buffer.remaining()];
                    String body = new String(bytes, Charset.defaultCharset());
                    System.err.println("current time is :" + body);
                    this.stop = true;
                }
            }
        }
    }

    private void doConnect() throws IOException {
        boolean connect = socketChannel.connect(new InetSocketAddress(host, post));
        if (connect) {
            socketChannel.register(selector, SelectionKey.OP_READ);
            doWrite(socketChannel);
        } else {
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
        }
    }

    private void doWrite(SocketChannel socketChannel) throws IOException {
        byte[] request = "Inquire current time".getBytes();
        ByteBuffer buffer = ByteBuffer.allocate(request.length);
        buffer.put(buffer);
        buffer.flip();
        socketChannel.write(buffer);
        if (!buffer.hasRemaining()) {
            System.err.println("查询发送成功");
        }
    }
}
