package Lista7;

public class Tester {
    public void wykonanieTestu() {
        System.out.println("Dla 100k");
        binarnyTest(100000);
        System.out.println("\n\nDla 250k");
        binarnyTest(250000);
        System.out.println("\n\nDla 500k");
        binarnyTest(500000);
        System.out.println("\n\nDla 1kk");
        binarnyTest(1000000);
        System.out.println("\n\nDla 2kk");
        binarnyTest(2000000);
        System.out.println("\n\nDla 3kk");
        binarnyTest(3000000);
        System.out.println("\n\nDla 4kk");
        binarnyTest(4000000);
        System.out.println("\n\nDla 5kk");
        binarnyTest(5000000);
        System.out.println("\n\nDla 6kk");
        binarnyTest(6000000);
        System.out.println("\n\nDla 7kk");
        binarnyTest(7000000);
        System.out.println("\n\nDla 8kk");
        binarnyTest(8000000);
        System.out.println("\n\nDla 9kk");
        binarnyTest(9000000);
        System.out.println("\n\nDla 10kk");
        binarnyTest(10000000);
        System.out.println("\n\nDla 100kk");
        binarnyTest(100000000);
    }

    public void binarnyTest(int liczbaEl) {
        int[] tab = new int[liczbaEl];
        for (int i = 0; i < liczbaEl; i++) {
            tab[i] = i + 1;
        }
        long sredniBinarny = 0;
        long sredniBinarnyUl = 0;
        long sredniLiniowy = 0;
        long czasRozpoczecia, czasZakonczenia, czasTrwania;
        BinarySearch search = new BinarySearch();
        BinarySearchUpgrade searchV2 = new BinarySearchUpgrade();
        LinearSearch searchLinear = new LinearSearch();
        for (int i = 0; i < 100000; i++) {
            czasRozpoczecia = System.nanoTime();
            search.binarySearch(tab, 12345);
            czasZakonczenia = System.nanoTime();
            czasTrwania = czasZakonczenia - czasRozpoczecia;
            sredniBinarny = sredniBinarny + czasTrwania;

            czasRozpoczecia = System.nanoTime();
            searchV2.binarySearchUpgrade(tab, 12345);
            czasZakonczenia = System.nanoTime();
            czasTrwania = czasZakonczenia - czasRozpoczecia;
            sredniBinarnyUl = sredniBinarnyUl + czasTrwania;

            czasRozpoczecia = System.nanoTime();
            searchLinear.linearSearch(tab, 12345);
            czasZakonczenia = System.nanoTime();
            czasTrwania = czasZakonczenia - czasRozpoczecia;
            sredniLiniowy = sredniLiniowy + czasTrwania;
        }
        sredniBinarny = sredniBinarny / 100000;
        sredniBinarnyUl = sredniBinarnyUl / 100000;
        sredniLiniowy = sredniLiniowy / 100000;
        System.out.println("Sredni czas dla liniowego: " + sredniLiniowy);
        System.out.println("Srednie czasy dla binarnego: " + sredniBinarny);
        System.out.println("Sredni czas dla binarnegoUlepszonego: " + sredniBinarnyUl);
    }
}
