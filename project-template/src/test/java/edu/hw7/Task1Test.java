package edu.hw7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task1Test {
    @Test public void testCounter1() throws InterruptedException {
        int thredNum = 6;
        int incrNum = 999;

        assertEquals(thredNum * incrNum, Task1.count(thredNum, incrNum));
    }

    @Test public void testCounter2() throws InterruptedException {
        int thredNum = 5;
        int incrNum = 1234;

        assertEquals(thredNum * incrNum, Task1.count(thredNum, incrNum));
    }
}

