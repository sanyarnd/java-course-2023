package edu.hw1;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public final class Main {

    private Main() {
    }

    public static void main(String[] args) {
        Task0.helloInConsole();
        Task1.minutesToSeconds("10:60");
        Task2.countDigits(544);
        Task3.isNestable(new int[]{1, 2, 3, 4}, new int[]{2, 3});
        Task4.fixString("badce");
        Task5.isPalindromeDescendant(11211230);
        Task6.countK(3524);
        Task7.rotateLeft(17, 2);
        Task7.rotateRight(8, 1);
        Task8.knightBoardCapture(new int[][]{
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0}});

    }
}
