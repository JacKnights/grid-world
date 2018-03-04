import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

/**
 * A <code>BoxBug</code> traces out a square "box" of a given size. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class ZBug extends Bug
{
    private int steps;
    private int sideLength;
    private static final int DEFAULT_LEN = 4;
    private boolean clockwise;
    private int count;

    public ZBug()
    {
        this.setDirection(Location.EAST);
        steps = 0;
        sideLength = DEFAULT_LEN;
        clockwise = true;
        count = 0;
    }

    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    public ZBug(int length)
    {
        this.setDirection(Location.EAST);
        steps = 0;
        sideLength = length;
        clockwise = true;
        count = 0;
    }

    public void turn()
    {
        if (clockwise) {
            setDirection(getDirection() + 3 * Location.HALF_RIGHT);
            clockwise = false;
        } else {
            setDirection(getDirection() - 3 * Location.HALF_RIGHT);
            clockwise = true;
        }
    }

    /**
     * Moves to the next location of the square.
     * Determines the times that the bug runs is enough to make a turn
     */
    public void act()
    {
        if (steps == sideLength) {
            count++;
        }
        if (count > 2) {
            return;
        }
        if (steps < sideLength && canMove())
        {
            move();
            steps++;
        }
        else
        {
            turn();
            steps = 0;
        }
    }
}