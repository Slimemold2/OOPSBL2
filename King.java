package chess.piece;
import chess.*;

public class King extends ChessPiece{
    public King(Color color){
        super(ChessPieceType.KING, color);
    }

    public String toString(){
        if(this.color==Color.WHITE){
            return "\u265a";
        }
        else{return "\u2654";}
    }

    public boolean canMove(Board board, int row, int col){
        //checke nur fuer genau ein Feld;
        //braucht momentane Position; board.getPosition(this);
        //Checke ob Feld im Bereich
        //Checke ob leer/feindliche Farbe
        int[] pos=board.getPosition(this);
        int currentrow=pos[0];
        int currentcol=pos[1];
        //Spezifisch für König
        //eins ist immer kleiner 1 weil kleiner 0... -1<=cc-c<=1 oder so
        if(((currentrow-row<=1 && -1<=currentrow-row)||(row-currentrow<=1 && -1<=row-currentrow))&&((currentcol-col<=1 && -1<=currentcol-col)||(col-currentcol<=1 && -1<=col-currentcol))&&!(currentrow-row==0&&currentcol-col==0)){
            //fuer jede Art verwendbar
            if(board.getBoard()[row][col]==null||board.getBoard()[row][col].getColor()!=this.getColor()){
                return true;
            }
            else{return false;}
        }
        else{return false;}
    }
}