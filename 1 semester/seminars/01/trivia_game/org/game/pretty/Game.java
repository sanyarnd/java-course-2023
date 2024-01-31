package org.game.pretty;

import org.game.pretty.player.Player;
import org.game.pretty.player.PlayersProvider;
import org.game.pretty.question.Question;

public class Game {

    private final Prison prison;
    private final Board board;
    private final Dice dice;
    private final PlayersProvider playersProvider;
    private final WinnerChecker winnerChecker;

    public Game(PlayersProvider playersProvider, Prison prison, Board board, Dice dice, WinnerChecker winnerChecker) {
        this.playersProvider = playersProvider;
        this.prison = prison;
        this.board = board;
        this.dice = dice;
        this.winnerChecker = winnerChecker;
    }

    public void play() {
        System.out.println("Start the Game");
        Player currentPlayer;

        do {
            currentPlayer = playersProvider.getNext();
            System.out.printf("%s is the current player%n", currentPlayer.getName());

            makeMove(currentPlayer);

        } while (!winnerChecker.isPlayerWinner(currentPlayer));

        System.out.printf("%s is a winner!", playersProvider.getCurrent().getName());
    }

    private void makeMove(Player currentPlayer) {
        int roll = dice.roll();
        System.out.printf("%s have rolled a %s%n", currentPlayer.getName(), roll);

        if (currentPlayer.isPrisoned() && !prison.canEscape(roll)) {
            System.out.printf("%s is not getting out of the prison%n%n", currentPlayer.getName());
            return;
        }
        currentPlayer.setPrisoned(false);

        int position = changePosition(currentPlayer, roll);
        Question question = board.getQuestion(position);
        boolean hasAnsweredCorrectly = question.checkAnswer(currentPlayer.getAnswer());

        if (hasAnsweredCorrectly) {
            increaseCoinAmountAndLog(currentPlayer, question);
        } else {
            sendToPrisonAndLog(currentPlayer);
        }
    }

    private int changePosition(Player player, int roll) {
        int position = board.playerNewPosition(player.getBoardPosition(), roll);
        player.setBoardPosition(position);

        return position;
    }

    private void increaseCoinAmountAndLog(Player currentPlayer, Question question) {
        currentPlayer.increaseCoinsAmount(question.getReward());
        System.out.printf("Answer was correct!!!!%n");
        System.out.printf("%s now has %s gold coins%n%n", currentPlayer.getName(), currentPlayer.getCoins());
    }

    private void sendToPrisonAndLog(Player currentPlayer) {
        currentPlayer.setPrisoned(true);
        System.out.printf("Question was incorrectly answered%n");
        System.out.printf("%s was sent to the prison%n%n", currentPlayer.getName());
    }

}
