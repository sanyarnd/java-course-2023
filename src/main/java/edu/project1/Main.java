package edu.project1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        Output.welcome();
        while (true){
            Output.rules();
            Output.menu();
            Output.makeWord();
            Play play = new Play(WordGen.wordGeneration());
            if (!play.play()) break;
        }
        Output.bye();
    }
}
