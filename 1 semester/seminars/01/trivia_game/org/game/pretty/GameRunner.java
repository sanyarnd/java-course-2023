package org.game.pretty;

import org.game.pretty.player.Player;
import org.game.pretty.player.PlayersProvider;
import org.game.pretty.question.generation.PopQuestionStrategy;
import org.game.pretty.question.generation.QuestionGenerationStrategy;
import org.game.pretty.question.generation.RockQuestionStrategy;
import org.game.pretty.question.generation.ScienceQuestionStrategy;
import org.game.pretty.question.generation.SportsQuestionStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GameRunner {
    public static void main(String[] args) {
        int coinsForWinAmount = 6;
        int boardFieldsCount = 12;
        WinnerChecker winnerChecker = new WinnerChecker(coinsForWinAmount);
        Dice dice = new Dice();
        Prison prison = new Prison();
        Board board = new Board(buildQuestionMap(), boardFieldsCount);
        PlayersProvider playersProvider = new PlayersProvider(registerPlayers());

        Game game = new Game(playersProvider, prison, board, dice, winnerChecker);

        game.play();
    }

    private static ArrayList<Player> registerPlayers() {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("Chet"));
        players.add(new Player("Pat"));
        players.add(new Player("Sue"));

        return players;
    }

    private static Map<Integer, QuestionGenerationStrategy> buildQuestionMap() {
        Map<Integer, QuestionGenerationStrategy> questionGenerationStrategyMap = new HashMap<>();
        questionGenerationStrategyMap.put(0, new PopQuestionStrategy());
        questionGenerationStrategyMap.put(1, new RockQuestionStrategy());
        questionGenerationStrategyMap.put(2, new ScienceQuestionStrategy());
        questionGenerationStrategyMap.put(3, new SportsQuestionStrategy());
        return questionGenerationStrategyMap;
    }
}
