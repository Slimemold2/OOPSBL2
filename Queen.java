package chess.piece;

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
}