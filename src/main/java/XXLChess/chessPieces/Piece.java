package XXLChess.chessPieces;

import java.util.ArrayList;
import java.util.List;

import XXLChess.App;
import XXLChess.movementBehaviour.Position;
import processing.core.PApplet;
import processing.core.PImage;
import processing.data.JSONObject;

public abstract class Piece {

    /* Pieces x-coordinate. */
    int x;

    /* The Pieces's y-cooridnate. */
    int y;

    boolean isWhite;

    private int cellSize = 48;

    private PImage image;

    private double animationX = -1;
    private double animationY = -1;
    private double movementRateX;
    private double movementRateY;

    private JSONObject json;

    // FPS = 60
    public void setMovementRateXY() {
        double deltaX = x - animationX;
        double deltaY = y - animationY;
        double distanceInCells = Math.hypot(deltaX, deltaY);

        if (distanceInCells == 0) {
            movementRateX = 0;
            movementRateY = 0;
            return;
        }

        double speedInCellsPerFrame = (double) getMoveSpeed() / cellSize;
        double framesAtBaseSpeed = distanceInCells / speedInCellsPerFrame;

        // Keep max movement time as an upper bound, but do not slow long moves below
        // the configured piece speed.
        double maxFrames = 60.0 * getMaxTime();
        double framesNeeded = (getMaxTime() > 0) ? Math.min(framesAtBaseSpeed, maxFrames) : framesAtBaseSpeed;

        movementRateX = deltaX / framesNeeded;
        movementRateY = deltaY / framesNeeded;
    }

    public double getAnimationX() {
        return animationX;
    }

    public double getAnimationY() {
        return animationY;
    }

    public void setAnimationY(double animation) {
        this.animationY = animation;
    }

    public void setAnimationX(double animation) {
        this.animationX = animation;
    }

    public Piece(int x, int y, boolean isWhite, JSONObject json) {
        this.x = x;
        this.y = y;
        this.isWhite = isWhite;
        this.json = json;
    }

    public PImage getImage() {
        return image;
    }

    public void setImage(PImage image) {
        image.resize(cellSize, cellSize);
        this.image = image;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public List<Position> movableWithBlock(App board) {
        return new ArrayList<Position>();

    }

    // animation = previous location
    // x = current location
    public void draw(PApplet app) {

        if (Math.abs(getAnimationX() - getX()) < 0.05 && Math.abs(getAnimationY() -
                getY()) < 0.05 || animationX < 0
                || animationY < 0) {
            app.image(this.image, this.x * cellSize, this.y * cellSize);

            return;
        } else {
            app.image(this.image, (float) animationX * cellSize, (float) animationY *
                    cellSize);
            setAnimationX(movementRateX + animationX);
            setAnimationY(movementRateY + animationY);
        }
    }

    public int getX() {
        return this.x;

    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;

    }

    public boolean isKing() {
        return false;
    }

    public int getMoveSpeed() {
        int number = json.getInt(("piece_movement_speed"));
        return number;
    }

    public int getMaxTime() {
        int number = (json.getInt("max_movement_time"));
        return number;
    }
}
