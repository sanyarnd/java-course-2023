package org.example;

import java.util.Scanner;

public class CommandLineParser {

    private static final String EXIT_CMD = "exit";
    private static final String ADD_TASK = "addTask";
    private static final String GET_TASK = "getTask";
    private static final String GET_ALL_TASK = "getAllTask";
    private static final String GET_HISTORY = "getHistory";

    private static final String HELP_MESSAGE = """
        Commands:
        - addTask
        - getTask <taskId>
        """;

    private final Scanner scanner = new Scanner(System.in);
    private final CommandHandler commandHandler = new CommandHandler();

    public void run() {
        String input = null;
        while (!EXIT_CMD.equals(input)) {
            input = scanner.nextLine();
            String[] args = input.split(" ");
            String command = extractCommand(args);
            String result = switch (command) {
                case ADD_TASK -> commandHandler.addTask(args);
                case GET_TASK -> commandHandler.getTask(args);
                case GET_HISTORY -> commandHandler.getHistory(args);
                case GET_ALL_TASK -> commandHandler.getAllTasks(args);
                case null, default -> HELP_MESSAGE;
            };
            System.out.println(result);
        }
    }

    private String extractCommand(String[] args) {
        if (args.length > 0) {
            return args[0];
        }
        return null;
    }

}
