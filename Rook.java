package chess.piece;
import chess.*;

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
        //Reihe entlang ->
        if(currentrow-row==0 && currentcol-col!=0) {
            //nach rechts
            if (currentcol - col < 0) {
                //checke ob Pfad frei
                for (int i = currentcol + 1; i < col; i++) {
                    if (board.getBoard()[currentrow][i] != null) {
                        return false;
                    }
                }
            }
            //nach links
            else {
                //checke ob Pfad frei
                for (int i = currentcol - 1; i >= col; i--) {
                    if (board.getBoard()[currentrow][i] != null) {
                        return false;
                    }
                }
            }
        }
        //Spalte entlang v
        else if(currentcol-col==0 && currentrow-row!=0) {
            //nach unten
            if (currentrow - row < 0) {
                //checke ob Pfad frei
                for (int i = currentrow + 1; i < row; i++) {
                    if (board.getBoard()[i][currentcol] != null) {
                        return false;
                    }
                }
            }
            //nach oben
            else {
                //checke ob Pfad frei
                for (int i = currentrow - 1; i >= row; i--) {
                    if (board.getBoard()[i][currentcol] != null) {
                        return false;
                    }
                }
            }
        }
        if((currentcol-col==0 || currentrow-row==0)&&!(currentcol-col==0 && currentrow-row==0)){
            //fuer jede Art verwendbar
            if(board.getBoard()[row][col]==null||board.getBoard()[row][col].getColor()!=this.getColor()){
                return true;
            }
            else{return false;}
        }
        else{return false;}
    }
}