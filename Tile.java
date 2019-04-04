public class Tile {

    private Location loc;
    private Piece piece;
    private String name;

    public Tile(Location loc, String name) {
        this.loc = loc;
        this.name = name;
        piece = null;
    }

    /**
     * @return True if a piece exists on the tile. False if no piece exists on the tile.
     */
    public Boolean hasPiece() {
        return piece != null;
    }

    /**
     * @param piece
     */
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    public Location getLoc() {
        return loc;
    }
    /**
     * Removes a piece from the Tile.
     */
    public Piece removePiece() {
        Piece p = piece;
        piece = null;
        return p;
    }

}
