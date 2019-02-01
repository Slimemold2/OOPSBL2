package chess.piece;
import chess.*;
import java.io.Serializable;

//Basic class for the Chesspieces
public abstract class ChessPiece implements Serializable{
    ChessPieceType type;
    Color color;

    //constructor
    public ChessPiece(ChessPieceType type, Color color){
        this.type=type;
        this.color=color;
    }

    //getter functions
    public ChessPieceType getType(){return this.type;}

    public Color getColor(){return this.color;}

    //abstract! For each subclass different
    public abstract String toString();

    //Task description says: true "if they are identical"
    //not 100% clear whether two distinct white pawns would be equal or not;
    //Function to decide if two chesspieces are the same
    public boolean equals(Object obj){
        if(obj==this){
            return true;
        }
        else{return false;}
    }

    //returns an array of the possible destinations (fields to go) for the current chesspiece
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

    //abstract! different for every subclass;
    //tells whether the current ChessPiece can move to one certain field
    public abstract boolean canMove(Board board, int row, int col);
}