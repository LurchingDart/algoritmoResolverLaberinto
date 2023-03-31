package maze;

import java.util.LinkedList;

/**
 * @author NoeAV
 */

public class Position {// :D//
    private int x;
    private int y;
    private LinkedList<String> remainingDirections;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
        this.remainingDirections = new LinkedList<>();
    }

    public LinkedList<String> getRemainingDirections() {
        return this.remainingDirections;
    }

    // @Override
    // public int hashCode() {
    // final int prime = 31;
    // int result = 1;
    // result = prime * result + x;
    // result = prime * result + y;
    // return result;
    // }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Position)) {
            return false;
        }
        Position other = (Position) obj;
        return this.x == other.x && this.y == other.y;
    }

    public boolean canGoLeft(short[][] maze) {
        if (this.x == 0) {
            return false;
        }
        if (maze[this.x - 1][this.y] == 0) {
            return true;
        }
        return false;
    }

    public boolean canGoRight(short[][] maze, int width) {
        if (maze[this.x + 1][this.y] == 0) {
            return true;
        }
        return false;
    }

    public boolean canGoUp(short[][] maze) {
        if (this.y == 0) {
            return false;
        }
        if (maze[this.x][this.y - 1] == 0) {
            return true;
        }
        return false;
    }

    public boolean canGoDown(short[][] maze, int height) {
        if (this.y == height - 1) {
            return false;
        }
        if (maze[this.x][this.y + 1] == 0) {
            return true;
        }
        return false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
