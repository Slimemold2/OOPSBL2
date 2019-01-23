package chess.piece;

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
}