package Lista6;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here

        mojaMapa<Element> mapa = new mojaMapa();
        Random rand = new Random();
        System.out.println("---------------------------------------------");
        System.out.println("Zadanie 1....");
        System.out.println("---------------------------------------------");
        System.out.println("Dodawanie elementu...");
        mapa.put("Lorem",rand.nextInt(10000));
        System.out.println("Dodawanie elementu...");
        mapa.put("ipsum",rand.nextInt(10000));
        System.out.println("Dodawanie elementu...");
        mapa.put("dolor",rand.nextInt(10000));
        System.out.println("Dodawanie elementu...");
        mapa.put("sit",rand.nextInt(10000));
        System.out.println("Dodawanie elementu...");
        mapa.put("amet",rand.nextInt(10000));
        System.out.println("Wywołanie elementu o kluczu 'amet'...");
        try {
            System.out.println("\t" + mapa.get("amet"));
        } catch (NoSuchElementException e) {
            System.out.println("\t !! Błąd !! Element o danym kluczu nie istnieje");
        }
        System.out.println("Dodawanie elementu...");
        mapa.put("amet",rand.nextInt(10000));
        System.out.println("Wywołanie elementu o kluczu 'amet'...");
        try {
            System.out.println("\t" + mapa.get("amet"));
        } catch (NoSuchElementException e) {
            System.out.println("\t !! Błąd !! Element o danym kluczu nie istnieje");
        }
        System.out.println("Wywołanie elementu o kluczu 'Lorem'...");
        try {
            System.out.println("\t" + mapa.get("Lorem"));
        } catch (NoSuchElementException e) {
            System.out.println("\t !! Błąd !! Element o danym kluczu nie istnieje");
        }
        System.out.println("Wywołanie elementu o kluczu 'ddolor'...");
        try {
            System.out.println("\t" + mapa.get("ddolor"));
        } catch (NoSuchElementException e) {
            System.out.println("\t !! Błąd !! Element o danym kluczu nie istnieje");
        }

        System.out.println("Wywołanie elementu o kluczu 'amet'...");
        try {
            System.out.println("\t" + mapa.get("amet"));
        } catch (NoSuchElementException e) {
            System.out.println("\t !! Błąd !! Element o danym kluczu nie istnieje");
        }
        System.out.println("Czy istnieje klucz 'Lorem'...");
        System.out.println("\t" + mapa.containsKey("Lorem"));
        System.out.println("Czy istnieje klucz 'IIpsum'...");
        System.out.println("\t" + mapa.containsKey("IIpsum"));
        System.out.println("Czyszczenie slownika...");
        mapa.clear();
        System.out.println("Sprawdzenie rozmiaru...");
        System.out.println("\t" + mapa.size());
        System.out.println("Sprawdzenie czy jest pusty...");
        System.out.println("\t" + mapa.isEmpty());
        System.out.println("Dodawanie elementu...");
        mapa.put("dolor",rand.nextInt(10000));
        System.out.println("Dodawanie elementu...");
        mapa.put("amet",rand.nextInt(10000));
        System.out.println("Dodawanie elementu...");
        mapa.put("ipsum",rand.nextInt(10000));
        System.out.println("Sprawdzenie rozmiaru...");
        System.out.println("\t" + mapa.size());
        System.out.println("Sprawdzenie czy jest pusty...");
        System.out.println("\t" + mapa.isEmpty());


        System.out.println("---------------------------------------------");
        System.out.println("Zadanie 2....");
        System.out.println("---------------------------------------------");
        System.out.println("Wypisywanie całości z użyciem iteratorów...");
        Iterator keyIterator = mapa.keyIterator();
        Iterator valueIterator = mapa.valueIterator();
        while(keyIterator.hasNext() && valueIterator.hasNext()){
            System.out.print("\t" + keyIterator.next());
            System.out.print(" : ");
            System.out.println(valueIterator.next());
        }

        System.out.println("---------------------------------------------");
        System.out.println("Zadanie 3....");
        System.out.println("---------------------------------------------");
        mojZbior<ElementSet> zbior = new mojZbior<>();
        System.out.println("Dodawanie elementu...");
        zbior.add("Lorem");
        System.out.println("Wielkosc zbioru...");
        System.out.println("\t" + zbior.size());
        System.out.println("Dodawanie elementu...");
        zbior.add("ipsum");
        System.out.println("Wielkosc zbioru...");
        System.out.println("\t" + zbior.size());
        System.out.println("Dodawanie elementu...");
        zbior.add("dolor");
        System.out.println("Wielkosc zbioru...");
        System.out.println("\t" + zbior.size());
        System.out.println("Dodawanie elementu...");
        zbior.add("sit");
        System.out.println("Wielkosc zbioru...");
        System.out.println("\t" + zbior.size());
        System.out.println("Dodawanie elementu...");
        zbior.add("amet");
        System.out.println("Wielkosc zbioru...");
        System.out.println("\t" + zbior.size());
        System.out.println("Dodawanie elementu...");
        zbior.add("amet");
        System.out.println("Wielkosc zbioru...");
        System.out.println("\t" + zbior.size());
        System.out.println("Czy zbior zawiera element o wartosci 'Lorem'...");
        System.out.println("\t" + zbior.contains("Lorem"));
        System.out.println("Czy zbior zawiera element o wartosci 'dorem'...");
        System.out.println("\t" + zbior.contains("dorem"));
        System.out.println("Usuwanie elementu 'Lorem'...");
        zbior.remove("Lorem");
        System.out.println("Wielkosc zbioru...");
        System.out.println("\t" + zbior.size());
        System.out.println("Czy zbior jest pusty...");
        System.out.println("\t" + zbior.isEmpty());
        System.out.println("Czyszczenie zbioru...");
        zbior.clear();
        System.out.println("Wielkosc zbioru...");
        System.out.println("\t" + zbior.size());
        System.out.println("Czy zbior jest pusty...");
        System.out.println("\t" + zbior.isEmpty());
    }
}
