package edu.hw1;

public class ChessHorse {

    private class AttackedKnight extends Exception {}
    private int[][] table;

    ChessHorse(int[][] chessTable){
        this.table = chessTable;
    }
    private void attack(int i, int j) throws AttackedKnight {
        if (i < 0 || i > 7 || j <0 || j > 7)
            return;
        if (table[i][j] == 1)
            throw new AttackedKnight();
    }
    public  boolean knightBoardCapture(){
        for (int row = 0; row < 8; row += 1)
            for (int col = 0; col < 8; col += 1)
                if (table[row][col] == 1){
                    try{
                        attack(col - 2, row - 1);
                        attack(col - 2, row + 1);
                        attack(col - 1, row - 2);
                        attack(col - 1, row + 2);
                        attack(col + 2, row - 1);
                        attack(col + 2, row + 1);
                        attack(col + 1, row - 2);
                        attack(col + 1, row + 2);
                    }catch (AttackedKnight e){
                        return false;
                    }
                }

        return true;
    }
}
