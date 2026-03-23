package XXLChess.movementBehaviour;

public class Position {
    int x;
    int y;
    boolean eat;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
        this.eat = false;
    }

    public Position(int x, int y, boolean eat) {
        this.x = x;
        this.y = y;
        this.eat = eat;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isEat() {
        return eat;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (!(obj instanceof Position)) {
            return false;
        }

        if (((Position) obj).getX() == x && ((Position) obj).getY() == y) {
            return true;
        }
        return false;
    }

}
