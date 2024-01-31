package org.example;

import java.util.Scanner;

public class UserStorage {

    private int userCounter = 1;
    private final User[] users = new User[10];

    public void registerUser(User user) {
        user.setId(userCounter);
        users[userCounter - 1] = user;
        userCounter++;
        System.out.println(user);
    }

    public void getAllUsers() {
        for (int i = 0; i < userCounter - 1; i++) {
            System.out.println(users[i]);
        }
    }

    public User getUser(int userId) {
        return users[userId - 1];
    }

}
