package XXLChess.movementBehaviour;

import java.util.ArrayList;
import java.util.List;

import XXLChess.App;
import XXLChess.chessPieces.Piece;

public class QueenMovement implements MovementStrategy {
    List<Piece> pieces = XXLChess.App.getPieces();

    @Override
    public List<Position> moveableWithBlock(App board, Piece piece) {
        List<Position> moveableLocation = new ArrayList<Position>();

        for (int i = 1; i < 48; i++) {
            Position nextPos = new Position(piece.getX() + i, piece.getY());
            if (board.isPosOccupied(nextPos, piece.isWhite()) == 1) {
                break;
            } else if (board.isPosOccupied(nextPos, piece.isWhite()) == -1) {
                nextPos = new Position(piece.getX() + i, piece.getY(), true);
                moveableLocation.add(nextPos);
                break;
            }
            moveableLocation.add(nextPos);
        }
        for (int i = 1; i < 48; i++) {
            Position nextPos = new Position(piece.getX() - i, piece.getY());
            if (board.isPosOccupied(nextPos, piece.isWhite()) == 1) {
                break;
            } else if (board.isPosOccupied(nextPos, piece.isWhite()) == -1) {
                nextPos = new Position(piece.getX() - i, piece.getY(), true);
                moveableLocation.add(nextPos);
                break;
            }
            moveableLocation.add(nextPos);
        }
        for (int i = 1; i < 48; i++) {
            Position nextPos = new Position(piece.getX(), piece.getY() + i);
            if (board.isPosOccupied(nextPos, piece.isWhite()) == 1) {
                break;
            } else if (board.isPosOccupied(nextPos, piece.isWhite()) == -1) {
                nextPos = new Position(piece.getX(), piece.getY() + i, true);
                moveableLocation.add(nextPos);
                break;
            }

            moveableLocation.add(nextPos);
        }
        for (int i = 1; i < 48; i++) {
            Position nextPos = new Position(piece.getX(), piece.getY() - i);
            if (board.isPosOccupied(nextPos, piece.isWhite()) == 1) {
                break;
            } else if (board.isPosOccupied(nextPos, piece.isWhite()) == -1) {
                nextPos = new Position(piece.getX(), piece.getY() - i, true);
                moveableLocation.add(nextPos);
                break;
            }
            moveableLocation.add(nextPos);
        }

        return moveableLocation;
    }

}
