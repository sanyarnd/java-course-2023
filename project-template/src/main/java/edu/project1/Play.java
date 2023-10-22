package edu.project1;

public class Play {
    private final String word;
    public StringBuilder starWord;
    private int counterAttempts;
    private final int lenWord;
    public Play(String word){
        this.word = word;
        this.lenWord = word.length();
        starWord = new StringBuilder("*".repeat(lenWord));
        counterAttempts = lenWord - 1;
    }

    public boolean play(){
        while (counterAttempts >= 0){
            String s = Input.input();
            if (s.length() == 1){
                if (simInWord(s.charAt(0))) {
                    newStarWord(s.charAt(0));
                    if (wordEqual()) {
                        Output.userWon(word);
                        Output.nextOrFinish();
                        return Input.inputNext();
                    }
                    Output.hit(s, starWord.toString());
                    if (counterAttempts > 0)
                        Output.countAttempt(counterAttempts);
                }
                else{
                    Output.simNotInWord(starWord.toString());
                    if (counterAttempts > 0)
                        Output.countAttempt(counterAttempts);
                }
                counterAttempts--;
            }
            else if (Check.checkMenu(s)){
                if (s.equals("меню")) Output.menu();
                else if (s.equals("закончить")) {
                    Output.endGame();
                    return false;
                }
                else if (s.equals("начало")) {
                    return true;
                }
                else Output.rules();
            }
            else {
                if (s.equals(word)) {
                    Output.userWon(word);
                    Output.nextOrFinish();
                    return Input.inputNext();
                } else {
                    Output.notWord(starWord.toString());
                    if (counterAttempts > 0)
                        Output.countAttempt(counterAttempts);
                }
                counterAttempts--;
            }
            if (counterAttempts == -1) {
                Output.userLost(word);
                Output.nextOrFinish();
                return Input.inputNext();
            }
        }
        return true;
    }

    private boolean simInWord(char sim){
        boolean ans = false;
        for(int i = 0; i < lenWord; ++i)
            if (word.charAt(i) == sim) {
                ans = true;
                break;
            }
        return ans;
    }

    private void newStarWord(char sim){
        for(int i = 0; i < lenWord; ++i)
            if (this.word.charAt(i) == sim) this.starWord.setCharAt(i, sim);
    }

    private boolean wordEqual(){
        return word.contentEquals(starWord);
    }
}
