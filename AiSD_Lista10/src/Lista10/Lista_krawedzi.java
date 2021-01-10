package Lista10;

import java.util.ArrayList;

public class Lista_krawedzi {

    int n, m;
    ArrayList<Edge> edgeArray;

    Lista_krawedzi(Graph graph) {
        this.n = graph.getEdgeAmmount();
        this.edgeArray = graph.getAllEdges();
        wypisz_Liste();
    }

    void wypisz_Liste(){
        for(int i=0; i<n; i++){
            System.out.print(edgeArray.get(i).getSource().getValue() + " -> " + edgeArray.get(i).getDestination().getValue() + " - waga: " + edgeArray.get(i).getWeight());
            System.out.println();
        }
    }

}
