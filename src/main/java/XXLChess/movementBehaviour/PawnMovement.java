package XXLChess.movementBehaviour;

import java.util.ArrayList;
import java.util.List;

import XXLChess.App;
import XXLChess.chessPieces.Piece;

public class PawnMovement implements MovementStrategy {
    List<Piece> pieces = XXLChess.App.getPieces();

    public List<Position> moveableWithBlock(App board, Piece piece) {
        List<Position> moveableLocation = new ArrayList<Position>();
        Boolean colour = new Boolean(board.playerColour());
        if (colour) {
            if (piece.isWhite() == true) {
                Position PawnUpOne = new Position(piece.getX(), -1 + piece.getY());
                Position whiteNextPos = new Position(piece.getX() - 1, piece.getY() - 1, true);
                Position whiteNextPosTwo = new Position(piece.getX() + 1, piece.getY() - 1, true);

                if (board.isPosOccupied(PawnUpOne, piece.isWhite()) == 0) {
                    moveableLocation.add(PawnUpOne);
                    if (piece.getY() == 12) {
                        Position PawnUpTwo = new Position(piece.getX(), -2 + piece.getY());
                        if (board.isPosOccupied(PawnUpTwo, piece.isWhite()) == 0) {
                            moveableLocation.add(PawnUpTwo);
                        }
                    }

                }
                if (board.isPosOccupied(whiteNextPos, piece.isWhite()) == -1) {
                    moveableLocation.add(whiteNextPos);

                }
                if (board.isPosOccupied(whiteNextPosTwo, piece.isWhite()) == -1) {
                    moveableLocation.add(whiteNextPosTwo);
                }
            } else {
                Position blackNextPos = new Position(piece.getX() - 1, piece.getY() + 1, true);
                Position blackNextPosTwo = new Position(piece.getX() + 1, piece.getY() + 1, true);
                Position PawnUpOne = new Position(piece.getX(), 1 + piece.getY());
                if (board.isPosOccupied(PawnUpOne, piece.isWhite()) == 0) {
                    moveableLocation.add(PawnUpOne);
                    if (piece.getY() == 1) {
                        Position PawnUpTwo = new Position(piece.getX(), 2 + piece.getY());
                        if (board.isPosOccupied(PawnUpTwo, piece.isWhite()) == 0) {
                            moveableLocation.add(PawnUpTwo);
                        }
                    }
                }
                if (board.isPosOccupied(blackNextPos, piece.isWhite()) == -1) {
                    moveableLocation.add(blackNextPos);

                }
                if (board.isPosOccupied(blackNextPosTwo, piece.isWhite()) == -1) {
                    moveableLocation.add(blackNextPosTwo);
                }
            }

            return moveableLocation;

        } else {

            if (piece.isWhite() == false) {
                Position PawnUpOne = new Position(piece.getX(), -1 + piece.getY());
                Position whiteNextPos = new Position(piece.getX() - 1, piece.getY() - 1, true);
                Position whiteNextPosTwo = new Position(piece.getX() + 1, piece.getY() - 1, true);

                if (board.isPosOccupied(PawnUpOne, false) == 0) {
                    moveableLocation.add(PawnUpOne);
                    if (piece.getY() == 12) {
                        Position PawnUpTwo = new Position(piece.getX(), -2 + piece.getY());
                        if (board.isPosOccupied(PawnUpTwo, piece.isWhite()) == 0) {
                            moveableLocation.add(PawnUpTwo);
                        }
                    }

                }
                if (board.isPosOccupied(whiteNextPos, !piece.isWhite()) == -1) {
                    moveableLocation.add(whiteNextPos);

                }
                if (board.isPosOccupied(whiteNextPosTwo, !piece.isWhite()) == -1) {
                    moveableLocation.add(whiteNextPosTwo);
                }
            } else {
                Position blackNextPos = new Position(piece.getX() - 1, piece.getY() + 1, true);
                Position blackNextPosTwo = new Position(piece.getX() + 1, piece.getY() + 1, true);
                Position PawnUpOne = new Position(piece.getX(), 1 + piece.getY());
                if (board.isPosOccupied(PawnUpOne, piece.isWhite()) == 0) {
                    moveableLocation.add(PawnUpOne);
                    if (piece.getY() == 1) {
                        Position PawnUpTwo = new Position(piece.getX(), 2 + piece.getY());
                        if (board.isPosOccupied(PawnUpTwo, !piece.isWhite()) == 0) {
                            moveableLocation.add(PawnUpTwo);
                        }
                    }
                }
                if (board.isPosOccupied(blackNextPos, piece.isWhite()) == -1) {
                    moveableLocation.add(blackNextPos);

                }
                if (board.isPosOccupied(blackNextPosTwo, piece.isWhite()) == -1) {
                    moveableLocation.add(blackNextPosTwo);
                }
            }

            return moveableLocation;
        }
    }

}
