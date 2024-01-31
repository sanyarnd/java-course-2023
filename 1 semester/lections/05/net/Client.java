package tinkoff2.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket(InetAddress.getByName("localhost"), 18080);
        var response = new BufferedReader(new InputStreamReader(client.getInputStream())).readLine();
        System.out.println(response);
    }
}
