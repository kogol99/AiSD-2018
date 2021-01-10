package Lista7;

import java.util.Comparator;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws DuplicateElementException {
        System.out.println("----------------- Test pod porownanie ... -----------------");
        Tester test = new Tester();
        test.wykonanieTestu();



        int[] list = new int[10000000];
        int zakresLiczb = 10000000;
        long czasRozpoczecia, czasZakonczenia, czasTrwania;
        Random rand = new Random();
        for(int i=0; i<list.length; i++){
            list[i]= rand.nextInt(zakresLiczb);
        }
        BinarySearch search = new BinarySearch();
        BinarySearchUpgrade searchV2 = new BinarySearchUpgrade();
        LinearSearch searchLinear = new LinearSearch();
        QuickSort sort = new QuickSort();
         list = sort.sort(list);

        int wyszukiwanaLiczba = rand.nextInt(zakresLiczb);

        System.out.println();
        System.out.println("----------------- Wyszukiwanie ... -----------------");
        czasRozpoczecia = System.nanoTime();
        System.out.println("Index: " + search.binarySearch(list, 9999997));
        czasZakonczenia = System.nanoTime();
        czasTrwania = czasZakonczenia - czasRozpoczecia;
        System.out.println("Czas trwania wyszukiwania binarnego: " + czasTrwania);

        System.out.println();
        System.out.println("----------------- Wyszukiwanie ... -----------------");
        czasRozpoczecia = System.nanoTime();
        System.out.println("Index: " + searchV2.binarySearchUpgrade(list, 9999997));
        czasZakonczenia = System.nanoTime();
        czasTrwania = czasZakonczenia - czasRozpoczecia;
        System.out.println("Czas trwania wyszukiwania 'ulepszonego' binarnego: " + czasTrwania);

        System.out.println();
        System.out.println("----------------- Wyszukiwanie ... -----------------");
        czasRozpoczecia = System.nanoTime();
        System.out.println("Index: " + searchLinear.linearSearch(list, 9999997));
        czasZakonczenia = System.nanoTime();
        czasTrwania = czasZakonczenia - czasRozpoczecia;
        System.out.println("Czas trwania wyszukiwania liniowego: " + czasTrwania);

        BinarySearchTree<Element> tree = new BinarySearchTree<Element>(new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                if(o1.getValue() > o2.getValue()) return 1;
                if(o1.getValue() < o2.getValue()) return -1;
                return 0;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });

        Element elementdoUsuniecia= new Element(10,"blue",20);
        Element elemendoZnalezienia= new Element(43,"red",39);

        System.out.println();
        System.out.println("----------------- Zadanie 3 ... -----------------");
        try {
            System.out.println("Dodawanie elementu 1... ");
            tree.insert(new Element(29,"green",321));
            System.out.println("Dodawanie elementu 2... ");
            tree.insert(elemendoZnalezienia);
            System.out.println("Dodawanie elementu 3... ");
            tree.insert(elementdoUsuniecia);
            tree.insert(new Element(10,"gray",21));
        } catch(DuplicateElementException e){
            System.out.println("Blad! Element nie zostal dodany");
        }
        System.out.println();

        // wyswietlanie //
        System.out.println("Wyswietlanie wszystkich elementów... ");
        ElementToStringExec exec=new ElementToStringExec();
        tree.inOrderWalk(exec);
        System.out.println(exec.getResult());
        System.out.println();

        // usuwanie //
        System.out.println("Dodawanie usuniecie elementu o wartosci 10... ");
        tree.delete(elementdoUsuniecia);
        System.out.println();

        // wyswietlanie //
        System.out.println("Wyswietlanie wszystkich elementów... ");
        exec=new ElementToStringExec();
        tree.inOrderWalk(exec);
        System.out.println(exec.getResult());

        // max - min //
        System.out.println("\nWyszukanie najwiekszego elementu...");
        System.out.println(tree.getMax());
        System.out.println("\nWyszukanie najwiekszego elementu...");
        System.out.println(tree.getMin());

        // wyszukanie //
        System.out.println("\nWyszukanie elementu...");
        System.out.println(tree.find(elemendoZnalezienia));

        // natepnik //
        System.out.println("\nWyszukanie nastepnika elementu...");
        System.out.println(tree.successor(elemendoZnalezienia));
    }
}
