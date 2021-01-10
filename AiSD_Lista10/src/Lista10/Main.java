package Lista10;

import java.util.Random;

public class Main {

    static void stworzKrawedzieRandom(Graph graph, int liczba){
        Random rand = new Random();
        for(int i=0; i<liczba; i++){
            graph.addEdge(rand.nextInt(20)+1,rand.nextInt(20)+1,rand.nextInt(10)+1);
        }
    }

    public static void main(String[] args) {

        System.out.println();
        System.out.println("----------------- Zadanie 1. ... -----------------");

        int liczbElZad1 = 20;

        System.out.println();
        System.out.println("----------------- Dodawanie " + liczbElZad1 + " elementow ... -----------------");

        Graph graphZad1 = new Graph();
        stworzKrawedzieRandom(graphZad1,liczbElZad1);

        System.out.println();
        System.out.println("----------------- Lista sąsiedztwa ... -----------------");
        Lista_sasiedztwa lista_sasiedztwa = new Lista_sasiedztwa(graphZad1);
        System.out.println();
        System.out.println("----------------- Lista krawędzi ... -----------------");
        Lista_krawedzi lista_krawedzi = new Lista_krawedzi(graphZad1);
        System.out.println();
        System.out.println("----------------- Macierz sąsiedztwa ... -----------------");
        Macierz_sasiedztwa macierz_sasiedztwa = new Macierz_sasiedztwa(graphZad1);

        System.out.println();
        System.out.println("----------------- Algorytm Dijkstra ... -----------------");
        int vertices = 8;
        Dijkstra graph2 = new Dijkstra(vertices);
        graph2.addEdge(0, 3, 9);
        graph2.addEdge(0, 5, 5);
        graph2.addEdge(0, 2, 6);
        graph2.addEdge(0, 6, 2);
        graph2.addEdge(0, 7, 3);
        graph2.addEdge(2, 6, 6);
        graph2.addEdge(2, 4, 1);
        graph2.addEdge(2, 7, 8);
        graph2.addEdge(1, 6, 9);
        graph2.addEdge(1, 7, 4);
        graph2.addEdge(1, 4, 5);
        graph2.dijkstra_GetMinDistances();

        System.out.println();
        System.out.println("----------------- Algorytm Kruskala ... -----------------");
        vertices = 8;
        Kruskal graph = new Kruskal(vertices);
        graph.addEdge(0, 3, 9);
        graph.addEdge(0, 5, 5);
        graph.addEdge(0, 2, 6);
        graph.addEdge(0, 6, 2);
        graph.addEdge(0, 7, 3);
        graph.addEdge(2, 6, 6);
        graph.addEdge(2, 4, 1);
        graph.addEdge(2, 7, 8);
        graph.addEdge(1, 6, 9);
        graph.addEdge(1, 7, 4);
        graph.addEdge(1, 4, 5);
        graph.kruskalMST(false);

         KruskalTester krusTest = new KruskalTester();

         krusTest.rozpocznij();



    }
}
