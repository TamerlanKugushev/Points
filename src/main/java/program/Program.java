package program;

import model.Point;

import java.util.Arrays;
import java.util.Comparator;

public class Program {
    public static void main(String[] args) {
        Point point1 = new Point(0, 0);
        Point point4 = new Point(4, 4);
        Point point5 = new Point(5, 5);
        Point point6 = new Point(6, 6);
        Point[] points = {point1, point4, point5, point6};
        System.out.println(Arrays.toString(points));
        Point.sort(points, null);
        System.out.println(Arrays.toString(points));
        Point.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return -o1.compareTo(o2);
            }
        });
        System.out.println(Arrays.toString(points));


    }
}
