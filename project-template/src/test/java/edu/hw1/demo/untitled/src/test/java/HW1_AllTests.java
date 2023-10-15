package edu.hw1.demo.untitled.src.test.java;

import org.junit.jupiter.api.Test;
import org.lisi4ka.tasks.Task1;
import org.lisi4ka.tasks.Task2;
import org.lisi4ka.tasks.Task3;
import org.lisi4ka.tasks.Task4;
import org.lisi4ka.tasks.Task5;
import org.lisi4ka.tasks.Task6;
import org.lisi4ka.tasks.Task7;
import org.lisi4ka.tasks.Task8;

import static org.junit.jupiter.api.Assertions.*;

class HW1_AllTests {
    @Test
    void test1() {
        assertEquals(61, Task1.task1("1:01"));
        assertEquals(-1, Task1.task1("-12:09"));
        assertEquals(-1, Task1.task1("12:69"));
        assertThrows(NumberFormatException.class,() -> Task1.task1("hello"));
    }
    @Test
    void test2() {
        assertEquals(7, Task2.task2("1234567"));
        assertEquals(3, Task2.task2("-231"));
        assertEquals(4, Task2.task2("12.54"));
        assertEquals(1, Task2.task2("0"));
        assertThrows(NumberFormatException.class,() -> Task2.task2("hello"));
        assertThrows(NumberFormatException.class,() -> Task2.task2("12.34.45"));
    }
    @Test
    void test3() {
        assertEquals(false, Task3.task3("1 2 3 4 5 6 7,3 4"));
        assertEquals(false, Task3.task3("1 7,3 44"));
        assertEquals(true, Task3.task3("3 4 5 6,1 2 3 4 5 6 7 8 8 8 65"));
        assertEquals(true, Task3.task3("444,443 445"));
        assertEquals(false, Task3.task3("44,44 44"));
        assertThrows(ArrayIndexOutOfBoundsException.class,() -> Task3.task3("hello"));
        assertThrows(ArrayIndexOutOfBoundsException.class,() -> Task3.task3("1 2,3 4,4 5"));
    }
    @Test
    void test4() {
        assertEquals("214365", Task4.task4("123456"));
        assertEquals("This is a mixed up string.", Task4.task4("hTsii  s aimex dpus rtni.g"));
        assertEquals("", Task4.task4(""));
        assertEquals("1", Task4.task4("1"));
        assertEquals("345", Task4.task4("435"));
    }
    @Test
    void test5() {
        assertEquals(true, Task5.task5("123312"));
        assertEquals(true, Task5.task5("2333"));
        assertEquals(true, Task5.task5("232"));
        assertEquals(false, Task5.task5("1"));
        assertEquals(false, Task5.task5("12"));
        assertEquals(true, Task5.task5("0110"));
        assertThrows(NumberFormatException.class,() -> Task5.task5("hello"));
        assertThrows(NumberFormatException.class,() -> Task5.task5("12 45"));
    }
    @Test
    void test6() {
        assertEquals(5, Task6.task6("6621"));
        assertEquals(4, Task6.task6("6554"));
        assertEquals(3, Task6.task6("1234"));
        assertEquals(4, Task6.task6("1001"));
        assertEquals(5, Task6.task6("1011"));
        assertThrows(NumberFormatException.class,() -> Task6.task6("hello"));
        assertThrows(NumberFormatException.class,() -> Task6.task6("1111"));
        assertThrows(NumberFormatException.class,() -> Task6.task6("12.34.45"));
        assertThrows(NumberFormatException.class,() -> Task6.task6("1000"));
        assertThrows(NumberFormatException.class,() -> Task6.task6("10000"));
    }
    @Test
    void test7() {
        assertEquals("0100", Task7.task7right("8,1"));
        assertEquals("101", Task7.task7right("5,2"));
        assertEquals("1", Task7.task7right("1,1"));
        assertEquals("111", Task7.task7left("7,3"));
        assertEquals("10", Task7.task7left("2,2"));
        assertEquals("0101", Task7.task7left("10,1"));
        assertThrows(NumberFormatException.class,() -> Task7.task7right("12.34.45"));
        assertThrows(NumberFormatException.class,() -> Task7.task7right("hello"));
        assertThrows(NumberFormatException.class,() -> Task7.task7left("12.34.45"));
        assertThrows(NumberFormatException.class,() -> Task7.task7left("hello"));
    }
    @Test
    void test8() {
        assertEquals(false, Task8.task8("1 0 0 1 0 0 0 0:0 0 0 0 0 0 0 0:0 1 0 1 0 1 0 0:0 0 0 0 1 0 1 0:0 1 0 0 0 1 1 0:0 0 0 0 0 0 0 0:0 1 0 0 1 0 0 1:0 0 0 1 1 0 1 0"));
        assertEquals(true, Task8.task8("0 0 0 1 0 0 0 0:0 0 0 0 0 0 0 0:0 1 0 0 0 1 0 0:0 0 0 0 1 0 1 0:0 1 0 0 0 1 0 0:0 0 0 0 0 0 0 0:0 1 0 0 0 0 0 1:0 0 0 0 1 0 0 0"));
        assertEquals(false, Task8.task8("1 1 1 1 1 1 1 1:1 1 1 1 1 1 1 1:1 1 1 1 1 1 1 1:1 1 1 1 1 1 1 1:1 1 1 1 1 1 1 1:1 1 1 1 1 1 1 1:1 1 1 1 1 1 1 1:1 1 1 1 1 1 1 1"));
        assertEquals(true, Task8.task8("0 0 0 0 0 0 0 0:0 0 0 0 0 0 0 0:0 0 0 0 0 0 0 0:0 0 0 0 0 0 0 0:0 0 0 0 0 0 0 0:0 0 0 0 0 0 0 0:0 0 0 0 0 0 0 0:0 0 0 0 0 0 0 0"));
        assertEquals(false, Task8.task8("0 0 0 1 0 0 0 0:0 0 0 1 0 1 0 0:0 1 0 0 0 1 0 0:0 0 0 1 1 0 1 0:0 1 0 0 0 1 0 0:0 1 1 1 1 0 0 0:0 1 0 0 0 1 1 1:0 0 0 1 1 0 0 0"));
        assertThrows(NumberFormatException.class,() -> Task8.task8("12.34.45"));
        assertThrows(NumberFormatException.class,() -> Task8.task8("hello"));
    }
}
