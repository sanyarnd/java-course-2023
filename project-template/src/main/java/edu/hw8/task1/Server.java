package edu.hw8.task1;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    final List<String> responses;

    public Server(List<String> responseList) {
        responses = responseList;
    }

    public void start(int port, int maxConnections) {
        ExecutorService executorService = Executors.newFixedThreadPool(maxConnections);

        try (var serverSocket = new ServerSocket(port)) {
            while (!Thread.interrupted()) {
                Socket clientSocket = serverSocket.accept();
                executorService.submit(() -> handleClient(clientSocket));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void handleClient(Socket clientSocket) {
        try (
            var outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
            var inputStream = new ObjectInputStream(clientSocket.getInputStream())
        ) {
            String clientMsg = (String) inputStream.readObject();
            String response = responses.stream()
                .filter(element -> element.toLowerCase().contains(clientMsg.toLowerCase()))
                .findFirst()
                .orElse(null);
            outputStream.writeObject(response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
