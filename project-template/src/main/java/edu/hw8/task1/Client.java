package edu.hw8.task1;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    final String serverIp;
    final int serverPort;
    Socket socket;
    ObjectOutputStream outputStream;
    ObjectInputStream inputStream;

    public Client(String serverIp, int serverPort) {
        this.serverIp = serverIp;
        this.serverPort = serverPort;
    }

    public boolean openConnection() {
        try {
            socket = new Socket(serverIp, serverPort);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean closeConnection() {
        try {
            socket.close();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public String sendMsgGetResponse(String msg) {
        String response = null;

        try {
            outputStream.writeObject(msg);
            response = (String) inputStream.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return response;
        }
    }
}
