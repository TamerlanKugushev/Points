package model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Point implements Comparable<Point> {
    private double x;
    private double y;

    public Point() {
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Point sum(Point other) {
        return new Point(this.x + other.x, this.y + other.y);
    }

    public Point multiple(double n) {
        return new Point(this.x * n, this.y * n);
    }

    public Point divizion(double n) {
        return new Point(this.x / n, this.y / n);
    }

    public double dist() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public double dist(Point other) {
        return Math.sqrt(Math.pow((other.x - this.x), 2) + Math.pow((other.y - this.y), 2));
    }

    /**
     * Для нахождения периметра треугольника напишите отдельный метод double Perimeter(Point other1, Point other2)
     * ,возвращающий периметр между тремя данными точками.
     */
    public double perimeter(Point other1, Point other2) {
        return this.dist(other1) + this.dist(other2) + other1.dist(other2);
    }

    /**
     * Для нахождения площади треугольника напишите отдельный метод double Area(Point other1, Point other2).
     */
    public double area(Point other1, Point other2) {
        double p = (this.perimeter(other1, other2)) / 2;
        return Math.sqrt(p * (p - this.dist(other1)) * (p - this.dist(other2)) * (p - other1.dist(other2)));
    }

    @Override
    public int compareTo(Point o) {
        return Double.compare(this.dist(), o.dist());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "(" + x + "; " + y + ')';
    }

    /**
     * A: Самая дальняя точка(maxDistPoint)
     * Вычислить точку, наиболее удаленную от начала координат.
     * Для решения этой задачи напишите и используйте дополнительный метод dist,
     * который возвращает расстояние от точки до начала координат.
     * Если таких точек несколько, то вернуть последнюю, удовлетворяющую условиям задачи
     */
    public static Point maxDistPoint(Point[] points) {
        double max = 0;
        Point maxPoint = null;
        for (int i = 0; i < points.length; i++) {
            if (points[i].dist() > max) {
                max = points[i].dist();
                maxPoint = points[i];
            }
        }
        return maxPoint;
    }

    /**
     * Центр масс(centerMass)
     * Вычислите точку, являющуюся центом масс данного множества точек,
     * т.е. точку, которая имеет в качестве своих координат среднее арифметическое по х и у.
     */
    public static Point centerMass(Point[] points) {
        double x = 0;
        double y = 0;
        for (int i = 0; i < points.length; i++) {
            x += points[i].x;
            y += points[i].y;
        }
        return new Point(x / points.length, y / points.length);
    }

    /**
     * E: Максимальный периметр(maxPerimetr)
     * Среди данных точек найдите три точки,
     * образующие треугольник с наибольшим периметром. Выведите данный периметр.
     * Для нахождения периметра треугольника напишите отдельный метод double Perimeter(Point other1, Point other2),
     * возвращающий периметр между тремя данными точками.
     */

    public static double maxPerimetr(Point[] points) {
        double maxPerimeter = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    double tmpPerimeter = points[i].perimeter(points[j], points[k]);
                    if (tmpPerimeter > maxPerimeter) {
                        maxPerimeter = tmpPerimeter;
                    }
                }
            }
        }
        return maxPerimeter;
    }

    /**
     * F: Максимальная площадь(maxArea)
     * Среди данных точек найдите три точки, образующие треугольник с наибольшей площадью.
     * Выведите данную площадь.
     * Для нахождения площади треугольника напишите отдельный метод double Area(Point other1, Point other2).
     */
    public static double maxArea(Point[] points) {
        double maxArea = 0;
        for (int i = 0; i < points.length - 2; i++) {
            for (int j = i + 1; j < points.length - 1; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    double tmpArea = points[i].area(points[j], points[k]);
                    if (tmpArea > maxArea) {
                        maxArea = tmpArea;
                    }
                }
            }
        }
        return maxArea;
    }

    public static void sort(Point[] points, Comparator<Point> comparator) {
        Arrays.sort(points, comparator);
    }


}
