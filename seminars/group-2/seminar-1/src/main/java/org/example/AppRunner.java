package org.example;

import java.util.Scanner;

public class AppRunner {

    private static final String REGISTER_USER_COMMAND = "registerUser";
    private static final String SEND_MESSAGE_COMMAND = "sendMessage";
    private static final String GET_ALL_USERS_COMMAND = "getAllUsers";
    private static final String EXIT_COMMAND = "exit";
    private static final String HELP_MESSAGE = """
        There are next commands
        - registerUser
        - sendMessage
        - exit
        """;

    public void runMessageApplication() {
        Scanner scanner = new Scanner(System.in);
        UserStorage userStorage = new UserStorage();
        UserReader userReader = new UserCliReader(scanner);
        MessageReader messageReader = new MessageCliReader(scanner);
        MessageFilter[] messageFilters = new MessageFilter[] {
            new CountryFilter(userStorage),
            new BadWordsFilter()
        };
        MessageSender messageSender = new MessageSender(userStorage, messageFilters);

        String command = null;
        while (isNotExit(command)) {
            command = scanner.nextLine();
            switch (command) {
                case REGISTER_USER_COMMAND -> userStorage.registerUser(userReader.readUser());
                case SEND_MESSAGE_COMMAND -> messageSender.sendMessage(messageReader.readMessage());
                case GET_ALL_USERS_COMMAND -> userStorage.getAllUsers();
                case null, default -> System.out.println(HELP_MESSAGE);
            }
        }
    }

    private boolean isNotExit(String command) {
        return !isExit(command);
    }

    private boolean isExit(String command) {
        return EXIT_COMMAND.equals(command);
    }


}
