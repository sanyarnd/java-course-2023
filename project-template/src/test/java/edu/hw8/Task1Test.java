package edu.hw8;

import edu.hw8.task1.Client;
import edu.hw8.task1.Server;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task1Test {
    static List<String> responses;
    static List<String> answers;

    @BeforeAll
    static void setUp() {
        responses = List.of(
            "Не переходи на личности там, где их нет",
            "Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами",
            "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма.",
            "Чем ниже интеллект, тем громче оскорбления"
        );
        answers = List.of(
            "личности",
            "оскорбления",
            "глупый",
            "интеллект"
        );
    }

    @Test
    void start() throws InterruptedException {
        int port = 8888;
        int maxConnections = 2;
        String serverIp = "localhost";
        var actualResponses = new String[answers.size()];

        var server = new Server(responses);
        var serverThread = new Thread(() -> server.start(port, maxConnections));
        serverThread.start();

        Thread[] clientThreads = new Thread[answers.size()];
        for (int i = 0; i < clientThreads.length; i++) {
            int finalI = i;
            clientThreads[i] = new Thread(() -> {
                var client = new Client(serverIp, port);
                client.openConnection();
                actualResponses[finalI] = client.sendMsgGetResponse(answers.get(finalI));
                client.closeConnection();
            });
            clientThreads[i].start();
        }

        for (Thread thread : clientThreads) {
            thread.join();
        }

        serverThread.interrupt();

        for (int i = 0; i < actualResponses.length; i++) {
            assertEquals(actualResponses[i], responses.get(i));
        }
    }
}
