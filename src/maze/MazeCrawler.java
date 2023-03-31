package maze;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * @author NoeAV
 * @author LurchingDart
 * @version 1.0
 * @since 1.0
 * 
 * @see MazeCrawler
 *
 **/

public class MazeCrawler {
    Deque<Position> movements = new ArrayDeque<>();
    String right = "right";
    String left = "left";
    String up = "up";
    String down = "down";
    int elnumero = 20;

    void crawl(short[][] maze, Position start, Position end) {
        movements.push(start);
        while (!movements.peek().equals(end)) {
            if (deadEnd(maze)) {
                movements.pop();
            }
            advance(maze);
            revealPath(maze);
            System.out.println("Posicion actual: \n");
            System.out.println(movements.peek().getX() + " " + movements.peek().getY());
            System.out.println("----------------------------------------------------");
            System.out.println("END = " + end.getX() + " " + end.getY());
        }
    }

    boolean deadEnd(short[][] maze) {
        // debería imprimir "true"
        if (movements.peek().canGoUp(maze) == true ||
                movements.peek().canGoRight(maze, elnumero) == true ||
                movements.peek().canGoLeft(maze) == true ||
                movements.peek().canGoDown(maze, elnumero) == true) {
            return false;
        }
        return true;
    }

    private void advance(short[][] maze) {
        Position currentPos = this.movements.peek();
        if (currentPos.canGoDown(maze, elnumero) == true) {
            currentPos.getRemainingDirections().add(down);
        }
        if (currentPos.canGoRight(maze, elnumero) == true) {
            currentPos.getRemainingDirections().add(right);
        }
        if (currentPos.canGoUp(maze) == true) {
            currentPos.getRemainingDirections().add(up);
        }
        if (currentPos.canGoLeft(maze) == true) {
            currentPos.getRemainingDirections().add(left);
        }
        // ---------------------------------------------------//
        if (currentPos.getRemainingDirections().contains(down)) {
            currentPos.getRemainingDirections().remove(down);
            this.moveDown(maze);
            return;
        }
        if (currentPos.getRemainingDirections().contains(left)) {
            currentPos.getRemainingDirections().remove(left);
            this.moveLeft(maze);
            return;
        }
        if (currentPos.getRemainingDirections().contains(right)) {
            currentPos.getRemainingDirections().remove(right);
            this.moveRight(maze);
            return;
        }
        if (currentPos.getRemainingDirections().contains(up)) {
            currentPos.getRemainingDirections().remove(up);
            this.moveUp(maze);
            return;
        }
    }

    private void moveUp(short[][] maze) {
        Position current = this.movements.peek();
        Position newPosition = new Position(current.getX(), current.getY() - 1);
        this.movements.push(newPosition);
        if (newPosition.canGoLeft(maze)) {
            newPosition.getRemainingDirections().add(left);
        }
        if (newPosition.canGoRight(maze, elnumero)) {
            newPosition.getRemainingDirections().add(right);
        }
        if (newPosition.canGoUp(maze)) {
            newPosition.getRemainingDirections().add(up);
        }
    }

    private void moveDown(short[][] maze) {
        Position current = this.movements.peek();
        Position newPosition = new Position(current.getX(), current.getY() + 1);
        this.movements.push(newPosition);
        if (newPosition.canGoLeft(maze)) {
            newPosition.getRemainingDirections().add(left);
        }
        if (newPosition.canGoRight(maze, elnumero)) {
            newPosition.getRemainingDirections().add(right);
        }
        if (newPosition.canGoDown(maze, elnumero)) {
            newPosition.getRemainingDirections().add(down);
        }
    }

    private void moveLeft(short[][] maze) {
        Position current = this.movements.peek();
        Position newPosition = new Position(current.getX() - 1, current.getY());
        this.movements.push(newPosition);
        if (newPosition.canGoLeft(maze)) {
            newPosition.getRemainingDirections().add(left);
        }
        if (newPosition.canGoRight(maze, elnumero)) {
            newPosition.getRemainingDirections().add(up);
        }
        if (newPosition.canGoDown(maze, elnumero)) {
            newPosition.getRemainingDirections().add(down);
        }
    }

    private void moveRight(short[][] maze) {
        Position current = this.movements.peek();
        Position newPosition = new Position(current.getX() + 1, current.getY());
        this.movements.push(newPosition);
        if (newPosition.canGoLeft(maze)) {
            newPosition.getRemainingDirections().add(left);
        }
        if (newPosition.canGoRight(maze, elnumero)) {
            newPosition.getRemainingDirections().add(right);
        }
        if (newPosition.canGoDown(maze, elnumero)) {
            newPosition.getRemainingDirections().add(down);
        }
    }

    public void revealPath(short[][] maze) {
        for (Position position : movements) {
            maze[position.getX()][position.getY()] = 2;
        }
    }
}
