package org.datastructures.graph;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Edge {
    private Vertex start;
    private Vertex end;
    private Integer weight;

    public Edge(Vertex startVertex, Vertex endVertex, Integer inputWeight) {
        this.start = startVertex;
        this.end = endVertex;
        this.weight = inputWeight;
    }
}