package edu.hw2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Task4Test {

    @Test
    public void testCallingInfo() {
        Task4.CallingInfo callingInfo = Task4.callingInfo();
        assertNotNull(callingInfo);
        assertNotNull(callingInfo.className());
        assertNotNull(callingInfo.methodName());
    }

    @Test
    public void testCallingInfoContent() {
        Task4.CallingInfo callingInfo = Task4.callingInfo();
        assertNotNull(callingInfo);
        assertEquals("edu.hw2.Task4Test", callingInfo.className());
        assertEquals("testCallingInfoContent", callingInfo.methodName());
    }
}
