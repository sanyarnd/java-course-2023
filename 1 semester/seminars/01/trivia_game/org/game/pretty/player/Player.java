package org.game.pretty.player;

import java.util.Random;

public class Player {

    private static final Random RANDOMIZER = new Random();
    private static final int ANSWER_UPPER_BOUND = 10;

    private String name;
    private int coins = 0;
    private int boardPosition = 1;
    private boolean prisoned = false;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public boolean isPrisoned() {
        return prisoned;
    }

    public void setPrisoned(boolean prisoned) {
        this.prisoned = prisoned;
    }

    public int getBoardPosition() {
        return boardPosition;
    }

    public void setBoardPosition(int boardPosition) {
        this.boardPosition = boardPosition;
    }

    public int getAnswer() {
        return RANDOMIZER.nextInt(ANSWER_UPPER_BOUND);
    }

    public void increaseCoinsAmount(int amount) {
        this.coins += amount;
    }
}
