package org.datastructures.graph;

import java.util.ArrayList;

// A Graph is basically a collection of vertices and edges.
// It only needs to track the list of vertices.
public class Graph {
    private ArrayList<Vertex> vertices;
    private boolean isWeighted;
    private boolean isDirected;

    public Graph() {
        this.vertices = new ArrayList<>();
    }

    public Vertex addVertex(String data) {
        Vertex newVertex = new Vertex(data);
        this.vertices.add(newVertex);
        return newVertex;
    }

    public void removeVertex(Vertex vertexToRemove) {
        this.vertices.remove(vertexToRemove);
    }
}
