package Lista10;

import java.util.ArrayList;

public class Macierz_sasiedztwa {

    int EdgeAmmount, VertexAmmount;
    int[][] array;
    ArrayList<Edge> edgeArray;
    ArrayList<Vertex> vertexArray;
    QuickSort quickSort = new QuickSort();


    Macierz_sasiedztwa(Graph graph) {
        this.EdgeAmmount = graph.getEdgeAmmount();
        this.VertexAmmount = graph.getVertexAmmount();
        this.edgeArray = graph.getAllEdges();
        this.vertexArray = quickSort.sort(graph.getAllVertex());
        getMacierz();
        wypisz_macierz();
    }

    void getMacierz() {
        array = new int[VertexAmmount + 1][VertexAmmount + 1];

        for (int i = 1; i < array.length; i++) {
            array[0][i] = vertexArray.get(i - 1).getValue();
        }

        for (int i = 1; i < array.length; i++) {
            array[i][0] = vertexArray.get(i - 1).getValue();
        }

        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                for (int k = 0; k < edgeArray.size(); k++) {
                    if (edgeArray.get(k).getSource().getValue() == array[i][0]) {
                        if (edgeArray.get(k).getDestination().getValue() == array[0][j]) {
                            array[i][j] = 1;
                        }
                    }
                }
            }
        }
    }

    void wypisz_macierz() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print("\t" + array[i][j]);
            }
            System.out.println();
        }
    }

}