package tinkoff2.net;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(18080);
        var socket = server.accept();
        try (var writer = new PrintWriter(socket.getOutputStream(), true)) {
            writer.println("Sending test data");
        }
        socket.close();
        server.close();
    }
}
