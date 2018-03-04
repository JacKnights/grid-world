
import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
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
 * @author Cay Horstmann
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 */

public class Jumper extends Bug
{

	
    public Jumper()
    {
        
    }

    /**
     * The jumper uses it to turn 45 degrees.
     */
    public void turn()
    {
        setDirection(getDirection() + Location.HALF_RIGHT);
    }

    /**
     * Combine move and turn methods together, by determination of canMove.
     */
    public void act()
    {
        if (canMove())
        {
            move();
        }
        else
        {
            turn();
        }
    }
    
    /**
     * Moves to the next location of the square.
     */
    public void move()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null) {
            return;
        }
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        Location nextNext = next.getAdjacentLocation(getDirection());
        if (gr.isValid(nextNext)) {
            moveTo(nextNext);
        }
        else {
            removeSelfFromGrid();
        }
    }

    /**
     * Determine whether the jumper can move or not
     */
    public boolean canMove()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null) {
            return false;
        }
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        Location nextNext = next.getAdjacentLocation(getDirection());
        if (!gr.isValid(nextNext)) {
            return false;
        }
        Actor neighbor = gr.get(nextNext);
        return (neighbor == null);
    }
}