package Lista10;

import java.util.ArrayList;

public class Graph {

    ArrayList<Vertex> allVertex = new ArrayList<>();
    ArrayList<Edge> allEdges = new ArrayList<>();

    public void addVertex(int value){
        Vertex vertex = new Vertex(value);
        allVertex.add(vertex);
    }

    public void addEdge(int valueSource, int valueDestination, int weight){
        int searchSource = -1;
        int searchDest = -1;
        boolean boolSource = false;
        boolean boolDest = false;
        for(int i = 0; i<allVertex.size(); i++){
            if (allVertex.get(i).getValue() == valueSource){
                searchSource = i;
                boolSource = true;
            }
            if (allVertex.get(i).getValue() == valueDestination){
                searchDest = i;
                boolDest = true;
            }
            if(boolDest && boolSource) break;
        }
        if(!boolSource){
            Vertex newSource = new Vertex(valueSource);
            allVertex.add(newSource);
            searchSource = allVertex.size()-1;
        }
        if(!boolDest){
            Vertex newDest = new Vertex(valueDestination);
            allVertex.add(newDest);
            searchDest = allVertex.size()-1;
        }
        addEdge(allVertex.get(searchSource),allVertex.get(searchDest),weight);
    }

    private void addEdge(Vertex source, Vertex destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        allEdges.add(edge); //add to total edges
    }

    int getVertexAmmount(){
        return allVertex.size();
    }

    int getEdgeAmmount(){
        return allEdges.size();
    }

    public ArrayList<Vertex> getAllVertex() {
        return allVertex;
    }

    public void setAllVertex(ArrayList<Vertex> allVertex) {
        this.allVertex = allVertex;
    }

    public ArrayList<Edge> getAllEdges() {
        return allEdges;
    }

    public void setAllEdges(ArrayList<Edge> allEdges) {
        this.allEdges = allEdges;
    }
}
