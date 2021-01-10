package Lista10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Kruskal {

    int vertices;
    ArrayList<Edge> allEdges = new ArrayList<>();

    Kruskal(int vertices) {
        this.vertices = vertices;   // wierzchołki
    }

    public void addEdge (int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        allEdges.add(edge); //dodajemy wszystkie krawedzie do listy krawedzi
    }

    public long kruskalMST(boolean test){
        long czasRozpoczecia, czasZakonczenia, czasTrwania;
        PriorityQueue<Edge> pQueue = new PriorityQueue<>(allEdges.size(), Comparator.comparingInt(o -> o.weight));

        czasRozpoczecia = System.nanoTime();

        //dodaje wszystkie krawędzie do kolejki priorytetowej, są one posortowane wedlug wagi
        for (int i = 0; i <allEdges.size() ; i++) {
            pQueue.add(allEdges.get(i));
        }

        int [] parent = new int[vertices];
        makeSet(parent); // wypelnianie tablicy rodzicow jej indeksami

        ArrayList<Edge> mst = new ArrayList<>();

        int index = 0;
        while(index<vertices-1 && !pQueue.isEmpty()){
            Edge edge = pQueue.remove();
            int x_set = find(parent, edge.source);
            int y_set = find(parent, edge.destination);

            if(x_set==y_set){
                //cykl jest juz stworzony w naszym drzewie dlatego pomijamy
            }else {
                //dodaje krawedz do minimalnego grafu, poniewaz nie istnieje jeszcze takie polaczenie
                mst.add(edge);
                index++;
                union(parent,x_set,y_set);
            }
        }

        czasZakonczenia = System.nanoTime();
        czasTrwania = czasZakonczenia - czasRozpoczecia;

        //wydruk
        if(!test){
            printGraph(mst);
        }

        return czasTrwania;
    }

    public void makeSet(int [] parent){
        //Make set- tworzę nowy element z nadrzędnym wskaźnikiem do siebie.
        for (int i = 0; i <vertices ; i++) {
            parent[i] = i;
        }
    }

    public int find(int [] parent, int vertex){
        //łańcuch wskaźników macierzystych od x w górę przez drzewo
        // aż do osiągnięcia elementu, którego rodzic jest sam
        if(parent[vertex]!=vertex)
            return find(parent, parent[vertex]);;
        return vertex;
    }

    public void union(int [] parent, int x, int y){
        int x_set_parent = find(parent, x);
        int y_set_parent = find(parent, y);
        //zrób x jako rodzic y
        parent[y_set_parent] = x_set_parent;
    }

    public void printGraph(ArrayList<Edge> edgeList){
        for (int i = 0; i <edgeList.size() ; i++) {
            Edge edge = edgeList.get(i);
            System.out.println("Krawedz nr." + i + " początek: " + edge.source +
                    " koniec: " + edge.destination +
                    " waga: " + edge.weight);
        }
    }
    class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

}
