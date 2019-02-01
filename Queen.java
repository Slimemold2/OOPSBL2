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
            if (currentcol - col < 0&&row-currentrow<0) {
                for (int i = 1; i <= col-currentcol; i++) {
                    if (board.getBoard()[currentcol+i][currentcol+i] != null) {
                        return false;
                    }
                }
            }
            else if (currentcol - col < 0&&row-currentrow<0){
                for (int i = 1; i <=col-currentcol; i++) {
                    if (board.getBoard()[currentcol+i][currentcol-i] != null) {
                        return false;
                    }
                }
            }
            else if (currentcol - col > 0&&row-currentrow<0){
                for (int i =  1; i <= currentcol-col; i++) {
                    if (board.getBoard()[currentcol-i][currentcol+i] != null) {
                        return false;
                    }
                }
            }
            else{
                for (int i =  1; i <= currentcol-col; i++) {
                    if (board.getBoard()[currentcol-i][currentcol-i] != null) {
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
        if(currentrow-row==0 && currentcol-col!=0) {
            if (currentcol - col < 0) {
                for (int i = currentcol + 1; i < col; i++) {
                    if (board.getBoard()[currentrow][i] != null) {
                        return false;
                    }
                }
            }
            else {
                for (int i = currentcol - 1; i > col; i--) {
                    if (board.getBoard()[currentrow][i] != null) {
                        return false;
                    }
                }
            }
        }
        else if(currentcol-col==0 && currentrow-row!=0) {
            if (currentrow - row < 0) {
                for (int i = currentrow + 1; i < row; i++) {
                    if (board.getBoard()[i][currentcol] != null) {
                        return false;
                    }
                }
            }
            else {
                for (int i = currentrow - 1; i > row; i--) {
                    if (board.getBoard()[i][currentcol] != null) {
                        return false;
                    }
                }
            }
        }
        if((currentcol-col==0 || currentrow-row==0)&&!(currentcol-col==0 && currentrow-row==0)){
            if(board.getBoard()[row][col]==null||board.getBoard()[row][col].getColor()!=this.getColor()){
                return true;
            }
            else{return false;}
        }
        else{return false;}
    }
}