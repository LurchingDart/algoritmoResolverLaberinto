package maze;

import java.util.LinkedList;
/**
 * @author NoeAV
 */
public class Position {
    private int x;
    private int y;
    private LinkedList<String> remainingDirections;
    Board board = new Board();

    public Position(int x, int y){
        this.x = x;
        this.y = y;
        this.remainingDirections = new LinkedList<>();
    }

    public LinkedList<String> getRemainingDirections(){
        return this.remainingDirections;
    }

    public boolean canGoLeft(short[][] maze){
        if(this.x == 0){
            return false;
        }
        if(maze[this.x - 1][this.y] == 0){
            return true;
        }
        return false;
    }
    public boolean canGoRight(short[][] maze, int width){
        if (maze[this.x + 1][this.y] == 0) {
            return true;
        }
        return false;
    }
    public boolean canGoUp(short[][] maze){
        if(this.y == 0){
            return false;
        }
        if (maze[this.x][this.y - 1] == 0) {
            return true;
        }
        return false;
    }
    public boolean canGoDown(short[][] maze, int height){
        if(this.y == height-1){
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
