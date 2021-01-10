package Lista9;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        AVL avl = new AVL();
        Trie trie = new Trie();

        System.out.println();
        System.out.println("----------------- Zadanie 1. ... -----------------");
        System.out.println();
        System.out.println("----------------- Dodawanie 20 elementow ... -----------------");
        try {
            for(int i=0; i<20; i++){
                boolean dodane = false;
                while(!dodane){
                    int ele = rand.nextInt(200);
                    if(avl.search(ele)==false){
                        System.out.println("Dodano element o wartosci: " + ele);
                        avl.insert(ele);
                        dodane = true;
                    }
                }
                avl.print();
            }
        } catch (DuplicateElementException e) {
            System.out.println("Blad dodawania! Taka wartosc juz istnieje");
        }

        System.out.println();
        System.out.println("----------------- Wyszukiwanie elemntu ... -----------------");
        System.out.println("Wprowadź wartość: ");
        int doWyszukania = scan.nextInt();
        System.out.println(avl.search(doWyszukania));

        System.out.println();
        System.out.println("----------------- Wypisywanie elemntów ... -----------------");
        System.out.println("Preorder:");
        avl.treePreorderWalk();
        System.out.println();
        System.out.println("Inorder:");
        avl.treeInorderWalk();
        System.out.println();
        System.out.println("Postorder:");
        avl.treePostorderWalk();
        System.out.println();
        System.out.println("Levelorder:");
        avl.treeLevelorderWalk();


        System.out.println();
        System.out.println("----------------- Sprawdzanie czy drzewo jest puste ... -----------------");
        System.out.println(avl.isEmpty());

        System.out.println();
        System.out.println("----------------- Czyszczenie drzewa ... -----------------");
        avl.clear();
        System.out.println();

        System.out.println();
        System.out.println("----------------- Sprawdzanie czy drzewo jest puste ... -----------------");
        System.out.println(avl.isEmpty());


        System.out.println();
        System.out.println("----------------- Zadanie 2. ... -----------------");
        System.out.println();
        System.out.println();
        System.out.println("----------------- Sprawdzanie czy drzewo jest puste ... -----------------");
        System.out.println(trie.isEmpty());
        System.out.println();
        System.out.println("----------------- Dodawanie elementow ... -----------------");
        trie.insert("KOLO");
        trie.insert("KOT");
        trie.insert("KOTOWATY");
        trie.insert("KOLEGA");
        trie.insert("KOGUT");
        System.out.println();
        System.out.println();
        System.out.println("----------------- Drukowanie ... -----------------");
        trie.print();

        System.out.println();
        System.out.println("----------------- Sprawdzanie czy drzewo jest puste ... -----------------");
        System.out.println(trie.isEmpty());

        System.out.println();
        System.out.println("----------------- Sprawdzanie czy w drzewie znajduje sie slowo 'KOT' ... -----------------");
        System.out.println(trie.containsWord("KOT"));

        System.out.println();
        System.out.println("----------------- Usuwanie slowa 'KOT' ... -----------------");
        trie.delete("KOLO");

        System.out.println();
        System.out.println();
        System.out.println("----------------- Sprawdzanie czy w drzewie znajduje sie slowo 'KOLO' ... -----------------");
        System.out.println(trie.containsWord("KOT"));
        System.out.println();
        System.out.println("----------------- Sprawdzanie czy w drzewie znajduje sie slowo 'KOTOWATY' ... -----------------");
        System.out.println(trie.containsWord("KOTOWATY"));
        System.out.println();
        System.out.println("----------------- Drukowanie ... -----------------");
        trie.print();

        System.out.println();
        System.out.println("----------------- Rozpoczynanie testu ... -----------------");
        TesterTrie testerTrie = new TesterTrie();
        testerTrie.tester();
    }
}
