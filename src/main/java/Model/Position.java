package Model;

public class Position {
    private int x;
    private int y;

    // Constructor
    public Position(int x, int y) {
        setX(x);
        setY(y);
    }

    // Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Setters
    public void setX(int x) throws IllegalArgumentException {
        if (x >= 0) {
            this.x = x;
        } else {
            throw new IllegalArgumentException("You entered negative X coordinate!");
        }
    }

    public void setY(int y) throws IllegalArgumentException {
        if (y >= 0) {
            this.y = y;
        } else {
            throw new IllegalArgumentException("You entered negative Y coordinate!");
        }
    }
}
