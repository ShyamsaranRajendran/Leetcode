package graph;
import java.util.*;
public class Vertex {
    
    private String data;
    private ArrayList<Edge> edges;

    public Vertex(String inputData){
        this.data= inputData;
        this.edges= new ArrayList<Edge>();
    }

    public void addEdge(Vertex endVertex, Integer weight){
        this.edges.add(new Edge(this,endVertex,weight));
    }

    public void removeEdge(Vertex endVertex){
        this.edges.removeIf(edge -> edge.getEnd().equals(endVertex));
    }
    public String getData(){
        return this.data;
    }
    public ArrayList<Edge> getEdges(){
        return this.edges;
    }
    public void print(boolean showWeight){
        String Message = "";

        if(this.edges.size()==0){
            System.out.println(this.data + "-->");
            return ;
        }
        for(int i=0;i<this.edges.size();i++)
        {
            if(i==0){
                Message += this.edges.get(i).getStart().data + " --> ";
            }
            Message+=this.edges.get(i).getEnd().data;

            if(showWeight){
                Message+="( " + this.edges.get(i).getWeight() + ")";
            }

            if(i != this.edges.size()-1){
                Message += ", ";
            }
        }
    }
}
