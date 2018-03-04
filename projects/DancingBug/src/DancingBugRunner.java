
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
 * This class runs a world that contains box bugs. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class DancingBugRunner
{
    public static void main(String[] args)
    {
        /*
         *Here cantain some tests for dancing bug.
         */
        ActorWorld world = new ActorWorld();
        final int[] a1 = {0, 2, 5, 7, 1, 9, 4, 8, 6};
        final int[] a2 = {0, 3, 2, 7};
        DancingBug alice = new DancingBug(a1);
        DancingBug bob = new DancingBug(a2);
        world.add(alice);
        world.add(bob);
        world.show();
    }
}