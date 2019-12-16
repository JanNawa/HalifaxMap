# Halifax Map
This program imitate map to navigate the city with intersection, road and vertex.
* Intersection represents the connection between the road to the vertex.
* Road represents the path between the vertex.
* Vertex represents the location in specific point.
The vertex and road could be added to the map.
Noted that vertex don't need to connect to the road 
but road need to connect to vertex.
User can navigate the shortest path from current location to destination.
This is implemented by using Dijkstra's algorithm to find the shortest path in graph (adjacency list).

## Files and external data
There are 4 main files:
* Vertex.java 
	class that define vertex in (x, y)
	design as immutable object so after created, the data can't be changed. (only have getter, no setter)
* Road.java 
	class that define road with main attributes
		* source (in vertex)
		* destination (in vertex)
		* length (length from source to destination)
	design as immutable object so after created, the data can't be changed. (only have getter, no setter)
* Intersection.java
	class that connect vertex and road 
	contains attribute to determine the shortest path
* HalifaxMap.java
	class that connect all intersections and roads together like graph
	implement the Dijkstra's algorithm to determine the shortest path

## Data structures and their relations to each other
### HalifaxMap.java
* intersections - Map
The program store vertex and graph in adjacency list using Map implementation.
Using vertex as key so that it's unique (no duplicate key) and easy to find information.
The value contains the intersection information regarding to that vertex.
Moreover, map is fast at add and retrieve value which is the thing that mainly do in this program.
Choosing to use adjacency list because better space than other graph, in the cost of more time searching.
* allRoads - Set
As all road is unique, the data is kept in set to make sure that no duplicate value.
(The road should not build on top of each other in this program). 
This will help to see if the new road is the same as existing road. 

### Intersection.java
* connectedRoad - Set
As all road is unique, the data is kept in set to make sure that no duplicate value.
This represent the road that connected to the vertex(key) in HalifaxMap class.
 
### Road.java
Contains source and destination of the road (in vertex).
Implement as object to make it easier to compare across the program.
Having length between the source and destination calculated within the class, to ensure consistency.
These information will be used in the HalifaxMap (graph) to calculate the shortest path from location user provided.

### Vertex.java
Contain (x, y) which will be basic elements that will be implement across classes to easily represent the location.
Implement as object to make it easier to compare across the program.

## Assumptions
* The input validation should be filtered at the user interface to separate the functionality in program design.
* The intersection could have 0 or more roads connect to it.
* The beginning and ending part of the road is always the vertex.
* If the vertex doesn't exist when the road was created, the vertex will be created with the road.
* If the user request same current location and destination, 
program will return current location and destination (no vertex in between).

## Choices
* Using Iterator where possible, to loop all elements. 
Increase readability and easier to change the data structure in the future.
* Encapsulation --- protect data and don't let object escape/being modified outside of its class (Information Hiding)
* Using user-defined object to easily compare the object. (e.g. Vertex, Road class)

## Key algorithms and design elements
The adjacency list is stored the coordination in bidirectional as undirected graph which
make the program easier to write and execute but not space friendly as the memory used twice.

After user provide the location in navigate(), the program uses Dijkstra's algorithm to find shortest path from one location to another.
The Dijkstra's algorithm is using to find the shortest path from single vertex, by building the minimum distance from the source vertex.
1. Initialize the distance of source vertex to 0 and other vertex to infinite (in Java, Integer.MAX_VALUE).
2. Start at source vertex and calculate distance to connected vertex.
3. Pick next vertex with minimal distance and repeat the connected vertex distance calculation.
4. Continue until all vertex is visited and resulting in finding the shortest path from the source vertex.

Printing the path through the recursive method to track down all the shortest path from one vertex to another.

## Limitations
* The current design is limited to a road in straight line.
* Road and Vertex is immutable object (after created, can't be changed). This design would be sufficient for simple application, 
but not in complex application (e.g. the road is fixed and need alternative).

## References
* Rajan, H. Printing Paths in Dijkstra’s Shortest Path Algorithm [source code]. https://www.geeksforgeeks.org/printing-paths-dijkstras-shortest-path-algorithm/
* Saurel, S. (2016) Calculate shortest paths in Java by implementing Dijkstra’s Algorithm [source code]. https://medium.com/@ssaurel/calculate-shortest-paths-in-java-by-implementing-dijkstras-algorithm-5c1db06b6541
