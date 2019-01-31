package chess.piece;
import chess.*;

public class Bishop extends ChessPiece{
    public Bishop(Color color){
        super(ChessPieceType.BISHOP, color);
    }

    public String toString(){
        if(this.color==Color.WHITE){
            return "\u265d";
        }
        else{return "\u2657";}
    }
    public boolean canMove(Board board, int row, int col){
        //Pfad frei überprüfen klappt noch nicht!
        int[] pos=board.getPosition(this);
        int currentrow=pos[0];
        int currentcol=pos[1];
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
        else{return false;}
    }
}