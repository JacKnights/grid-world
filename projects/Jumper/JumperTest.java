import static org.junit.Assert.*;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;

import org.junit.Test;


public class JumperTest {
	private final Location loc1 = new Location(5, 5);
	private final Location loc2 = new Location(5, 7);
	private final Location loc3 = new Location(7, 7);
	private final Location loc4 = new Location(5, 8);
	private final Location loc5 = new Location(7, 8);
	private final Location loc6 = new Location(5, 9);
	private final Location loc7 = new Location(7, 9);
	private static final int LEFT = 270;
	private static final int RIGHT = 90;
	/*Q1. What will a jumper do if the location in front of it is empty, 
	 *but the location two cells in front contains a flower or a rock?
	 *A1.The jumper will avoid the flower or the rock 2 cells in front and turn right clockwise 
	 *until there is a way.
	 */
	
	@Test
	public void test1() {
		ActorWorld world = new ActorWorld();
        Jumper alice = new Jumper();
        alice.setDirection(RIGHT);
		world.add(loc1, alice);
		Rock r = new Rock();
		world.add(loc2, r);
		alice.act();
		alice.act();
		assertEquals(loc3, alice.getLocation());
	}
	
	/*Q2. What will a jumper do if the location two cells in front of the jumper 
	 *is out of the grid?
	 *A2.The jumper will avoid the edge of the grid 2 cells in front 
	 *and turn right clockwise until there is a way.
	 * 
	 */
	
	@Test
	public void test2() {
		ActorWorld world = new ActorWorld();
        Jumper alice = new Jumper();
        alice.setDirection(RIGHT);
		world.add(loc4, alice);
		alice.act();
		alice.act();
		alice.act();
		assertEquals(loc5, alice.getLocation());
	}
	
	/*Q3.. What will a jumper do if it is facing an edge of the grid?
	 *A3.The jumper will avoid the edge of the grid 
	 *and turn right clockwise until there is a way.
	 */

	@Test
	public void test3() {
		ActorWorld world = new ActorWorld();
        Jumper alice = new Jumper();
        alice.setDirection(RIGHT);
		world.add(loc6, alice);
		alice.act();
		alice.act();
		alice.act();
		assertEquals(loc7, alice.getLocation());
	}
	
	/*
	 *Q4. What will a jumper do if another actor (not a flower or a rock) is in the cell 
	 *that is two cells in front of the jumper?
	 *A4.The jumper will avoid the actor 
	 *and turn right clockwise until there is a way.
	 */

	@Test
	public void test4() {
		ActorWorld world = new ActorWorld();
        Jumper alice = new Jumper();
        alice.setDirection(RIGHT);
        Bug bob = new Bug();
		world.add(loc1, alice);
		world.add(loc2, bob);
		alice.act();
		alice.act();
		assertEquals(loc3, alice.getLocation());
	}
	
	/*Q5. What will a jumper do if it encounters another jumper in its path?
	 *A5.If another jumper is occupying the cell that this one is going to, 
	 *the jumper will avoid the jumper and turn right clockwise until there is a way. 
	 *Otherwise it can jumper over another jumper.
	 * 
	 */
	
	@Test
	public void test5() {
		ActorWorld world = new ActorWorld();
        Jumper alice = new Jumper();
        alice.setDirection(RIGHT);
        Jumper bob = new Jumper();
		world.add(loc1, alice);
		world.add(loc2, bob);
		alice.act();
		alice.act();
		assertEquals(loc3, alice.getLocation());
	}
	
	/*Q6. Are there any other tests the jumper needs to make?
	 *A6. Yes, like what will happen if two jumpers are going to a same cell the next step.
	 */
	
	@Test
	public void test6() {
		ActorWorld world = new ActorWorld();
        Jumper alice = new Jumper();
        alice.setDirection(RIGHT);
        Jumper bob = new Jumper();
        bob.setDirection(LEFT);
		world.add(loc1, alice);
		world.add(loc2, bob);
		alice.act();
		alice.act();
		assertEquals(loc3, alice.getLocation());
	}
}
