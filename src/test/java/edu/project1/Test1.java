package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test1 {
    @Test
    @DisplayName("Игра")
    void game(){
        assertEquals(Check.checkSim('я'), true);
        assertEquals(Check.checkSim('s'), false);
        assertEquals(Check.checkMenu("меню"), true);
        assertEquals(Check.checkMenu("неменю"), false);
        assertEquals(Check.checkWord("неменю"), false);
        assertEquals(Check.checkWord("стена"), true);
        assertEquals(Check.checkWord("  ..!"), false);
    }
}
