/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package tgraph;

import tgraph.model.Graph;
import tgraph.model.Point;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());

        Graph graph = new Graph(5,5);
        graph.add(new Point(2, 3));
        graph.add(new Point(1, 5));
        graph.draw();
    }
}
