package chess.piece;
import chess.*;
//mainly only commented King as Code is quite similar for all subclasses...
//function "canMove" is commented for more subclasses

public class Rook extends ChessPiece{
    public Rook(Color color){
        super(ChessPieceType.ROOK, color);
    }

    public String toString(){
        if(this.color==Color.WHITE){
            return "\u265c";
        }
        else{return "\u2656";}
    }
    public boolean canMove(Board board, int row, int col){
        int[] pos=board.getPosition(this);
        int currentrow=pos[0];
        int currentcol=pos[1];
        //row <->
        if(currentrow-row==0 && currentcol-col!=0) {
            //to the right ->
            if (currentcol - col < 0) {
                //check whether path is free
                for (int i = currentcol + 1; i < col; i++) {
                    if (board.getBoard()[currentrow][i] != null) {
                        return false;
                    }
                }
            }
            //to the left <-
            else {
                for (int i = currentcol - 1; i > col; i--) {
                    if (board.getBoard()[currentrow][i] != null) {
                        return false;
                    }
                }
            }
        }
        //column
        else if(currentcol-col==0 && currentrow-row!=0) {
            //down v
            if (currentrow - row < 0) {
                for (int i = currentrow + 1; i < row; i++) {
                    if (board.getBoard()[i][currentcol] != null) {
                        return false;
                    }
                }
            }
            //up ^
            else {
                for (int i = currentrow - 1; i > row; i--) {
                    if (board.getBoard()[i][currentcol] != null) {
                        return false;
                    }
                }
            }
        }
        //check whether field is in range
        if((currentcol-col==0 || currentrow-row==0)&&!(currentcol-col==0 && currentrow-row==0)){
            //same for every class
            if(board.getBoard()[row][col]==null||board.getBoard()[row][col].getColor()!=this.getColor()){
                return true;
            }
            else{return false;}
        }
        else{return false;}
    }
}