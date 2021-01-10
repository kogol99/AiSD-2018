package Lista10;

import java.util.ArrayList;

public class Lista_sasiedztwa {

    int n, m;
    ArrayList<Edge> edgeArray;
    ArrayList<Vertex> vertexArray;
    QuickSort quickSort = new QuickSort();

    Lista_sasiedztwa(Graph graph) {
        this.n = graph.getEdgeAmmount();
        this.m = graph.getVertexAmmount();
        this.edgeArray = graph.getAllEdges();
        this.vertexArray = quickSort.sort(graph.getAllVertex());
        wypisz_Liste();
    }

    void wypisz_Liste(){
        for(int i=0; i<m; i++){
            System.out.print(vertexArray.get(i).getValue() + ": ");
            for(int j=0; j<n; j++){
                if(edgeArray.get(j).getSource().getValue() == vertexArray.get(i).getValue()){
                    System.out.print(edgeArray.get(j).getDestination().getValue() + "(" + edgeArray.get(i).getWeight() + ") ");
                }
            }
            System.out.println();
        }
    }

}
