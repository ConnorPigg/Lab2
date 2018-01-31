import edu.illinois.cs.cs125.lib.mazemaker.Maze;

/**
 * Solve a randomly-generated maze.
 *
 * @see <a href="https://github.com/cs125-illinois/mazemaker">Mazemaker on GitHub</a>
 * @see <a href="https://cs125-illinois.github.io/mazemaker/">Mazemaker Documentation</a>
 * @see <a href="https://cs125.cs.illinois.edu/lab/2/#maze">Lab 2 Writeup</a>
 */
@SuppressWarnings("checkstyle:emptyblock")
public class SolveMaze {

    /**
     * Implement your maze solving algorithm in the main method below.
     *
     * @param unused unused input arguments
     */

    public static void main(final String[] unused) {
        /*
         * Create a new 10 x 10 maze. Feel free to change these values.
         */
        Maze maze = new Maze(10, 10);

        /*
         * Pick (0, 0), the bottom left corner, as the starting point.
         * Put the end in the top right corner.
         */
        //maze.startAtZero();
        //maze.endAtTopRight();
        maze.endAtRandomLocation();
        maze.startAtRandomLocation();
        /*
         * You should be able to solve a 10 x 10 maze in (far fewer than) 1000 steps.
         * Feel free to adjust this number if you experiment with other mazes.
         */
        System.out.println(solveRand(maze));

        if (maze.isFinished()) {
            System.out.println("You solved the maze!");
        } else {
            System.out.println("Try again!");
        }
    }
    /**
     * This is a function to solve the maze that should use Left wall following.
     *
     * @param maze pass in the maze object to be solved
     */
    private static int solveMaze(Maze maze){
        int step = 0;
        while (!maze.isFinished()) {
            // Implement your maze solving algorithm here
            maze.turnLeft();
            if (maze.canMove()) {
                maze.move();
            } else {
                maze.turnRight();
                if (maze.canMove()) {
                    maze.move();
                } else {
                    maze.turnRight();
                    if (maze.canMove()) {
                        maze.move();
                    }
                }
            }
            step++;
        }
        return step;
    }
    /**
     * A function that solves the maze with random walk.
     *
     * @param maze th maze to solve.
     */
    private static int solveRand(Maze maze){
        int step = 0;
        while (!maze.isFinished()) {
            if (maze.canMove()) {
                maze.move();
            } else {
                int rand = (int) (Math.random() * 2); //either 0 or 1
                if (rand == 0) {
                    maze.turnRight();
                } else {
                    maze.turnLeft();
                }
            }
            step++;
            if(step % 10000000 == 0) {
                System.out.println(step);
            }
        }
        return step;
    }
}
