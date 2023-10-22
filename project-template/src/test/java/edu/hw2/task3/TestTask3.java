package edu.hw2.task3;

import org.junit.jupiter.api.Test;
import java.util.stream.IntStream;
import static org.junit.jupiter.api.Assertions.*;

public class TestTask3 {
    private static final int RANGE_TEST_ITERATIONS = 10_000;

    @Test
    public void assertThatFaultyConnectionManagerAlwaysReturnedFaultyConnectionTest() {
        assertTrue(IntStream.range(0, RANGE_TEST_ITERATIONS)
            .mapToObj(i -> new FaultyConnectionManager())
            .allMatch(manager -> manager.getConnection() instanceof FaultyConnection));
    }

    @Test
    public void assertThatDefaultConnectionManagerAnytimeReturnedFaultyConnectionTest() {
        assertTrue(IntStream.range(0, RANGE_TEST_ITERATIONS)
            .mapToObj(i -> new DefaultConnectionManager())
            .anyMatch(manager -> manager.getConnection() instanceof FaultyConnection));
    }

    @Test
    public void assertThatStableConnectionNeverThrowException() {
        IntStream.range(0, RANGE_TEST_ITERATIONS)
            .mapToObj(i -> new StableConnection())
            .forEach(connection -> assertDoesNotThrow(() -> connection.execute("")));
    }

    @Test
    public void assertThatFaultyConnectionAnytimeThrowExceptionTest() {
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
        PopularCommandExecutor executor = new PopularCommandExecutor(new DefaultConnectionManager(), 100);

        IntStream.range(0, RANGE_TEST_ITERATIONS)
            .forEach(i -> assertDoesNotThrow(executor::updatePackages));
    }

    @Test
    public void assertThatPopularCommandExecutorWithFaultyConnectionManagerWillDrop() {
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
