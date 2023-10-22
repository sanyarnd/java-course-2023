package org.game.pretty.question.generation;

import org.game.pretty.question.Question;
import org.game.pretty.question.QuestionCategory;

import java.util.Random;

public abstract class QuestionGenerationStrategy {
    private static final Random RANDOMIZER = new Random();
    private static final int RANDOM_ANSWER_BOUND = 10;
    private static final int QUESTION_REWARD = 1;
    public static final int DEFAULT_OPTION_COUNT = 3;

    public Question getQuestion() {
        String question = getTemplate().formatted(getQuestionCounter());
        int answer = RANDOMIZER.nextInt(RANDOM_ANSWER_BOUND);
        QuestionCategory category = getCategory();

        return new Question(question, answer, category, QUESTION_REWARD, optionCount());
    }

    protected abstract String getTemplate();
    protected abstract int getQuestionCounter();
    protected abstract QuestionCategory getCategory();

    protected int optionCount() {
        return DEFAULT_OPTION_COUNT;
    }
}
