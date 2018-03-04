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
import info.gridworld.actor.Rock;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.awt.Color;

/**
 * A <code>ChameleonCritter</code> takes on the color of neighboring actors as
 * it moves through the grid. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class BlusterCritter extends Critter
{
    /**
     * Randomly selects a neighbor and changes this critter's color to be the
     * same as that neighbor's. If there are no neighbors, no action is taken.
     */


    private static final double DARKENING_FACTOR = 0.1;

    private int courage;

    public BlusterCritter(int c) {
        courage = c;
    }

    private void brighter() {
        Color c = getColor();
        int red = (int) (c.getRed() * (1 + DARKENING_FACTOR));
        int green = (int) (c.getGreen() * (1 + DARKENING_FACTOR));
        int blue = (int) (c.getBlue() * (1 + DARKENING_FACTOR));
        if (red >= 255) {
            red = 255;
        }
        if (green >= 255) {
            green = 255;
        }
        if (blue >= 255) {
            blue = 255;
        }
        setColor(new Color(red, green, blue));
    }

    private void darken() {
        Color c = getColor();
        int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
        int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
        int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));
        setColor(new Color(red, green, blue));
    }
    
    /**
     * Processes the elements of <code>actors</code>. New actors may be added
     * to empty locations. Implemented to "eat" (i.e. remove) selected actors
     * that are not rocks or critters. Override this method in subclasses to
     * process actors in a different way. <br />
     * Postcondition: (1) The state of all actors in the grid other than this
     * critter and the elements of <code>actors</code> is unchanged. (2) The
     * location of this critter is unchanged.
     * @param actors the actors to be processed
     */
    public void processActors(ArrayList<Actor> actors)
    {
        int n = actors.size();
        if (n < courage) {
            brighter();
        } else {
            darken();
        }
    }

    public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> result = new ArrayList<Actor>();
        for (int i = 0; i < Location.FULL_CIRCLE; i += Location.HALF_RIGHT) {
            Location aj = this.getLocation().getAdjacentLocation(i);
            ArrayList<Actor> actors = getGrid().getNeighbors(aj);
            for (Actor a: actors) {
                if (a == this) {
                    continue;
                }
                boolean f = true;
                for (Actor r: result) {
                    if (a == r) {
                        f = false;
                        break;
                    }
                }
                if (f && a instanceof Critter) {
                    result.add(a);
                }
            }
        }
        return result;
    }

    /**
     * Turns towards the new location as it moves.
     */
    public void makeMove(Location loc)
    {
        setDirection(getLocation().getDirectionToward(loc));
        super.makeMove(loc);
    }
}
