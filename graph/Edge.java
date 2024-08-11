package graph;

public class Edge {
    private Vertex start;
    private Vertex end;
    private Integer weight;
    
    public Edge(Vertex satVertex,Vertex endVertex,Integer wInteger){
        this.start=satVertex;
        this.end=endVertex;
        this.weight=wInteger;
    }

    public Vertex getStart(){
        return this.start;
    }

    public Vertex getEnd(){
        return this.end;
    }

    public Integer getWeight(){
        return this.weight;
    }

}
