package org.example.kv_server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Server {

    private static final int PORT = 8080;
    private static final String HOST = "localhost";
    private static final int BUFFER_SIZE = 1024;

    private final Map<SocketChannel, StringBuilder> sessions = new HashMap<>();
    private final KvStorage kvStorage = new KvStorage();

    public void start() {
        try (Selector selector = SelectorProvider.provider().openSelector();
            ServerSocketChannel channel = ServerSocketChannel.open()) {
            channel.configureBlocking(false);
            channel.socket().bind(new InetSocketAddress(HOST, PORT));
            channel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("Starting server on port " + PORT);
            while (true) {
                int keysSize = selector.select();
                System.out.println("Select keys " + keysSize);
                if (keysSize <= 0) {
                    throw new UnsupportedOperationException("Error while accept channel");
                }
                System.out.println("After selector.select");
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                var selectionKeysIterator = selectionKeys.iterator();
                while (selectionKeysIterator.hasNext()) {
                    SelectionKey key = selectionKeysIterator.next();
                    try {
                        if (!key.isValid()) {
                            throw new UnsupportedOperationException("Error while process selected key");
                        }
                        if (key.isAcceptable()) {
                            handleAcceptableKey(channel, key);
                        } else if (key.isReadable()) {
                            handleReadableKey(key);
                        }
                    } catch (Exception e) {
                        throw new UnsupportedOperationException("Error while process request");
                    } finally {
                        key.cancel();
                        selectionKeysIterator.remove();
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Unable to start server.", e);
        } finally {
            this.sessions.clear();
            System.out.println("Shutdown server on port " + PORT);
        }
    }

    private void handleAcceptableKey(ServerSocketChannel channel, SelectionKey key) throws IOException {
        System.out.println("Accept key " + key);
        SocketChannel clientChannel = channel.accept();
        clientChannel.configureBlocking(false);
        clientChannel.register(key.selector(), SelectionKey.OP_READ);
        sessions.put(clientChannel, new StringBuilder());
    }

    private void handleReadableKey(SelectionKey key) throws IOException {
        System.out.println("Read key " + key);
        SocketChannel clientChannel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
        int bytesRead = clientChannel.read(buffer);
        if (bytesRead > 0) {
            String request = new String(buffer.array(), StandardCharsets.UTF_8);
            System.out.println(request);
            String[] args = request.split(" ");
            System.out.println(Arrays.toString(args));
            if (args.length == 0) {
                throw new IllegalArgumentException();
            }
            String command = args[0];
            switch (command) {
                case "put" -> saveKeyValue(args);
                default -> throw new UnsupportedOperationException();
            }
            this.sessions.get(clientChannel).append(request);
        } else if (bytesRead < 0) {
            System.out.println("BytesReadNumber < 0");
        }
    }

    private void saveKeyValue(String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException("Arguments size is wrong");
        }
        String key = args[1];
        String value = args[2];
        kvStorage.put(key, value);
        kvStorage.print();
    }
}
