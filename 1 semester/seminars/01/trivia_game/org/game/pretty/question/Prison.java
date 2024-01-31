package org.game.pretty.question;

public class Prison {

    public boolean canEscape(int rollResult) {
        return rollResult % 2 == 1;
    }
}
