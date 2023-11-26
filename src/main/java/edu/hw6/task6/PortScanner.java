package edu.hw6.task6;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;

public class PortScanner {
    public static void main(String[] args) {
        for (int port = 49000; port <= 49151; port++) {
            try {
                ServerSocket serverSocket = new ServerSocket(port);
                serverSocket.close();
                System.out.println("TCP\t" + port + "\tFree");
            } catch (IOException e) {
                System.out.println("TCP\t" + port + "\tOccupied");
            }
        }

        for (int port = 49000; port <= 49151; port++) {
            try {
                DatagramSocket datagramSocket = new DatagramSocket(port);
                datagramSocket.close();
                System.out.println("UDP\t" + port + "\tFree");
            } catch (IOException e) {
                System.out.println("UDP\t" + port + "\tOccupied");
            }
        }

        System.out.println("\nCommon Ports:");
        System.out.println("TCP\t135\tEPMAP");
        System.out.println("UDP\t137\tNetBIOS Name Service");
        System.out.println("UDP\t138\tNetBIOS Datagram Service");
        System.out.println("TCP\t139\tNetBIOS Session Service");
        System.out.println("TCP\t445\tMicrosoft-DS Active Directory");
        System.out.println("TCP\t843\tAdobe Flash");
        System.out.println("UDP\t1900\tSSDP");
        System.out.println("UDP\t3702\tWS-Discovery");
        System.out.println("TCP\t5040");
        System.out.println("UDP\t5050");
        System.out.println("UDP\t5353\tMulticast DNS");
        System.out.println("UDP\t5355\tLLMNR");
        System.out.println("TCP\t5939");
        System.out.println("TCP\t6463");
        System.out.println("TCP\t6942");
        System.out.println("TCP\t17500\tDropbox LAN Sync Protocol");
        System.out.println("UDP\t17500\tDropbox LAN Sync Protocol");
        System.out.println("TCP\t17600");
        System.out.println("TCP\t27017\tMongoDB");
        System.out.println("UDP\t42420");
    }
}
