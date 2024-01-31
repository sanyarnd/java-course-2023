package org.game.pretty.question;

public class Question {

    private final String question;
    private final int answer;
    private final QuestionCategory category;
    private final int reward;
    private final int optionCount;

    public Question(String question, int answer, QuestionCategory category, int reward, int optionCount) {
        this.question = question;
        this.answer = answer;
        this.category = category;
        this.reward = reward;
        this.optionCount = optionCount;
    }

    public boolean checkAnswer(int playerAnswer) {
        return this.answer % 3 == playerAnswer % 3;
    }

    public String getQuestion() {
        return question;
    }

    public QuestionCategory getCategory() {
        return category;
    }

    public int getReward() {
        return reward;
    }

    public int getOptionCount() {
        return optionCount;
    }
}
