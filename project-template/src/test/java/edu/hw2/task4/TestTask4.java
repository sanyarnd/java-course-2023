package edu.hw2.task4;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TestTask4 {
    @Test
    public void assertThatCallingInfoContainsContainsSelfMethodCallTest() {
        List<CallingInfo> callingInfos = Task4.callingInfo();
        CallingInfo callingMethod = new CallingInfo(Task4.class.getName(), Task4.class.getMethods()[0].getName());
        assertTrue(callingInfos.stream()
            .anyMatch(info -> info.equals(callingMethod)));
    }
}
