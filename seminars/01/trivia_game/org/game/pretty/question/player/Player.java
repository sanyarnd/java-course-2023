package org.game.pretty.question.player;

import java.util.Random;

public class Player {

    private static final Random RANDOMIZER = new Random();

    private String name;
    private int coins;
    private int positionOnBoard;
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

    public void addCoin() {
        this.coins++;
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

    public void imprison() {
        this.prisoned = true;
    }

    public void releaseFromPrison() {
        this.prisoned = false;
    }

    public int getAnswer(int options) {
        return RANDOMIZER.nextInt(options);
    }

    public void addCoins(int amount) {
        this.coins += amount;
    }

    public int getPositionOnBoard() {
        return positionOnBoard;
    }

    public void setPositionOnBoard(int positionOnBoard) {
        this.positionOnBoard = positionOnBoard;
    }

    @Override
    public String toString() {
        return name;
    }
}
