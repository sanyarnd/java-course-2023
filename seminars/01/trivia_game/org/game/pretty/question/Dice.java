package org.game.pretty.question;

import java.util.Random;

public class Dice {
    private static final int DICE_LOWER_BOUND = 1;
    private static final int DICE_HIGHER_BOUND = 7;

    private final Random randomizer = new Random();

    public int roll() {
        return randomizer.nextInt(DICE_LOWER_BOUND, DICE_HIGHER_BOUND);
    }
}
