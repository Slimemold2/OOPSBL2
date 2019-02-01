package chess.piece;
import chess.*;
//mainly only commented King as Code is quite similar for all subclasses...
//function "canMove" is commented for more subclasses

public class Pawn extends ChessPiece{
    public Pawn(Color color){
        super(ChessPieceType.PAWN, color);
    }

    public String toString(){
        if(this.color==Color.WHITE){
            return "\u265f";
        }
        else{return "\u2659";}
    }
    public boolean canMove(Board board, int row, int col) {
        int[] pos = board.getPosition(this);
        int currentrow = pos[0];
        int currentcol = pos[1];
        //if it is the first turn adjust the range
        int range=1;
        if (this.getColor() == Color.WHITE) {
            //Check if still at starting position; if so, adjust range
            if(currentrow==6){
                range=2;
            }
            if ((currentrow - row == 1) && (currentcol - col == 0)||(currentrow - row == range) && (currentcol - col == 0)) {
                if (board.getBoard()[row][col] == null) {
                    return true;
                } else {
                    return false;
                }
            } else if ((currentrow - row == 1) && ((currentcol - col == 1) || (col - currentcol == 1)) && board.getBoard()[row][col] != null) {
                if (board.getBoard()[row][col].getColor() != this.getColor()) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else if (this.getColor() == Color.BLACK) {
            //Check if still at starting position; if so, adjust range
            if(currentrow==1){
                range=2;
            }
            if ((currentrow - row == -1) && (currentcol - col == 0)||(currentrow - row == -range) && (currentcol - col == 0)) {
                if (board.getBoard()[row][col] == null) {
                    return true;
                } else {
                    return false;
                }
            } else if ((currentrow - row == -1) && ((currentcol - col == 1) || (col - currentcol == 1))) {
                if (board.getBoard()[row][col] == null) {
                    return true;
                } else if (board.getBoard()[row][col].getColor() != this.getColor()) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        else{return false;}
    }
}