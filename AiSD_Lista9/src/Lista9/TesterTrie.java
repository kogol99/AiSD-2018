package Lista9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TesterTrie {


    Trie tworzenieTrie(int iloscSlow) throws IOException {
        Trie trie = new Trie();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("slowa2.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Blad oczytu pliku!!");
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String textLine = bufferedReader.readLine();
        for(int i=0; i<iloscSlow; i++){
            trie.insert(textLine);
        }

        bufferedReader.close();
        return trie;
    }

    long czasWyszukiwania(Trie trie, String slowo){
        long czasRozpoczecia, czasZakonczenia, czasTrwania;

        czasRozpoczecia = System.nanoTime();
        trie.containsWord(slowo);
        czasZakonczenia = System.nanoTime();
        czasTrwania = czasZakonczenia - czasRozpoczecia;

        return czasTrwania;
    }

    void tester() throws IOException {
        Trie trie1 = tworzenieTrie(10);
        Trie trie2 = tworzenieTrie(25);
        Trie trie3 = tworzenieTrie(50);
        Trie trie4 = tworzenieTrie(100);
        Trie trie5 = tworzenieTrie(145);
        Trie trie6 = tworzenieTrie(500);

        String slowo = "PRZEPRASZAM";
        long czasTrie0 = 0,czasTrie1 = 0,czasTrie2 = 0,czasTrie3 = 0,czasTrie4 = 0,czasTrie5 = 0,czasTrie6 = 0;

        czasTrie0 = czasWyszukiwania(trie1, slowo);
        czasTrie1 =+ czasWyszukiwania(trie1, slowo);
        czasTrie2 =+ czasWyszukiwania(trie2, slowo);
        czasTrie3 =+ czasWyszukiwania(trie3, slowo);
        czasTrie4 =+ czasWyszukiwania(trie4, slowo);
        czasTrie5 =+ czasWyszukiwania(trie5, slowo);
        czasTrie6 =+ czasWyszukiwania(trie5, slowo);

        System.out.println("Czas wyszukiwania słowa przy 10 slowach: " + czasTrie1 + " [ns]");
        System.out.println("Czas wyszukiwania słowa przy 25 slowach: " + czasTrie2 + " [ns]");
        System.out.println("Czas wyszukiwania słowa przy 50 slowach: " + czasTrie3 + " [ns]");
        System.out.println("Czas wyszukiwania słowa przy 100 slowach: " + czasTrie4 + " [ns]");
        System.out.println("Czas wyszukiwania słowa przy 145 slowach: " + czasTrie5 + " [ns]");
        System.out.println("Czas wyszukiwania słowa przy 500 slowach: " + czasTrie6 + " [ns]");
    }

}
