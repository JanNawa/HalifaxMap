package assignment_3;

/**
 *
 * @author Jan
 */
public class Vertex {
    
    // Defines value for Vertex (x, y)
    private int x;
    private int y;

    // Constructor
    public Vertex(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getter for x value
    public int getX() {
        return x;
    }

    // Getter for y value
    public int getY() {
        return y;
    }

    // Override equals to compare value (x, y)
    @Override
    public boolean equals(Object obj) {
        // if the object compare with itself, return true
        if (this == obj) {
            return true;
        }
        // if the object is null, return false
        if (obj == null) {
            return false;
        }
        // if the class of the object is not the same, return false
        if (getClass() != obj.getClass()) {
            return false;
        }
        // Casting the object to Vertex
        final Vertex other = (Vertex) obj;
        // if x is not equal, return false
        if (this.x != other.x) {
            return false;
        }
        // if y is not equal, return false
        if (this.y != other.y) {
            return false;
        }
        // object is equal
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.x;
        hash = 37 * hash + this.y;
        return hash;
    }
}