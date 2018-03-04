/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 * @author Cay Horstmann
 */

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.awt.Color;

/**
 * A <code>ChameleonCritter</code> takes on the color of neighboring actors as
 * it moves through the grid. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class QuickCrab extends CrabCritter
{
    /**
     * Randomly selects a neighbor and changes this critter's color to be the
     * same as that neighbor's. If there are no neighbors, no action is taken.
     */

    private static final double HALF = 0.5;

    public void makeMove(Location loc) {
        Location last = getLocation();
        if (loc.equals(getLocation())) {
            double r = Math.random();
            int angle;
            if (r < HALF) {
                angle = Location.LEFT;
            } else {
                angle = Location.RIGHT;
            }
            setDirection(getDirection() + angle);
        } else {
            if (loc == null) {
                removeSelfFromGrid();
            } else {
                moveTo(loc);
            }
        }
        int dir = last.getDirectionToward(loc);
        Location next = getLocation().getAdjacentLocation(dir);
        if (getMoveLocations().size() == 1) {
            return;
        }
        if (getGrid().isValid(next) && getGrid().get(next) == null) {
            moveTo(next);
        }
        
    }
}
