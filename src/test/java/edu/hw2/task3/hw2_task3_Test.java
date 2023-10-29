package edu.hw2.task3;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class hw2_task3_Test {
    private static final int RANGE_TEST_ITERATIONS = 100;

    @Test
    public void faultyConnectionManagerAlwaysReturnedFaultyConnection() {
        var faultyConnectionManager1 = new FaultyConnectionManager();
        var faultyConnectionManager2 = new FaultyConnectionManager();

        assertTrue(faultyConnectionManager1.getConnection() instanceof FaultyConnection);
        assertTrue(faultyConnectionManager2.getConnection() instanceof FaultyConnection);
    }

    @Test
    public void stableConnectionNeverThrowException() {
        for (int i = 0; i < RANGE_TEST_ITERATIONS; i++) {
            var stableConnection1 = new StableConnection();
            var stableConnection2 = new StableConnection();

            assertDoesNotThrow(() -> stableConnection1.execute(""));
            assertDoesNotThrow(() -> stableConnection2.execute(""));
        }
    }

    @Test
    public void faultyConnectionAnytimeThrowException() {
        var someFaultyConnectionThrown = false;

        for (int i = 0; i < RANGE_TEST_ITERATIONS; i++) {
            try (var connection = new FaultyConnection()) {
                connection.execute("");
            } catch (Exception ignored) {
                someFaultyConnectionThrown = true;
                break;
            }
        }

        assertTrue(someFaultyConnectionThrown);
    }

    @Test
    public void assertThatPopularCommandExecutorWithDefaultConnectionManagerWillNotDrop() {
        for (int i = 0; i < RANGE_TEST_ITERATIONS; i++) {
            PopularCommandExecutor executor = new PopularCommandExecutor(new DefaultConnectionManager(), 100);
            assertDoesNotThrow(executor::updatePackages);
        }
    }

    @Test
    public void popularCommandExecutorWithFaultyConnectionManagerWillDrop() {
        PopularCommandExecutor executor = new PopularCommandExecutor(new FaultyConnectionManager(), 2);

        boolean someConnectionThrown = false;

        for (int i = 0; i < RANGE_TEST_ITERATIONS; i++) {
            try {
                executor.updatePackages();
            } catch (ConnectionException ignored) {
                someConnectionThrown = true;
                break;
            }
        }

        assertTrue(someConnectionThrown);
    }
}
