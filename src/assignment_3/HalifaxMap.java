package assignment_3;

import java.util.*;

/**
 * This code was reference from :
 * Saurel, S. (2016) Calculate shortest paths in Java by implementing Dijkstra’s Algorithm [source code]. 
 * https://medium.com/@ssaurel/calculate-shortest-paths-in-java-by-implementing-dijkstras-algorithm-5c1db06b6541
 * 
 * Rajan, H. Printing Paths in Dijkstra’s Shortest Path Algorithm [source code]. 
 * https://www.geeksforgeeks.org/printing-paths-dijkstras-shortest-path-algorithm/
 * 
 * @author Jan
 */
public class HalifaxMap {

    // Define symbols to use in the program as a way of knowing what we're seeing in the text.
    private static final String TAB = "\t";
    private static final String NO_PATH = "no path";

    // Data storage
    private Map<Vertex, Intersection> intersections; // graph - adjacency list
    private Set<Road> allRoads;

    // Constructor
    public HalifaxMap() {
        this.intersections = new HashMap<>();
        this.allRoads = new HashSet<>();
    }

    //----------------------------------------------------------------------------//
    // Add new intersection to the intersections
    public boolean newIntersection(int x, int y) {
        Vertex vertex = new Vertex(x, y);
        if (intersections.containsKey(vertex)) { // key already exists
            return false;
        } else { // new intersection
            Intersection intersection = new Intersection();
            intersections.put(vertex, intersection);
            return true;
        }
    }

    //----------------------------------------------------------------------------//
    // Add new road to the intersections and allRoads
    public boolean defineRoad(int x1, int y1, int x2, int y2) {
        Vertex v1 = new Vertex(x1, y1);
        Vertex v2 = new Vertex(x2, y2);
        Road road = new Road(v1, v2);

        if (allRoads.contains(road)) { // road already exists
            return false;
        } else {           
            // add road to allRoads
            allRoads.add(road);
            // add all the road to the intersection, each road added to two intersections (to and from)
            addRoad(road, v1);
            addRoad(road, v2);
            return true;
        }
    }

    // add road in the intersections
    private void addRoad(Road road, Vertex vertex) {
        if (intersections.containsKey(vertex)) { // add to existing vertex
            intersections.get(vertex).addConnectedRoad(road);
        } else { // add as new vertex
            Intersection intersection = new Intersection();
            intersection.addConnectedRoad(road);
            intersections.put(vertex, intersection);
        }
    }

    //----------------------------------------------------------------------------//
    // navigate the way from source to destination
    public void navigate(int x1, int y1, int x2, int y2) {
        Vertex v1 = new Vertex(x1, y1);
        Vertex v2 = new Vertex(x2, y2);
        
        if (!intersections.containsKey(v1)
                || !intersections.containsKey(v2)) { // vertex not exists
            System.out.println(NO_PATH);
        } else if (v1.equals(v2)) { // same location (no need to calculate)
            System.out.println(x1 + TAB + y1);
            System.out.println(x2 + TAB + y2);
        } else { // path exists
            calculateShortestDistances(v1);
            printSolution(v2);
        }
    }

    // implement the Dijkstra algorithm to calculate the shortest distance
    private void calculateShortestDistances(Vertex source) {
        // reset distance value
        resetValues();

        // set distance for itself as 0
        intersections.get(source).setShortestDistance(0);
        Vertex key = source;

        // visit every intersection
        for (int i = 0; i < intersections.size(); i++) {
            Set<Road> currentRoads = intersections.get(key).getConnectedRoads();
            Iterator<Road> iterator = currentRoads.iterator();
            // loop around the roads of current intersection
            while (iterator.hasNext()) {
                Road road = iterator.next();
                Vertex neighborIntersection = road.getAnotherLocation(key);
                // only if not visited, compare to find the shortest path
                if (!intersections.get(neighborIntersection).isVisited()) {
                    int tentative = intersections.get(key).getShortestDistance() + road.getLength();
                    if (tentative < intersections.get(neighborIntersection).getShortestDistance()) {
                        intersections.get(neighborIntersection).setShortestParentPath(key);
                        intersections.get(neighborIntersection).setShortestDistance(tentative);
                    }
                }
            }
            // all neighbours checked so intersection is visited
            intersections.get(key).setVisited(true);

            // next intersection must be with shortest distance
            key = getShortestDistancedIntersection();
        }
    }

    // Reset the values before doing the calculation
    private void resetValues() {
        Iterator iteratorReset = intersections.entrySet().iterator();
        while (iteratorReset.hasNext()) {
            Map.Entry keyValue = (Map.Entry) iteratorReset.next();
            Vertex key = (Vertex) keyValue.getKey();
            intersections.get(key).setShortestDistance(Integer.MAX_VALUE);
            intersections.get(key).setVisited(false);
            intersections.get(key).setShortestParentPath(null);
        }
    }

    // Get the shortest distanced intersection from the intersection that is not visited
    private Vertex getShortestDistancedIntersection() {
        Vertex vertex = new Vertex(0, 0);
        int storedDistance = Integer.MAX_VALUE;
        Iterator iterator = intersections.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry keyValue = (Map.Entry) iterator.next();
            Vertex key = (Vertex) keyValue.getKey();
            int currentDistance = intersections.get(key).getShortestDistance();
            if (!intersections.get(key).isVisited() && currentDistance < storedDistance) {
                storedDistance = currentDistance;
                vertex = key;
            }
        }
        return vertex;
    }

    // Print the shortest paths 
    private void printSolution(Vertex destination) {
        // if shortest distance is Integer.MAX_VALUE --> no path
        if (intersections.get(destination).getShortestDistance() == Integer.MAX_VALUE) {
            System.out.println(NO_PATH);
            return;
        }
        printPath(destination);
    }

    // Print shortest path from source to vertex
    private void printPath(Vertex vertex) {
        // Base case
        if (vertex == null) {
            return;
        }
        printPath(intersections.get(vertex).getShortestParentPath());
        System.out.println(vertex.getX() + TAB + vertex.getY());
    }
}