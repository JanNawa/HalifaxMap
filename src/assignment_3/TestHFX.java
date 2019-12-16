package assignment_3;

/**
 *
 * @author Jan
 */
public class TestHFX {
    public static void main(String[] args) {
        HalifaxMap hm = new HalifaxMap();
        System.out.println(hm.newIntersection(0, 0));
        System.out.println(hm.newIntersection(2, 2));
        System.out.println(hm.newIntersection(2, 2));
        System.out.println(hm.newIntersection(2, -5));
        System.out.println(hm.newIntersection(-4, -1));
        System.out.println(hm.newIntersection(-5, -5));
        hm.defineRoad(0,0,2,2); // both existing intersections
        hm.defineRoad(2,-5,-3,-3); // first - existing, second - new
        hm.defineRoad(-3, -3, -4, -1); // first - new, second - existing
        hm.defineRoad(0, 0, 2, -2);
        System.out.println("existing road: " + hm.defineRoad(0, 0, 2, -2));
        System.out.println("new road: " + hm.defineRoad(0, 0, 4, -1));
        ;
        hm.defineRoad(0, 0, -3, -3);
        hm.defineRoad(-3, -3, 4, -1);
        hm.defineRoad(-3, -3, 3, -3);
        hm.defineRoad(2, 2, 4, -1);
        hm.defineRoad(3, -3, 2, -5);
        hm.defineRoad(4, -1, 3, -3);

        hm.navigate(0, 0, 5, 5);
        hm.navigate(5, 5, 0, 0);
        hm.navigate(10, 10, 10, 10);
        hm.navigate(0, 0, -5, -5);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
        hm.navigate(0, 0, 0, 0);
        System.out.println("=====");
        hm.navigate(0, 0, 2, -5);
        System.out.println("=====");
        hm.navigate(0, 0, -4, -1);
        System.out.println("=====");
        hm.navigate(0, 0, 4, -1);
        System.out.println("=====");
        hm.navigate(2, -2, 2, -5);
    }
}
