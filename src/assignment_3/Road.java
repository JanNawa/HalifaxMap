package assignment_3;

import java.util.Objects;

/**
 * This code was reference from :
 * Saurel, S. (2016) Calculate shortest paths in Java by implementing Dijkstra’s Algorithm [source code]. 
 * https://medium.com/@ssaurel/calculate-shortest-paths-in-java-by-implementing-dijkstras-algorithm-5c1db06b6541
 * 
 * @author Jan
 */
public class Road {
    
    // Defines locations and length between both location
    private Vertex source;
    private Vertex destination;
    private int length;

    // Constructor
    public Road(Vertex source, Vertex destination) {
        this.source = source;
        this.destination = destination;
        this.length = calculateLength();
    }
    
    // calculate length from current location to destination
    private int calculateLength(){
        int x1 = source.getX();
        int y1 = source.getY();
        int x2 = destination.getX();
        int y2 = destination.getY();
        return (int) Math.round( Math.sqrt( Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2)));
    }

    // get source location
    public Vertex getSource() {
        Vertex currentLoc = source;
        return currentLoc;
    }

    // get destination
    public Vertex getDestination() {
        Vertex dest = destination;
        return dest;
    }

    // get another location
    public Vertex getAnotherLocation(Vertex intersection) {
        if (intersection.getX() == source.getX()
                && intersection.getY() == source.getY()) {
            return getDestination();
        } else {
            return getSource();
        }
    }
    
    // get length from source to destination
    public int getLength() {
        return length;
    }

    // For compare vertex by their attributes
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
        // Casting the object to Road
        final Road other = (Road) obj;
        if (this.length != other.length) {
            return false;
        }
        // if source is not equal, return false
        if (!Objects.equals(this.source, other.source)) {
            return false;
        }
        // if destination is not equal, return false
        if (!Objects.equals(this.destination, other.destination)) {
            return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.source);
        hash = 29 * hash + Objects.hashCode(this.destination);
        hash = 29 * hash + this.length;
        return hash;
    } 
}