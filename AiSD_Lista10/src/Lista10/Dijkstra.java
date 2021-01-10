package Lista10;

import javafx.util.Pair;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeSet;

public class Dijkstra {


    class PairComparator implements Comparator<Pair<Integer, Integer>> {
        @Override
        public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
            //sortuje używając wartości odległości
            int key1 = o1.getKey();
            int key2 = o2.getKey();
            return key1 - key2;
        }
    }

    int vertices;

    LinkedList<Edge>[] adjacencylist;

    Dijkstra(int vertices) {
        this.vertices = vertices;
        adjacencylist = new LinkedList[vertices];
        //tworzy liste mozliwych polaczen w grafie, do ktorych bedzie liczyc odleglosc
        for (int i = 0; i < vertices; i++) {
            adjacencylist[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        adjacencylist[source].addFirst(edge);

        edge = new Edge(destination, source, weight);
        adjacencylist[destination].addFirst(edge);
    }

    public void dijkstra_GetMinDistances() {
        boolean[] inSPT = new boolean[vertices];  // tablica sprawdzajaca czy jest juz najkrotsza sciezka
        int[] distance = new int[vertices]; //tablica odległości wierzchołka od źródła
        for (int i = 0; i < vertices; i++) {
            distance[i] = Integer.MAX_VALUE;  //przypisujemy wartosci odleglosci calej tablicy jako nieskoncznosci
        }
        TreeSet treeSet = new TreeSet<>(new PairComparator());
        distance[0] = 0;
        Pair<Integer, Integer> p0 = new Pair<>(distance[0], 0);  // tworzymy odlgeglosc zrodla do zrodla czyli 0
        treeSet.add(p0);

        while (!treeSet.isEmpty()) {

            Pair<Integer, Integer> extractedPair = (Pair<Integer, Integer>) treeSet.pollFirst(); //pobieramy z drzewa parę z najmniejszą wagą przejścia

            int extractedVertex = extractedPair.getValue();
            if (inSPT[extractedVertex] == false) {   //sprawdzamy czy dany wierzcholek zostal juz sprawdzony i jest z najmniejszym dystansem
                inSPT[extractedVertex] = true;

                LinkedList<Edge> list = adjacencylist[extractedVertex];  // adjacencylist - lista sasiedztwa
                for (int i = 0; i < list.size(); i++) { // przechodzimy po wszystkich sasiednich wierzcholkach i aktualizuje klucze
                    Edge edge = list.get(i);
                    int destination = edge.destination;
                    if (inSPT[destination] == false) {   //tylko, jeśli miejsce docelowe krawędzi nie jest obecne w tablicy bool
                        // sprawdza czy odleglosc od zrodla do celu, ktora jest juz wpisana jest mniejsza czy wieksza, jesli mniejsza to aktualizuje jej wartosci
                        int newKey = distance[extractedVertex] + edge.weight;
                        int currentKey = distance[destination];
                        if (currentKey > newKey) {
                            Pair<Integer, Integer> p = new Pair<>(newKey, destination);
                            treeSet.add(p);
                            distance[destination] = newKey;
                        }
                    }
                }
            }
        }
        //wydrukuj
        printDijkstra(distance);
    }

    public void printDijkstra(int[] distance) {
        for (int i = 0; i < vertices; i++) {
            System.out.println("Poczatek: " + "0" + " koniec: " + i + " odleglosc (suma wag): " + distance[i]);
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

