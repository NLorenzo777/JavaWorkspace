package org.datastructures.graph;

import java.util.ArrayList;
import java.util.Objects;

// A Graph is basically a collection of vertices and edges.
// It only needs to track the list of vertices.
public class Graph {
    private ArrayList<Vertex> vertices;
    private boolean isWeighted;
    private boolean isDirected;

    public Graph(boolean inputIsWeighted, boolean inputIsDirected) {
        this.vertices = new ArrayList<>();
        this.isWeighted = inputIsWeighted;
        this.isDirected = inputIsDirected;
    }

    public Vertex addVertex(String data) {
        Vertex newVertex = new Vertex(data);
        this.vertices.add(newVertex);
        return newVertex;
    }

    public void removeVertex(Vertex vertexToRemove) {
        this.vertices.remove(vertexToRemove);
    }

    public void addEdge(Vertex vertex1, Vertex vertex2, Integer weight) {
        if (!this.isWeighted) {
            weight = null;
        }
        if (this.isDirected) {
            vertex1.addEdge(vertex2, weight);
            return;
        }
        vertex2.addEdge(vertex1, weight);
    }

    public void removeEdge(Vertex vertex1, Vertex vertex2) {
        if (!this.isDirected) {
            vertex2.removeEdge(vertex1);
        }
        vertex1.removeEdge(vertex2);
    }

    public Vertex getVertexByValue(String value) {
        for(Vertex v: this.vertices) {
            if (Objects.equals(v.getData(), value)) {
                return v;
            }
        }

        return null;
    }

    public void print() {
        for(Vertex v: this.vertices) {
            v.print(isWeighted);
        }
    }

}
