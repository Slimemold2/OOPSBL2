package chess.piece;
import chess.*;
//mainly only commented King as Code is quite similar for all subclasses...
//function "canMove" is commented for more subclasses

public class Queen extends ChessPiece{
    public Queen(Color color){
        super(ChessPieceType.QUEEN, color);
    }

    public String toString(){
        if(this.color==Color.WHITE){
            return "\u265b";
        }
        else{return "\u2655";}
    }

    //same code like in bishop and rook (combined)
    public boolean canMove(Board board, int row, int col){
        int[] pos=board.getPosition(this);
        int currentrow=pos[0];
        int currentcol=pos[1];

        //like Bishop
        if((currentrow-row==currentcol-col||currentrow-row==col-currentcol)&&!(currentrow-row==0&&currentcol-col==0)) {
            //down right
            if (currentcol - col < 0&&currentrow-row<0) {
                //check if path is free
                for (int i = 1; i <col-currentcol; i++) {
                    if (board.getBoard()[currentrow+i][currentcol+i] != null) {
                        return false;
                    }
                }
            }
            //up right
            else if (currentcol - col < 0&&row-currentrow<0){
                for (int i = 1; i <col-currentcol; i++) {
                    if (board.getBoard()[currentrow-i][currentcol+i] != null) {
                        return false;
                    }
                }
            }
            //down left
            else if (currentcol - col > 0&&row-currentrow>0){
                for (int i =  1; i <currentcol-col; i++) {
                    if (board.getBoard()[currentrow+i][currentcol-i] != null) {
                        return false;
                    }
                }
            }
            //up left
            else{
                for (int i =  1; i < currentcol-col; i++) {
                    if (board.getBoard()[currentrow-i][currentcol-i] != null) {
                        return false;
                    }
                }
            }
        }

        if((currentrow-row==currentcol-col||currentrow-row==col-currentcol)&&!(currentrow-row==0&&currentcol-col==0)){
            if(board.getBoard()[row][col]==null||board.getBoard()[row][col].getColor()!=this.getColor()) {
                return true;
            }
            else{return false;}
        }


        //like Rook
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