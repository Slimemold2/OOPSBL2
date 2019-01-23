package chess.piece;
import chess.*;
public abstract class ChessPiece{
    ChessPieceType type;
    Color color;

    public ChessPiece(ChessPieceType type, Color color){
        this.type=type;
        this.color=color;
    }

    public ChessPieceType getType(){return this.type;}

    public Color getColor(){return this.color;}

    public abstract String toString();

    //"wenn sie identisch sind"
    //color==color und type==type ausreichend oder nur wenn wirklich die selbe Figur?
    //(es gibt mehrere weiße Bauern in einem Spiel...)
    //evtl. fragen oder Code für beides in Kommentar
    public boolean equals(Object obj){
        if(obj==this){
            return true;
        }
        else{return false;}
    }

    public boolean[][] getPossibleDestinations(Board board){return null;}

    //optionale Hilfsmethode
    public boolean canMove(Board board, int row, int col){return true;}
}