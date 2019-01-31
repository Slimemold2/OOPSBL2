package chess.piece;
import chess.*;
import java.io.Serializable;

public abstract class ChessPiece implements Serializable{
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

    public boolean[][] getPossibleDestinations(Board board){
        boolean[][] array=new boolean[8][8];
        for(int i=0;i<8;i++) {
            for (int j = 0; j < 8; j++) {
                if(canMove(board,i,j)){
                    array[i][j]=true;
                }
                else{array[i][j]=false;}
            }
        }
        canMove(board,0,1);
        return array;
    }

    //optionale Hilfsmethode
    public abstract boolean canMove(Board board, int row, int col);
}