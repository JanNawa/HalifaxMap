package assignment_3;

import java.util.*;

/**
 * This code was reference from :
 * Saurel, S. (2016) Calculate shortest paths in Java by implementing Dijkstra’s Algorithm [source code]. 
 * https://medium.com/@ssaurel/calculate-shortest-paths-in-java-by-implementing-dijkstras-algorithm-5c1db06b6541
 * 
 * @author Jan
 */
public class Intersection {
    
    // Defines the attributes for the intersection
    private int shortestDistance;
    private Vertex shortestParentPath;
    private boolean visited;
    private Set<Road> connectedRoads; // connected road to the vertex

    // default constructor
    public Intersection() {
        this.shortestDistance = Integer.MAX_VALUE;
        this.shortestParentPath = null;
        this.visited = false;
        this.connectedRoads = new HashSet<>();
    }

    // Getter and Setter for shortestDistance
    public int getShortestDistance() {
        return shortestDistance;
    }

    public void setShortestDistance(int shortestDistance) {
        this.shortestDistance = shortestDistance;
    }

    // Getter and Setter for visited
    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    
    // Getter and Add for connectedRoads
    public void addConnectedRoad(Road road){
        connectedRoads.add(road);
    }

    public Set<Road> getConnectedRoads() {
        Set<Road> roads = connectedRoads;
        return roads;
    }

    // Getter and Setter for shortestParentPath
    public Vertex getShortestParentPath() {
        Vertex vertex = shortestParentPath;
        return vertex;
    }

    public void setShortestParentPath(Vertex shortestParentPath) {
        this.shortestParentPath = shortestParentPath;
    }
}