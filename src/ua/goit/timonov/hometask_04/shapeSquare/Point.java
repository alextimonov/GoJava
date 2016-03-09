package ua.goit.timonov.hometask_04.shapeSquare;

/**
 * Class Points stores coordinates (x, y) of point on the plane,
 * with method that finds distance to other point
 */
public class Point {
    /** Coordinate X of this point */
    private double x;
    /** Coordinate Y of this point */
    private double y;

    /**
     * Constructs the Point by two given coordinates (x, y)
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /* ============ Getters & setters =========== */
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

    /**
     * Finds distance between this Point and given otherPoint
     */
    public double findDistance(Point otherPoint) {
        double dx = x - otherPoint.getX();
        double dy = y - otherPoint.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }
}
