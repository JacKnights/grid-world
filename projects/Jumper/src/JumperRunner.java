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

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;


public class JumperRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        Jumper alice = new Jumper();
        Jumper bob = new Jumper();
        world.add(alice);
        world.add(bob);
        world.add(new Rock());
        world.add(new Rock());
        world.show();
    }

    private String testStr;

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr() {
        testStr = "Testing...";
    }
}