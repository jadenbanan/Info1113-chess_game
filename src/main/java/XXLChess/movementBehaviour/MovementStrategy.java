package XXLChess.movementBehaviour;

import java.util.List;

import XXLChess.App;
import XXLChess.chessPieces.Piece;

public interface MovementStrategy {
    public List<Position> moveableWithBlock(App board, Piece pieces);

}
