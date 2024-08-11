package graph;

import java.util.ArrayList;

public class Graph {
    
    private ArrayList<Vertex> vertices;
    private boolean isWeighted;
    private boolean isDirected;

    public Graph(boolean inputisWeighted,boolean inputisDirected){
        this.vertices=new ArrayList<Vertex>();
        this.isWeighted=inputisWeighted;
        this.isDirected=inputisDirected;
    }

    public Vertex addVertex(String data){
        Vertex newVertex= new Vertex(data);
        this.vertices.add(newVertex);
        return newVertex;
    }

    public void addEdge(Vertex vertex1,Vertex vertex2,Integer weight){
     if(!this.isWeighted){
        weight=null;
     }
     vertex1.addEdge(vertex2, weight);
    }
}
