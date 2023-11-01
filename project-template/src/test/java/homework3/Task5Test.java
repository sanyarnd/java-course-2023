package homework3;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class Task5Test {
    @Test
    public void testParseContactsAscendingOrder() {
        String[] names = {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"};
        List<Task5> result = Task5.parseContacts(names, "ASC");

        assertEquals("Astaf Bobin", result.get(0).fullName());
        assertEquals("Krasiviy Macho", result.get(1).fullName());
        assertEquals("Jestkiy Chel", result.get(2).fullName());
        assertEquals("Nerealniy Pozik", result.get(3).fullName());
    }

    @Test
    public void testParseContactsDescendingOrder() {
        String[] names = {"Astaf Bobin", "Krasiviy Macho", "Jestkiy Chel", "Nerealniy Pozik"};
        List<Task5> result = Task5.parseContacts(names, "DESC");

        assertEquals("Astaf Bobin", result.get(0).fullName());
        assertEquals("Prikolist Normalniy", result.get(1).fullName());
        assertEquals("RJestkiy Chel", result.get(2).fullName());
        assertEquals("Nerealniy Pozik", result.get(3).fullName());
    }

}
