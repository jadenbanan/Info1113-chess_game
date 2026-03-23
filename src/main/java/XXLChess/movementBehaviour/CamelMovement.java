package XXLChess.movementBehaviour;

import java.util.ArrayList;
import java.util.List;

import XXLChess.App;
import XXLChess.chessPieces.Piece;

public class CamelMovement implements MovementStrategy {

    @Override
    public List<Position> moveableWithBlock(App board, Piece piece) {
        Position camelMoveUpLeft = new Position(-1 + piece.getX(), -3 + piece.getY());
        Position camelMoveUpRight = new Position(1 + piece.getX(), -3 + piece.getY());
        Position camelMoveRightUp = new Position(3 + piece.getX(), -1 + piece.getY());
        Position camelMoveRightDown = new Position(3 + piece.getX(), 1 + piece.getY());
        Position camelMoveDownRight = new Position(1 + piece.getX(), 3 + piece.getY());
        Position camelMoveDownLeft = new Position(-1 + piece.getX(), 3 + piece.getY());
        Position camelMoveLeftDown = new Position(-3 + piece.getX(), 1 + piece.getY());
        Position camelMoveLeftUp = new Position(-3 + piece.getX(), -1 + piece.getY());

        List<Position> moveableLocation = new ArrayList<Position>();
        if (board.isPosOccupied(camelMoveUpLeft, piece.isWhite()) == 0) {
            moveableLocation.add(camelMoveUpLeft);

        }
        if (board.isPosOccupied(camelMoveUpRight, piece.isWhite()) == 0) {
            moveableLocation.add(camelMoveUpRight);

        }
        if (board.isPosOccupied(camelMoveRightUp, piece.isWhite()) == 0) {
            moveableLocation.add(camelMoveRightUp);
        }
        if (board.isPosOccupied(camelMoveRightDown, piece.isWhite()) == 0) {
            moveableLocation.add(camelMoveDownRight);
        }
        if (board.isPosOccupied(camelMoveDownRight, piece.isWhite()) == 0) {
            moveableLocation.add(camelMoveDownRight);
        }
        if (board.isPosOccupied(camelMoveDownLeft, piece.isWhite()) == 0) {
            moveableLocation.add(camelMoveDownLeft);
        }
        if (board.isPosOccupied(camelMoveLeftDown, piece.isWhite()) == 0) {
            moveableLocation.add(camelMoveLeftDown);
        }
        if (board.isPosOccupied(camelMoveLeftUp, piece.isWhite()) == 0) {
            moveableLocation.add(camelMoveLeftUp);

        }
        if (board.isPosOccupied(camelMoveUpLeft, piece.isWhite()) == -1) {
            Position nextPos = new Position(-1 + piece.getX(), -3 + piece.getY(), true);
            moveableLocation.add(nextPos);

        }
        if (board.isPosOccupied(camelMoveUpRight, piece.isWhite()) == -1) {
            Position nextPos = new Position(1 + piece.getX(), -3 + piece.getY(), true);
            moveableLocation.add(nextPos);

        }
        if (board.isPosOccupied(camelMoveRightUp, piece.isWhite()) == -1) {
            Position nextPos = new Position(3 + piece.getX(), -1 + piece.getY(), true);
            moveableLocation.add(nextPos);

        }
        if (board.isPosOccupied(camelMoveRightDown, piece.isWhite()) == -1) {
            Position nextPos = new Position(3 + piece.getX(), 1 + piece.getY(), true);
            moveableLocation.add(nextPos);

        }
        if (board.isPosOccupied(camelMoveDownRight, piece.isWhite()) == -1) {
            Position nextPos = new Position(1 + piece.getX(), 3 + piece.getY(), true);
            moveableLocation.add(nextPos);

        }
        if (board.isPosOccupied(camelMoveDownLeft, piece.isWhite()) == -1) {
            Position nextPos = new Position(-1 + piece.getX(), 3 + piece.getY(), true);
            moveableLocation.add(nextPos);

        }
        if (board.isPosOccupied(camelMoveLeftDown, piece.isWhite()) == -1) {
            Position nextPos = new Position(-3 + piece.getX(), 1 + piece.getY(), true);
            moveableLocation.add(nextPos);

        }
        if (board.isPosOccupied(camelMoveLeftUp, piece.isWhite()) == -1) {
            Position nextPos = new Position(-3 + piece.getX(), -1 + piece.getY(), true);
            moveableLocation.add(nextPos);

        }

        return moveableLocation;
    }

}
