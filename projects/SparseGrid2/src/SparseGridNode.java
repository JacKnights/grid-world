import java.util.ArrayList;


public class SparseGridNode {
    private Object occupant;
    private int col;

    public int getCol() {
        return col;
    }

    public Object getObj() {
        return occupant;
    }

    SparseGridNode() {

    }

    SparseGridNode(int c, Object obj) {
        col = c;
        occupant = obj;
    }

}