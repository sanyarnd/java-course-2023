package org.game.pretty;

import org.game.pretty.question.Question;
import org.game.pretty.question.generation.QuestionGenerationStrategy;

import java.util.Map;

public class Board {
    private final Map<Integer, QuestionGenerationStrategy> moduloToProvider;
    private final int boardFieldsCount;

    public Board(Map<Integer, QuestionGenerationStrategy> moduloToProvider,
                 int boardFieldsCount) {
        this.moduloToProvider = moduloToProvider;
        this.boardFieldsCount = boardFieldsCount;
    }

    public Question getQuestion(int boardPosition) {
        validatePlayerPosition(boardPosition);

        int themesCount = moduloToProvider.keySet().size();
        int key = boardPosition % themesCount;

        return getQuestionStrategy(key)
                .getQuestion();
    }

    // вынес сюда, поскольку может быть неочевидно (ловушки, змейки, лестницы)
    public int playerNewPosition(int currentPosition, int userStep) {
        return (currentPosition + userStep) % boardFieldsCount;
    }

    private void validatePlayerPosition(int boardPosition) {
        if (boardPosition > boardFieldsCount) {
            String message = "Board position can't be greater than %s!".formatted(boardFieldsCount);
            throw new IllegalArgumentException(message);
        }
    }

    private QuestionGenerationStrategy getQuestionStrategy(int key) {
        QuestionGenerationStrategy questionGenerationStrategy = moduloToProvider.get(key);
        if (questionGenerationStrategy == null) {
            throw new IllegalArgumentException("Incorrect filling of question themes provider!");
        }

        return questionGenerationStrategy;
    }
}
