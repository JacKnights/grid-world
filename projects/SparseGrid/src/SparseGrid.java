/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2002-2006 College Entrance Examination Board 
 * (http://www.collegeboard.com).
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
 * @author Alyce Brady
 * @author APCS Development Committee
 * @author Cay Horstmann
 */


import java.util.ArrayList;

import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;


/**
 * A <code>BoundedGrid</code> is a rectangular grid with a finite number of
 * rows and columns. <br />
 * The implementation of this class is testable on the AP CS AB exam.
 */
public class SparseGrid<E> extends AbstractGrid<E>
{
    //private Object[][] occupantArray; // the array storing the grid elements
    private ArrayList<ArrayList<SparseGridNode>> occupantList;
    private int maxRow, maxCol;

    /**
     * Constructs an empty bounded grid with the given dimensions.
     * (Precondition: <code>rows > 0</code> and <code>cols > 0</code>.)
     * @param rows number of rows in BoundedGrid
     * @param cols number of columns in BoundedGrid
     */
    public SparseGrid(int rows, int cols)
    {
        if (rows <= 0) {
            throw new IllegalArgumentException("rows <= 0");
        }
        if (cols <= 0) {
            throw new IllegalArgumentException("cols <= 0");
        }
        maxRow = rows;
        maxCol = cols;
        occupantList = new ArrayList<ArrayList<SparseGridNode>>();
        for (int i = 0; i < maxRow; i++) {
            occupantList.add(new ArrayList<SparseGridNode>());
        }
    }

    public int getNumRows()
    {
        return maxRow;
    }

    public int getNumCols()
    {
        // Note: according to the constructor precondition, numRows() > 0, so
        // theGrid[0] is non-null.
        return maxCol;
    }

    public boolean isValid(Location loc)
    {
        return 0 <= loc.getRow() && loc.getRow() < maxRow && 0 <= loc.getCol() && loc.getCol() < maxCol;
    }

    public ArrayList<Location> getOccupiedLocations()
    {
        ArrayList<Location> theLocations = new ArrayList<Location>();

        // Look at all grid locations.
        for (int r = 0; r < occupantList.size(); r++)
        {
            for (int c = 0; c < occupantList.get(r).size(); c++)
            {
                // If there's an object at this location, put it in the array.
                Location loc = new Location(r, occupantList.get(r).get(c).getCol());
                if (get(loc) != null) {
                    theLocations.add(loc);
                }
            }
        }

        return theLocations;
    }

    public E get(Location loc)
    {
        if (!isValid(loc)) {
            throw new IllegalArgumentException("Location " + loc + " is not valid");
        }
        int row = loc.getRow();
        int col = loc.getCol();
        for (SparseGridNode sn : occupantList.get(row)) {
            if (sn.getCol() == col) {
                return (E) sn.getObj();
            }
        }
        return null;
    }

    public E put(Location loc, E obj)
    {
        if (!isValid(loc)) {
            throw new IllegalArgumentException("Location " + loc + " is not valid");
        }
        if (obj == null) {
            throw new NullPointerException("obj == null");
        }

        // Add the object to the grid.
        E oldOccupant = get(loc);
        int row = loc.getRow();
        int col = loc.getCol();
        ArrayList<SparseGridNode> thisRow = occupantList.get(row);
        for (int i = 0; i < thisRow.size(); i++) {
            if (thisRow.get(i).getCol() == col) {
                occupantList.get(row).remove(i);
            }
        }
        occupantList.get(row).add(new SparseGridNode(col, obj));
        return oldOccupant;
    }

    public E remove(Location loc)
    {
        if (!isValid(loc)) {
            throw new IllegalArgumentException("Location " + loc + " is not valid");
        }
        
        // Remove the object from the grid.
        E r = get(loc);
        int row = loc.getRow();
        int col = loc.getCol();
        ArrayList<SparseGridNode> thisRow = occupantList.get(row);
        for (int i = 0; i < thisRow.size(); i++) {
            if (thisRow.get(i).getCol() == col) {
                occupantList.get(row).remove(i);
            }
        }
        return r;
    }
}
