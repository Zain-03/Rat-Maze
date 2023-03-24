import java.util.Stack;

public class SolveMaze {
    Maze maze;
    Rat rat;
    Stack stack;

    public static void main(String[] args) {
        new SolveMaze("src/Maze.txt");
    }

    public SolveMaze(String file) {
        maze = new Maze(file);
        rat = new Rat(maze);
        stack = new Stack<Location>();
        maze.print();
        System.out.println("\n");

        maze.markMoved(rat.getLocation());
        while (!rat.isOut()) {
            if (rat.canMove(Direction.NORTH)) {
                stack.push(rat.getLocation());
                rat.move(Direction.NORTH);
            } else if (rat.canMove(Direction.SOUTH)) {
                stack.push(rat.getLocation());
                rat.move(Direction.SOUTH);
            } else if (rat.canMove(Direction.EAST)) {
                stack.push(rat.getLocation());
                rat.move(Direction.EAST);
            } else if (rat.canMove(Direction.WEST)) {
                stack.push(rat.getLocation());
                rat.move(Direction.WEST);
            } else if (stack.isEmpty()) {
                System.out.println("NO SOLUTION!");
            } else {
                maze.markTried(rat.getLocation());
                Location location = (Location) stack.pop();
                rat.setLocation(location);
            }

            maze.print();
            System.out.println();
        }
        maze.print();

    }

}
