package tgraph.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class Graph {
    private int xLength;
    private int yLength;
    private HashMap<String, Point> pointMap;
    private TreeMap<Integer, Line> lineMap;

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
        System.out.println("  " + "12345");
    }

    private void createLineMap() {
        this.lineMap = new TreeMap<>(Collections.reverseOrder());
        for (Point point : pointMap.values()) {
            this.lineMap.put(point.getY(), new Line('*', point.getX()));
        }

        int remainingLines = this.xLength - this.lineMap.size();
        int order = 1;

        for (int i = 0; i < remainingLines; i++) {
            while (this.lineMap.containsKey(order)) {
                order++;
            }
            this.lineMap.put(order, new Line(' ', order));
        }

    }

    public record Line(char c, int x) {
        public String getAsString() {
            String result = "";

            for (int i = 1; i < x; i++) {
                result += " ";
            }

            return result + c;
        }
    }

}
