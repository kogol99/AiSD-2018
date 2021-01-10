package Lista8;

import java.util.ArrayList;
import java.util.Random;

public class Tester {
    public void wykonanieTestu() {
        for(int k=5; k<15; k++){
            int liczbaElementow = (int) Math.pow(2,k)-1;
            System.out.println("Dla "+ liczbaElementow + ":");
            BST BST = new BST();
            BST balancedBST = new BST();
            wypelnijDrzewa(liczbaElementow,BST,balancedBST);
            wykonajTest(liczbaElementow,BST,balancedBST);
        }
        for(int k=15; k<18; k++){
            int liczbaElementow = (int) Math.pow(2,k)-1;
            System.out.println("Dla "+ liczbaElementow + ":");
            BST balancedBST = new BST();
            wypelnijDrzewoBalanced(liczbaElementow,balancedBST);
            wykonajTest2(liczbaElementow,balancedBST);
        }
    }

    public void wypelnijDrzewa(int liczbaEl,BST drzewoBST, BST drzewoBalancedBST){
        for(int j=0; j<liczbaEl; j++){
            try {
                drzewoBST.insert(j);
                drzewoBalancedBST.insert(j);
            } catch (DuplicateElementException e) {

            }
        }
        drzewoBalancedBST.repairTree();
    }

    public void wypelnijDrzewoBalanced(int liczbaEl, BST drzewoBalancedBST){
        ArrayList arrayWpisane = new ArrayList();
        Random rand = new Random();
        try {
            for (int i = 0; i < liczbaEl; i++) {
                int liczba = rand.nextInt(liczbaEl * 3);
                if (!arrayWpisane.contains(liczba)) {
                    drzewoBalancedBST.insert(liczba);
                    arrayWpisane.add(liczba);
                }else
                    i--;
            }
        }catch (DuplicateElementException ex){

        }
    }

    long testBST(int liczbaDoWyszukania, BST tree){
        long czasRozpoczecia, czasZakonczenia, czasTrwania;

        czasRozpoczecia = System.nanoTime();
        tree.find(liczbaDoWyszukania);
        czasZakonczenia = System.nanoTime();
        czasTrwania = czasZakonczenia - czasRozpoczecia;

        return czasTrwania;
    }


    public void wykonajTest(int liczbaEl,BST drzewoBST, BST drzewoBalancedBST) {
        long sredniZwykly = 0;
        long sredniZrownowazony = 0;
        Random rand = new Random();

        int liczbPowtTestu = 50000;
        for (int i = 0; i < liczbPowtTestu; i++) {
            int liczbaDoWyszukania = rand.nextInt(liczbaEl);
            sredniZwykly += testBST(liczbaDoWyszukania,drzewoBST);
            sredniZrownowazony += testBST(liczbaDoWyszukania,drzewoBalancedBST);
        }
        sredniZwykly = sredniZwykly / liczbPowtTestu;
        sredniZrownowazony = sredniZrownowazony / liczbPowtTestu;
        System.out.println("Sredni czas dla BST: " + sredniZwykly);
        System.out.println("Sredni czas dla BST po DSW: " + sredniZrownowazony);
    }

    public void wykonajTest2(int liczbaEl,BST drzewoBalancedBST){
        long sredniZrownowazony = 0;
        Random rand = new Random();

        int liczbPowtTestu = 50000;
        for (int i = 0; i < liczbPowtTestu; i++) {
            int liczbaDoWyszukania = rand.nextInt(liczbaEl);
            sredniZrownowazony += testBST(liczbaDoWyszukania,drzewoBalancedBST);
        }
        sredniZrownowazony = sredniZrownowazony / liczbPowtTestu;
        System.out.println("Sredni czas dla BST po DSW: " + sredniZrownowazony);
    }
}

