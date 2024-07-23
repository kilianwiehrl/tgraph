package tgraph.model;

import java.util.HashMap;
import java.util.List;

public class Graph {
    private int xLength;
    private int yLength;
    private HashMap<String, Point> pointMap;
    private HashMap<String, Line> lineMap;

    public Graph(int xLength, int yLength) {
        this.xLength = xLength;
        this.yLength = yLength;
        this.pointMap = new HashMap<>();
    }

    public void add(Point point) {
        if (!this.pointMap.containsKey(point.toStringP()))
            this.pointMap.put(point.toStringP(), point);
    }

    public void draw() {
        System.out.println("Y");
        System.out.println("^");

        this.createLineMap();
        int counter = this.yLength;
        for (Line line : this.lineMap.values()) {
            System.out.println(Integer.toString(counter) + '|' + line.getAsString());
            counter--;
        }

        System.out.println(" 0-----> X");
        System.out.println("  12345");
    }

    private void createLineMap() {
        this.lineMap = new HashMap();
        for (Point point : pointMap.values()) {
            this.lineMap.put(Integer.toString(point.getY()), new Line('*', point.getX()));
        }

        int remainingLines = this.xLength - this.lineMap.size();
        int order = 1;

        for (int i = 0; i < remainingLines; i++) {
            while (this.lineMap.containsKey(Integer.toString(order))) {
                order++;
            }
            this.lineMap.put(Integer.toString(order), new Line(' ', order));
        }

    }

    public record Line(char c, int x) {
        public String getAsString() {
            String result = "";

            for (int i = 0; i < x; i++) {
                result += " ";
            }

            return result + c;
        }
    }

}
