package edu.project1;

public class Output {
    public static void welcome(){
        System.out.println("Добро пожаловать в Средневековье!");
        System.out.println("Вы приговорены к виселице без объяснения причины!");
        System.out.println("Но у вас есть шанс её избежать, отгадав слово, которое Король Байтландии загадал лично!");
    }

    public static void rules(){
        System.out.println("Загаданное слово состоит из 5 букв и является общеизвестным русским словом.");
        System.out.println("На то, чтобы угадать слово у вас есть не более 5 попыток.");
        System.out.println("В каждой попытке вам доступны два действия:");
        System.out.println("1) Назвать букву из русского алфавита. Если эта буква есть в загаданном слове, то вы увидете её местоположение в слове.");
        System.out.println("2) Назвать слово целиком. Если вы называете загаданное слово, то побеждаете сразу, иначе вы теряете попытку!");
    }

    public static void menu(){
        System.out.println("Меню:");
        System.out.println("Если вы хотите посмотреть правила, то напишите слово ПРАВИЛА");
        System.out.println("Если вы хотите начать игру сначала, то напишите слово НАЧАЛО");
        System.out.println("Если вы хотите закончить игру прямо сейчас, то напишите слово ЗАКОНЧИТЬ");
        System.out.println("Для вызова меню напишите МЕНЮ");
    }

    public static void makeWord(){
        System.out.println("Король загадал слово!");
        System.out.println("У вас есть 5 попыток! Удачи!");
    }

    private static String formWord(int x){
        if (x == 5) return "попыток";
        else if (x == 1) return "попытка";
        return "попытки";
    }

    public static void waitWordOrLetter(){
        System.out.println("Введите букву или слово:");
    }

    public static void incorrectSim(){
        System.out.println("Вы точно ввели букву русского алфавита? Попробуйте снова!");
    }

    public static void incorrectWord(){
        System.out.println("Вы ввели некорректное слово! Попробуйте снова!");
    }

    public static void userWon(String word){
        System.out.println("Вы угадали слово " + word.toUpperCase() +" и Король Байтландии помиловал вас!");
    }

    public static void endGame (){
        System.out.println("К сожалению, вы сдались и теперь болтаетесь на висилице!");
    }

    public static void nextOrFinish(){
        System.out.println("Хотите сыграть ещё раз? Если да, то введите ПРОДОЛЖИТЬ, иначе ЗАКОНЧИТЬ");
    }

    public static void hit(String sim, String starWord){
        System.out.println("Вы угадали букву " + sim.toUpperCase() + "!");
        System.out.println("Загаданное слово - " + starWord);
    }

    public static void simNotInWord(String starWord){
        System.out.println("К сожалению, этой буквы в слове нет и вы на шаг ближе к виселице!");
        System.out.println("Загаданное слово - " + starWord);
    }

    public static void countAttempt(int counterAttempt){
        System.out.println("У вас осталось всего лишь " + counterAttempt + " " + formWord(counterAttempt) + "!");
    }

    public static void notWord(String starWord){
        System.out.println("Увы, но это не то слово.");
        System.out.println("Загаданное слово - " + starWord);
    }

    public static void userLost(String word){
        System.out.println("К сожалению, вам не удалось избежать виселицы.");
        System.out.println("Загаданное слово - " + word.toUpperCase() + "!");
    }

    public static void bye(){
        System.out.println("До новых встреч в стредневековье!");
    }
}
