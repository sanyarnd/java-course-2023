import static org.junit.jupiter.api.Assertions.*;

class HelloWorldTest {

    @org.junit.jupiter.api.Test
    void minutesToSeconds() {
        assert (HelloWorld.minutesToSeconds("01:00") == 60);
        assert (HelloWorld.minutesToSeconds("13:56") == 836);
        assert (HelloWorld.minutesToSeconds("10:60") == -1);
    }

    @org.junit.jupiter.api.Test
    void countDigits() {
        assert (HelloWorld.countDigits(4666)== 4);
        assert (HelloWorld.countDigits(544)== 3);
        assert (HelloWorld.countDigits(0)== 1);


    }

    @org.junit.jupiter.api.Test
    void isNestable() {
        int[] a = { 1,2,3,4};
        int[] b = {0,6};
        int[] a2 = { 3, 1};
        int[] b2 = {4, 0};
        int[] a3= { 9, 9, 8};
        int[] b3 = {8, 9};
        int[] a4= { 1, 2, 3, 4};
        int[] b4 = {2, 3};
        /*isNestable([3, 1], [4, 0]) -> true
isNestable([9, 9, 8], [8, 9]) -> false
isNestable([1, 2, 3, 4], [2, 3]) -> false */
        assert HelloWorld.isNestable(a,b);
        assert HelloWorld.isNestable(a2,b2);
        assert !HelloWorld.isNestable(a3,b3) ;
        assert !HelloWorld.isNestable(a4,b4) ;
    }

    @org.junit.jupiter.api.Test
    void fixString() {
        assert HelloWorld.fixString("badce").equals("abcde");
        assert HelloWorld.fixString("123456").equals("214365");
        assert HelloWorld.fixString("hTsii  s aimex dpus rtni.g").equals("This is a mixed up string.");
    }

    @org.junit.jupiter.api.Test
    void isPalindromeDescendant() {
        assert HelloWorld.isPalindromeDescendant(11211230);
        assert HelloWorld.isPalindromeDescendant(13001120);
        assert HelloWorld.isPalindromeDescendant(23336014);
    }

    @org.junit.jupiter.api.Test
    void countK() {
        assert HelloWorld.countK(6621) == 5;
        assert HelloWorld.countK(6554) == 4;
        assert HelloWorld.countK(1234) == 3;
    }

    @org.junit.jupiter.api.Test
    void rotateLeft() {
        assert HelloWorld.rotateLeft(16,1) == 1;
        assert HelloWorld.rotateLeft(17,2) == 6;
    }

    @org.junit.jupiter.api.Test
    void rotateRight() {
        assert HelloWorld.rotateRight(8,1) == 4;

    }

    @org.junit.jupiter.api.Test
    void knightBoardCapture() {
        int[][] chess = {
                {0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0}};
        int[][] chess2 = {
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 1, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 1}
        };
        int[][] chess3 = {
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };
        assert HelloWorld.knightBoardCapture(chess);
        assert !HelloWorld.knightBoardCapture(chess2);
        assert !HelloWorld.knightBoardCapture(chess3);
    }

    @org.junit.jupiter.api.Test
    void main() {
    }
}