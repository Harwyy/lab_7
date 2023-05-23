package DataFromTask;

public class Coordinates {

    private Integer x;
    private double y;

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Coordinates(Integer x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        String tab = "    ".repeat(2);
        return "\n"
                + tab + "X: " + x + "\n"
                + tab + "Y: " + y;
    }
}
