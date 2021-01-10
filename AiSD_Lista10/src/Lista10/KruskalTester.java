package Lista10;

import java.util.Random;

public class KruskalTester {



    void stworzTest(int vertices, int liczbaProb) {
        long czasLaczny = 0;
        for (int i = 0; i < liczbaProb; i++) {
            Kruskal graph = new Kruskal(vertices);
            Random rand = new Random();
            for (int j = 0; j < vertices; j++) {
                graph.addEdge(rand.nextInt(vertices), rand.nextInt(vertices), rand.nextInt(30));
            }
            czasLaczny += graph.kruskalMST(true);
        }
        System.out.println(czasLaczny / liczbaProb);
    }

    void rozpocznij(){
        System.out.println();
        System.out.println("----------------- Test zlozonosci algorytmu Kruskala [ns] ... -----------------");
        stworzTest(1,1);
        stworzTest(500,1000);
        stworzTest(1000,1000);
        stworzTest(1500,1000);
        stworzTest(2000,1000);
        stworzTest(2500,1000);
        stworzTest(3000,1000);
        stworzTest(3500,1000);
        stworzTest(4000,1000);
    }

}
