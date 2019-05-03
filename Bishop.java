/**
 * Chess piece Bishop. Can only move diagonally.
 * author: Stefan Heng
 */

import javafx.scene.image.Image;

public class Bishop extends Piece {

    public Bishop(Color color) {
        super(color);

        img = color == Color.WHITE ? new Image("assets/pieces/bishop_white.png") :
                new Image("assets/pieces/bishop_black.png");
    }

    /**
     * Movement logic of Bishop.
     * @param t the tile to be moved to
     * @param b the board containing this piece
     * @return true if this Bishop can move to t, false if it cannot move to t
     */
    @Override
    public boolean move(Tile t, Board b) {
        boolean flag = true;

        //sets flag to false if t and current tile are the same tile
        if(getTile() == t) {
            flag = false;
        }

        //checks if t is the same color as the already existing piece
        if(t.hasPiece() && t.getPiece().getColor() == getColor()) {
            flag = false;
        }

        if(flag) {
            Location currentLoc = getTile().getLoc();
            Location tLoc = t.getLoc();

            Tile[][] currentBoard = b.getBoard();

            int x = currentLoc.getX();
            int y = currentLoc.getY();
            int tX = tLoc.getX();
            int tY = tLoc.getY();

            if(Math.abs(tX - x) == Math.abs(tY - y)) {
                // move northeast
                if(x < tX && y < tY) {
                    for(int i = x + 1, j = (y + 1); i < tX && j < tY; i++, j++) {
                        Tile temp = currentBoard[i][j];
                        flag = temp.hasPiece();
                        if(flag) {
                            break;
                        }
                    }
                }
                // move southeast
                else if(x < tX && y > tY) {
                    for(int i = x + 1, j = (y - 1); i < tX && j > tY; i++, j--) {
                        Tile temp = currentBoard[i][j];
                        flag = temp.hasPiece();
                        if(flag) {
                            break;
                        }
                    }
                }
                // move northwest
                else if(x > tX && y < tY) {
                    for(int i = x - 1, j = (y + 1); i > tX && j < tY; i--, j++) {
                        Tile temp = currentBoard[i][j];
                        flag = temp.hasPiece();
                        if(flag) {
                            break;
                        }
                    }
                }
                // move southwest
                else if(x > tX && y > tY) {
                    for(int i = x - 1, j = (y - 1); i > tX && j > tY; i--, j--) {
                        Tile temp = currentBoard[i][j];
                        flag = temp.hasPiece();
                        if(flag) {
                            break;
                        }
                    }
                }
            }
            else {
                flag = false;
            }
        }
        return flag;
    }

    /**
     * Obtains all the legal moves of this Bishop in a game of Chess.
     * @return an array of legal moves that this Bishop can perform.
     */
    public Moveset[] getLegalMoves() {
        Moveset[] m = {Moveset.NORTHEAST, Moveset.NORTHWEST, Moveset.SOUTHWEST, Moveset.SOUTHEAST};
        return m;
    }
}
