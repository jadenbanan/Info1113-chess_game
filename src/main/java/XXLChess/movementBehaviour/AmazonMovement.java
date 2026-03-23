package XXLChess.movementBehaviour;

import java.util.ArrayList;
import java.util.List;

import XXLChess.App;
import XXLChess.chessPieces.Piece;

public class AmazonMovement implements MovementStrategy {

    @Override
    public List<Position> moveableWithBlock(App board, Piece piece) {
        List<Position> moveableLocation = new ArrayList<Position>();

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

        for (int i = 1; i < 48; i++) {
            Position nextPos = new Position(piece.getX() + i, piece.getY() + i);
            if (board.isPosOccupied(nextPos, piece.isWhite()) == 1) {
                break;
            } else if (board.isPosOccupied(nextPos, piece.isWhite()) == -1) {
                nextPos = new Position(piece.getX() + i, piece.getY() + i, true);
                moveableLocation.add(nextPos);
                break;
            }
            moveableLocation.add(nextPos);
        }
        for (int i = 1; i < 48; i++) {
            Position nextPos = new Position(piece.getX() - i, piece.getY() - i);
            if (board.isPosOccupied(nextPos, piece.isWhite()) == 1) {
                break;
            } else if (board.isPosOccupied(nextPos, piece.isWhite()) == -1) {
                nextPos = new Position(piece.getX() - i, piece.getY() - i, true);
                moveableLocation.add(nextPos);
                break;
            }
            moveableLocation.add(nextPos);
        }
        for (int i = 1; i < 48; i++) {
            Position nextPos = new Position(piece.getX() - i, piece.getY() + i);
            if (board.isPosOccupied(nextPos, piece.isWhite()) == 1) {
                break;
            } else if (board.isPosOccupied(nextPos, piece.isWhite()) == -1) {
                nextPos = new Position(piece.getX() - i, piece.getY() + i, true);
                moveableLocation.add(nextPos);
                break;
            }

            moveableLocation.add(nextPos);
        }
        for (int i = 1; i < 48; i++) {
            Position nextPos = new Position(piece.getX() + i, piece.getY() - i);
            if (board.isPosOccupied(nextPos, piece.isWhite()) == 1) {
                break;
            } else if (board.isPosOccupied(nextPos, piece.isWhite()) == -1) {
                nextPos = new Position(piece.getX() + i, piece.getY() - i, true);
                moveableLocation.add(nextPos);
                break;
            }
            moveableLocation.add(nextPos);
        }

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
