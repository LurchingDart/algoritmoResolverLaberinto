package maze;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * @author NoeAV
 */

public class MazeCrawler {
    Deque<Position> movements = new ArrayDeque<>();
    String right = "right";
    String left = "left";
    String up = "up";
    String down = "down";

    void crawl(short[][] maze, Position start, Position end) {
        movements.push(start);
        while (movements.peek() != end) {
            if (deadEnd(maze)) {
                movements.pop();
            }
            advance(maze);
        }
    }

    boolean deadEnd(short[][] maze) {
        if(movements.peek().canGoUp(maze) == true ||
                movements.peek().canGoRight(maze, 20) == true ||
                movements.peek().canGoLeft(maze) == true ||
                movements.peek().canGoDown(maze, 20) == true ) {
            return false;
        }
        return true;
    }

    private void advance(short[][] maze) {
        Position currentPos = this.movements.peek();
        if(currentPos.canGoRight(maze, 20) == true) {
            currentPos.getRemainingDirections().add(right);
        }
        if(currentPos.canGoUp(maze) == true) {
            currentPos.getRemainingDirections().add(up);
        }
        if(currentPos.canGoDown(maze, 20) == true) {
            currentPos.getRemainingDirections().add(down);
        }
        if(currentPos.canGoLeft(maze) == true) {
            currentPos.getRemainingDirections().add(left);
        }
        if(currentPos.getRemainingDirections().contains(right)){
            currentPos.getRemainingDirections().remove(right);
            this.moveRight(maze);
            return;
        }
        if(currentPos.getRemainingDirections().contains(up)){
            currentPos.getRemainingDirections().remove(up);
            this.moveUp(maze);
            return;
        }
        if(currentPos.getRemainingDirections().contains(down)){
            currentPos.getRemainingDirections().remove(down);
            this.moveDown(maze);
            return;
        }
        if(currentPos.getRemainingDirections().contains(left)){
            currentPos.getRemainingDirections().remove(left);
            this.moveLeft(maze);
            return;
        }
    }

    private void moveUp(short[][] maze) {
        Position current = this.movements.peek();
        Position newPosition = new Position(current.getX(), current.getY() - 1);
        this.movements.push(newPosition);
        if(newPosition.canGoLeft(maze)){
            newPosition.getRemainingDirections().add(left);
        }
        if(newPosition.canGoRight(maze, 20)){
            newPosition.getRemainingDirections().add(right);
        }
        if(newPosition.canGoUp(maze)){
            newPosition.getRemainingDirections().add(up);
        }
    }

    private void moveDown(short[][] maze) {
        Position current = this.movements.peek();
        Position newPosition = new Position(current.getX(), current.getY() + 1);
        this.movements.push(newPosition);
        if(newPosition.canGoLeft(maze)){
            newPosition.getRemainingDirections().add(left);
        }
        if(newPosition.canGoRight(maze, 20)){
            newPosition.getRemainingDirections().add(right);
        }
        if(newPosition.canGoDown(maze, 20)){
            newPosition.getRemainingDirections().add(down);
        }
    }

    private void moveLeft(short[][] maze) {
        Position current = this.movements.peek();
        Position newPosition = new Position(current.getX() - 1, current.getY());
        this.movements.push(newPosition);
        if(newPosition.canGoLeft(maze)){
            newPosition.getRemainingDirections().add(left);
        }
        if(newPosition.canGoRight(maze, 20)){
            newPosition.getRemainingDirections().add(up);
        }
        if(newPosition.canGoDown(maze, 20)){
            newPosition.getRemainingDirections().add(down);
        }

    }

    private void moveRight(short[][] maze) {
        Position current = this.movements.peek();
        Position newPosition = new Position(current.getX() + 1, current.getY());
        this.movements.push(newPosition);
        if(newPosition.canGoLeft(maze)){
            newPosition.getRemainingDirections().add(left);
        }
        if(newPosition.canGoRight(maze, 20)){
            newPosition.getRemainingDirections().add(right);
        }
        if(newPosition.canGoDown(maze, 20)){
            newPosition.getRemainingDirections().add(down);
        }
    }

    public void revealPath(short[][] maze) {
        for (Position position : movements) {
            maze[position.getX()][position.getY()] = 2;
        }
    }
}
