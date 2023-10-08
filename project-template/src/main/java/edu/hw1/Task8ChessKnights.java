package edu.hw1;

public class Task8ChessKnights {

    public static boolean isKnightBoardCapture(int[][] board){
        //ALSO RETURN FALSE IF THE DATA IS INCORRECT
        if(board.length != 8) return false;

        for(int i = 0; i < 8; i++){
            if(board[i].length != 8) return false;

            for (int j = 0; j < 8; j++){
                if(board[i][j] == 0) continue;
                if(board[i][j] != 1) return false;

                //VERTICALS FIRST
                //up-left
                if(i <= 5 && j != 0) if(board[i+2][j-1] == 1) return false;
                //up-right
                if(i <= 5 && j != 7) if(board[i+2][j+1] == 1) return false;
                //down-left
                if(i >= 2 && j != 0) if(board[i-2][j-1] == 1) return false;
                //down-right
                if(i >= 2 && j != 7) if(board[i-2][j+1] == 1) return false;

                //HORIZONTAL FIRST
                //left-up
                if(i != 7 && j >= 2) if(board[i+1][j-2] == 1) return false;
                //left-down
                if(i != 0 && j >= 2) if(board[i-1][j-2] == 1) return false;
                //right-up
                if(i != 7 && j <= 5) if(board[i+1][j+2] == 1) return false;
                //right-down
                if(i != 0 && j <= 5) if(board[i-1][j+2] == 1) return false;
            }
        }
        return true;
    }
}
