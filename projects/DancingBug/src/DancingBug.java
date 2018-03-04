import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

/**
 * A <code>BoxBug</code> traces out a square "box" of a given size. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class DancingBug extends Bug
{
    
    private int[] times;
    private int curTime;
    private int curPos;


    /**
     * Constructs a box bug that traces an array of length each time it moves
     * @param length the side length
     */

    public DancingBug(int[] array)
    {   
        int len = array.length;
        times = new int[len];
        System.arraycopy(array, 0, times, 0, len);
        curPos = 0;
        curTime = 0;
    }

    public void turn()
    {
        setDirection(getDirection() + Location.HALF_RIGHT);
    }

    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
        if (curTime < times[curPos]) {
            turn();
            curTime++;
        } else if (canMove()) {
            move();
            curTime = 0;
            curPos = (curPos + 1) % times.length;
        }
    }
}