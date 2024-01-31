package org.example;

import java.util.Scanner;

public class UserCliReader implements UserReader {

    private final Scanner scanner;

    public UserCliReader(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public User readUser() {
        User user = new User();
        System.out.println("name: ");
        user.setLogin(scanner.nextLine());
        System.out.println("mail: ");
        user.setMailAddress(scanner.nextLine());
        System.out.println("tg: ");
        user.setTgAddress(scanner.nextLine());
        System.out.println("allow countries: ");
        user.setAllowCountries(scanner.nextLine().split(", "));
        return user;
    }

}
