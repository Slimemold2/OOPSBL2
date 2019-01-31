package chess.piece;
import chess.*;

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
    public boolean canMove(Board board, int row, int col){
        //Wie König
        int[] pos=board.getPosition(this);
        int currentrow=pos[0];
        int currentcol=pos[1];
        if(((currentrow-row<=1 && -1<=currentrow-row)||(row-currentrow<=1 && -1<=row-currentrow))&&((currentcol-col<=1 && -1<=currentcol-col)||(col-currentcol<=1 && -1<=col-currentcol))&&!(currentrow-row==0&&currentcol-col==0)){
            //fuer jede Art verwendbar
            if(board.getBoard()[row][col]==null||board.getBoard()[row][col].getColor()!=this.getColor()){
                return true;
            }
            else{return false;}
        }
        //Diagonal
        if((currentrow-row==currentcol-col||currentrow-row==col-currentcol)&&!(currentrow-row==0&&currentcol-col==0)) {
            //nach rechts unten
            if (currentcol - col < 0&&row-currentrow<0) {
                //checke ob Pfad frei
                for (int i = 1; i <= col-currentcol; i++) {
                    if (board.getBoard()[currentcol+i][currentcol+i] != null) {
                        return false;
                    }
                }
            }
            //nach rechts oben
            else if (currentcol - col < 0&&row-currentrow<0){
                //checke ob Pfad frei
                for (int i = 1; i <=col-currentcol; i++) {
                    if (board.getBoard()[currentcol+i][currentcol-i] != null) {
                        return false;
                    }
                }
            }
            //nach links unten
            else if (currentcol - col > 0&&row-currentrow<0){
                //checke ob Pfad frei
                for (int i =  1; i <= currentcol-col; i++) {
                    if (board.getBoard()[currentcol-i][currentcol+i] != null) {
                        return false;
                    }
                }
            }
            //nach links oben
            else{
                //checke ob Pfad frei
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
        //Wie Turm

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