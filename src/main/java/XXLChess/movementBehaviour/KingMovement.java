package XXLChess.movementBehaviour;

import java.util.ArrayList;

import java.util.List;

import XXLChess.App;
import XXLChess.chessPieces.Piece;

public class KingMovement implements MovementStrategy {

    public List<Position> moveableWithBlock(App board, Piece piece) {
        List<Position> moveableLocation = movable(board, piece);
        List<Position> notSafe = new ArrayList<Position>();
        moveableLocation.forEach(pos -> {
            if (!board.checkPosIsSafe(pos, piece.isWhite()))
                notSafe.add(pos);
        });
        moveableLocation.removeAll(notSafe);
        return moveableLocation;
    }

    public List<Position> movable(App board, Piece piece) {
        Position kingMoveUp = new Position(-1 + piece.getX(), 0 + piece.getY());
        Position kingMoveUpRight = new Position(-1 + piece.getX(), 1 + piece.getY());
        Position kingMoveRight = new Position(0 + piece.getX(), 1 + piece.getY());
        Position kingMoveDownRight = new Position(1 + piece.getX(), 1 + piece.getY());
        Position kingMoveDown = new Position(1 + piece.getX(), 0 + piece.getY());
        Position kingMoveDownLeft = new Position(1 + piece.getX(), -1 + piece.getY());
        Position kingMoveLeft = new Position(0 + piece.getX(), -1 + piece.getY());
        Position kingMoveLeftUp = new Position(-1 + piece.getX(), -1 + piece.getY());

        List<Position> moveableLocation = new ArrayList<Position>();

        if (board.isPosOccupied(kingMoveUp, piece.isWhite()) == -1) {
            Position nextPos = new Position(-1 + piece.getX(), 0 + piece.getY(), true);
            moveableLocation.add(nextPos);

        }
        if (board.isPosOccupied(kingMoveUpRight, piece.isWhite()) == -1) {
            Position nextPos = new Position(-1 + piece.getX(), 1 + piece.getY(), true);
            moveableLocation.add(nextPos);

        }
        if (board.isPosOccupied(kingMoveRight, piece.isWhite()) == -1) {
            Position nextPos = new Position(0 + piece.getX(), 1 + piece.getY(), true);
            moveableLocation.add(nextPos);
        }
        if (board.isPosOccupied(kingMoveDownRight, piece.isWhite()) == -1) {
            Position nextPos = new Position(1 + piece.getX(), 1 + piece.getY(), true);
            moveableLocation.add(nextPos);
        }
        if (board.isPosOccupied(kingMoveDown, piece.isWhite()) == -1) {
            Position nextPos = new Position(1 + piece.getX(), 0 + piece.getY(), true);
            moveableLocation.add(nextPos);
        }
        if (board.isPosOccupied(kingMoveDownLeft, piece.isWhite()) == -1) {
            Position nextPos = new Position(1 + piece.getX(), -1 + piece.getY(), true);
            moveableLocation.add(nextPos);
        }
        if (board.isPosOccupied(kingMoveLeft, piece.isWhite()) == -1) {
            Position nextPos = new Position(0 + piece.getX(), -1 + piece.getY(), true);
            moveableLocation.add(nextPos);
        }
        if (board.isPosOccupied(kingMoveLeftUp, piece.isWhite()) == -1) {
            Position nextPos = new Position(-1 + piece.getX(), -1 + piece.getY(), true);
            moveableLocation.add(nextPos);

        }
        if (board.isPosOccupied(kingMoveUp, piece.isWhite()) == 0) {
            moveableLocation.add(kingMoveUp);

        }
        if (board.isPosOccupied(kingMoveUpRight, piece.isWhite()) == 0) {
            moveableLocation.add(kingMoveUpRight);

        }
        if (board.isPosOccupied(kingMoveRight, piece.isWhite()) == 0) {
            moveableLocation.add(kingMoveRight);
        }
        if (board.isPosOccupied(kingMoveDownRight, piece.isWhite()) == 0) {
            moveableLocation.add(kingMoveDownRight);
        }
        if (board.isPosOccupied(kingMoveDown, piece.isWhite()) == 0) {
            moveableLocation.add(kingMoveDown);
        }
        if (board.isPosOccupied(kingMoveDownLeft, piece.isWhite()) == 0) {
            moveableLocation.add(kingMoveDownLeft);
        }
        if (board.isPosOccupied(kingMoveLeft, piece.isWhite()) == 0) {
            moveableLocation.add(kingMoveLeft);
        }
        if (board.isPosOccupied(kingMoveLeftUp, piece.isWhite()) == 0) {
            moveableLocation.add(kingMoveLeftUp);
        }

        return moveableLocation;
    }
}
