package org.example.kv_client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class SimpleClient {

    private static final String HOST = "localhost";
    private static final int PORT = 8080;

    public void connect() {
        InetSocketAddress hostAddress = new InetSocketAddress(HOST, PORT);
        try (SocketChannel client = SocketChannel.open(hostAddress)) {
            ByteBuffer buffer = ByteBuffer.wrap("put 12312 hello".getBytes(StandardCharsets.UTF_8));
            while (buffer.hasRemaining()) {
                client.write(buffer);
            }
            buffer.flip();
        } catch (IOException e) {
            throw new RuntimeException("Unable to communicate with server.", e);
        }
    }

}
