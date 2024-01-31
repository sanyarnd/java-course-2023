package org.game.pretty.question.generation;


import org.game.pretty.question.QuestionCategory;

public class SportsQuestionStrategy extends QuestionGenerationStrategy {
    private static final String QUESTION_TEMPLATE = "Sports question %s";

    private int questionCounter = 0;

    @Override
    protected String getTemplate() {
        return QUESTION_TEMPLATE;
    }

    @Override
    protected int getQuestionCounter() {
        return questionCounter++;
    }

    @Override
    protected QuestionCategory getCategory() {
        return QuestionCategory.SCIENCE;
    }
}
