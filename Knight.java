package chess.piece;

public class Knight extends ChessPiece{
    public Knight(Color color){
        super(ChessPieceType.KNIGHT, color);
    }

    public String toString(){
        if(this.color==Color.WHITE){
            return "\u265e";
        }
        else{return "\u2658";}
    }
}