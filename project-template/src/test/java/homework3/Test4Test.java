package homework3;

import org.junit.Test;
import static org.junit.Assert.*;

public class Test4Test {

    @Test
    public void test() {
        assertEquals("I", Task4.convertToRoman(1));
        assertEquals("II", Task4.convertToRoman(2));
        assertEquals("IV", Task4.convertToRoman(4));
        assertEquals("V", Task4.convertToRoman(5));
        assertEquals("IX", Task4.convertToRoman(9));
        assertEquals("X", Task4.convertToRoman(10));
        assertEquals("XL", Task4.convertToRoman(40));
    }
}
