package edu.project1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Output {
    private final static Logger LOGGER = LogManager.getLogger(Output.class.getName());

    private Output() {
    }

    public static void welcome() {
        LOGGER.info("Добро пожаловать в Средневековье!");
        LOGGER.info("Вы приговорены к виселице без объяснения причины!");
        LOGGER.info("Но у вас есть шанс её избежать, отгадав слово, которое Король Байтландии загадал лично!");
    }

    public static void rules() {
        LOGGER.info("Загаданное слово состоит из 5 букв и является общеизвестным русским словом.");
        LOGGER.info("На то, чтобы угадать слово у вас есть не более 5 попыток.");
        LOGGER.info("В каждой попытке вам доступны два действия:");
        LOGGER.info(
            "1) Назвать букву из русского алфавита. Если эта буква есть в загаданном слове, то вы увидете её "
                + "местоположение в слове.");
        LOGGER.info(
            "2) Назвать слово целиком. Если вы называете загаданное слово, "
                + "то побеждаете сразу, иначе вы теряете попытку!");
    }

    public static void menu() {
        LOGGER.info("Меню:");
        LOGGER.info("Если вы хотите посмотреть правила, то напишите слово ПРАВИЛА");
        LOGGER.info("Если вы хотите начать игру сначала, то напишите слово НАЧАЛО");
        LOGGER.info("Если вы хотите закончить игру прямо сейчас, то напишите слово ЗАКОНЧИТЬ");
        LOGGER.info("Для вызова меню напишите МЕНЮ");
    }

    public static void makeWord() {
        LOGGER.info("Король загадал слово!");
        LOGGER.info("У вас есть 5 попыток! Удачи!");
    }

    private static String formWord(int x) {
        final int ATTEMPTS = 5;
        if (x == ATTEMPTS) {
            return "попыток";
        } else if (x == 1) {
            return "попытка";
        }
        return "попытки";
    }

    public static void waitWordOrLetter() {
        LOGGER.info("Введите букву или слово:");
    }

    public static void incorrectSim() {
        LOGGER.info("Вы точно ввели букву русского алфавита? Попробуйте снова!");
    }

    public static void incorrectWord() {
        LOGGER.info("Вы ввели некорректное слово! Попробуйте снова!");
    }

    public static void userWon(String word) {
        LOGGER.info("Вы угадали слово " + word.toUpperCase() + " и Король Байтландии помиловал вас!");
    }

    public static void endGame() {
        LOGGER.info("К сожалению, вы сдались и теперь болтаетесь на висилице!");
    }

    public static void nextOrFinish() {
        LOGGER.info("Хотите сыграть ещё раз? Если да, то введите ПРОДОЛЖИТЬ, иначе ЗАКОНЧИТЬ");
    }

    public static void hit(String sim, String starWord) {
        LOGGER.info("Вы угадали букву " + sim.toUpperCase() + "!");
        outputStarWord(starWord);
    }

    public static void simNotInWord(String starWord) {
        LOGGER.info("К сожалению, этой буквы в слове нет и вы на шаг ближе к виселице!");
        outputStarWord(starWord);
    }

    public static void countAttempt(int counterAttempt) {
        LOGGER.info("У вас осталось всего лишь " + counterAttempt + " " + formWord(counterAttempt) + "!");
    }

    public static void notWord(String starWord) {
        LOGGER.info("Увы, но это не то слово.");
        outputStarWord(starWord);
    }

    public static void outputStarWord(String starWord) {
        LOGGER.info("Загаданное слово - " + starWord.toUpperCase() + "!");
    }

    public static void userLost(String word) {
        LOGGER.info("К сожалению, вам не удалось избежать виселицы.");
        outputStarWord(word);
    }

    public static void bye() {
        LOGGER.info("До новых встреч в стредневековье!");
    }
}
