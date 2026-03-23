package XXLChess.movementBehaviour;

import java.util.ArrayList;

import java.util.List;

import XXLChess.App;
import XXLChess.chessPieces.Piece;

public class KnightKingMovement implements MovementStrategy {

    public List<Position> moveableWithBlock(App board, Piece piece) {
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

        Position knightMoveUp = new Position(-1 + piece.getX(), -2 + piece.getY());
        Position knightMoveUpleft = new Position(-2 + piece.getX(), -1 + piece.getY());
        Position knightMoveRight = new Position(-1 + piece.getX(), 2 + piece.getY());
        Position knightMoveDownRight = new Position(-2 + piece.getX(), 1 + piece.getY());
        Position knightMoveDown = new Position(1 + piece.getX(), 2 + piece.getY());
        Position knightMoveDownLeft = new Position(2 + piece.getX(), 1 + piece.getY());
        Position knightMoveLeft = new Position(2 + piece.getX(), -1 + piece.getY());
        Position knightMoveLeftUp = new Position(1 + piece.getX(), -2 + piece.getY());
        if (board.isPosOccupied(knightMoveUp, piece.isWhite()) == 0) {
            moveableLocation.add(knightMoveUp);

        }
        if (board.isPosOccupied(knightMoveUpleft, piece.isWhite()) == 0) {
            moveableLocation.add(knightMoveUpleft);

        }
        if (board.isPosOccupied(knightMoveRight, piece.isWhite()) == 0) {
            moveableLocation.add(knightMoveRight);
        }
        if (board.isPosOccupied(knightMoveDownRight, piece.isWhite()) == 0) {
            moveableLocation.add(knightMoveDownRight);
        }
        if (board.isPosOccupied(knightMoveDown, piece.isWhite()) == 0) {
            moveableLocation.add(knightMoveDown);
        }
        if (board.isPosOccupied(knightMoveDownLeft, piece.isWhite()) == 0) {
            moveableLocation.add(knightMoveDownLeft);
        }
        if (board.isPosOccupied(knightMoveLeft, piece.isWhite()) == 0) {
            moveableLocation.add(knightMoveLeft);
        }
        if (board.isPosOccupied(knightMoveLeftUp, piece.isWhite()) == 0) {
            moveableLocation.add(knightMoveLeftUp);

        }
        if (board.isPosOccupied(knightMoveUp, piece.isWhite()) == -1) {
            Position nextPos = new Position(-1 + piece.getX(), -2 + piece.getY(), true);
            moveableLocation.add(nextPos);

        }
        if (board.isPosOccupied(knightMoveUpleft, piece.isWhite()) == -1) {
            Position nextPos = new Position(-2 + piece.getX(), -1 + piece.getY(), true);
            moveableLocation.add(nextPos);

        }
        if (board.isPosOccupied(knightMoveRight, piece.isWhite()) == -1) {
            Position nextPos = new Position(-1 + piece.getX(), 2 + piece.getY(), true);
            moveableLocation.add(nextPos);

        }
        if (board.isPosOccupied(knightMoveDownRight, piece.isWhite()) == -1) {
            Position nextPos = new Position(-2 + piece.getX(), 1 + piece.getY(), true);
            moveableLocation.add(nextPos);

        }
        if (board.isPosOccupied(knightMoveDown, piece.isWhite()) == -1) {
            Position nextPos = new Position(1 + piece.getX(), 2 + piece.getY(), true);
            moveableLocation.add(nextPos);

        }
        if (board.isPosOccupied(knightMoveDownLeft, piece.isWhite()) == -1) {
            Position nextPos = new Position(2 + piece.getX(), 1 + piece.getY(), true);
            moveableLocation.add(nextPos);

        }
        if (board.isPosOccupied(knightMoveLeft, piece.isWhite()) == -1) {
            Position nextPos = new Position(2 + piece.getX(), -1 + piece.getY(), true);
            moveableLocation.add(nextPos);

        }
        if (board.isPosOccupied(knightMoveLeftUp, piece.isWhite()) == -1) {
            Position nextPos = new Position(1 + piece.getX(), -2 + piece.getY(), true);
            moveableLocation.add(nextPos);

        }

        return moveableLocation;
    }

}
