package org.example;

import java.util.Scanner;

public class MessageCliReader implements MessageReader {

    private final Scanner scanner;

    public MessageCliReader(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Message readMessage() {
        Message message = new Message();
        System.out.println("message: ");
        message.setBody(scanner.nextLine());
        System.out.println("from: ");
        message.setFrom(scanner.nextLine());
        System.out.println("toUserId: ");
        message.setToUserId(Integer.parseInt(scanner.nextLine()));
        System.out.println("toMessanger: ");
        message.setDestinations(scanner.nextLine().split(", "));
        return message;
    }
}
