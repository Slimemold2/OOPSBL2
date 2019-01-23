package chess.piece;

public class Pawn extends ChessPiece{
    public Pawn(Color color){
        super(ChessPieceType.PAWN, color);
    }

    public String toString(){
        if(this.color==Color.WHITE){
            return "\u265f";
        }
        else{return "\u2659";}
    }
}