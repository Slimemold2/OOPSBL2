package chess.piece;
import chess.*;

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
        if (this.getColor() == Color.WHITE) {
            if ((currentrow - row == 1) && (currentcol - col == 0)) {
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
            if ((currentrow - row == -1) && (currentcol - col == 0)) {
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