import java.util.ArrayList;

public class King extends Piece {

    public King(Color color) {
        super(color);
    }

    @Override
    public boolean move(Tile t, Board b) {
        return false;
    }

    @Override
    public ArrayList<Tile> getLegalMoves(Board b) {
        return null;
    }
}
