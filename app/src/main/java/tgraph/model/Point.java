package tgraph.model;

public class Point {
    private int x;
    private int y;

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public String toStringP(){
        return(this.x + "," + this.y);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
