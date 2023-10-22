package edu.hw2;

import edu.hw2.Task2_4.CallingInfo;
import edu.hw2.Task2_4.Task2_4;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Test4 {

    @Test
    void testCallingInfo() {
        CallingInfo info = Task2_4.callingInfo();
        assertEquals(info.className(), "edu.hw2.Test4");
        assertEquals(info.methodName(), "testCallingInfo");
    }


}
