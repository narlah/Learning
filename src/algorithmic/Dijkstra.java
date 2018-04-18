package algorithmic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Vertex implements Comparable<Vertex> {
    public final String name;
    Edge[] adjacencies;
    double minDistance = Double.POSITIVE_INFINITY;
    Vertex previous;

    Vertex(String argName) {
        name = argName;
    }

    public String toString() {
        return name;
    }

    public int compareTo(Vertex other) {
        return Double.compare(minDistance, other.minDistance);
    }
}

class Edge {
    final Vertex target;
    final double weight;

    Edge(Vertex argTarget, double argWeight) {
        target = argTarget;
        weight = argWeight;
    }
}

public class Dijkstra {
    private static void computePaths(Vertex source) {
        source.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            Vertex u = vertexQueue.poll();

            // Visit each edge exiting u
            for (Edge e : u.adjacencies) {
                Vertex v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
                if (distanceThroughU < v.minDistance) {
                    vertexQueue.remove(v);
                    v.minDistance = distanceThroughU;
                    v.previous = u;
                    vertexQueue.add(v);
                }
            }
        }
    }

    private static List<Vertex> getShortestPathTo(Vertex target) {
        List<Vertex> path = new ArrayList<>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {

        Vertex v0 = new Vertex("start");
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("end");
        Vertex v6 = new Vertex("test");

        v0.adjacencies = new Edge[]{new Edge(v1, 7), new Edge(v2, 9), new Edge(v3, 14)};
        v1.adjacencies = new Edge[]{new Edge(v0, 7), new Edge(v2, 10), new Edge(v4, 15)};
        v2.adjacencies = new Edge[]{new Edge(v0, 9), new Edge(v1, 10), new Edge(v4, 11), new Edge(v3, 2)};
        v3.adjacencies = new Edge[]{new Edge(v0, 14), new Edge(v2, 2), new Edge(v5, 17)};
        v4.adjacencies = new Edge[]{new Edge(v1, 15), new Edge(v2, 11), new Edge(v6, 6)};
        v5.adjacencies = new Edge[]{new Edge(v3, 17), new Edge(v6, 6)};
        v6.adjacencies = new Edge[]{new Edge(v5, 2), new Edge(v4, 6)};
        //Vertex[] vertices = { v0, v1, v2, v3, v4, v5 };
        computePaths(v0);
        System.out.println("Distance to " + v5 + ": " + v5.minDistance);
        System.out.println("Path: " + getShortestPathTo(v5));
        //		for (Vertex v : vertices) {
        //			System.out.println("Distance to " + v + ": " + v.minDistance);
        //			List<Vertex> path = getShortestPathTo(v);
        //			System.out.println("Path: " + path);
        //}
    }
}