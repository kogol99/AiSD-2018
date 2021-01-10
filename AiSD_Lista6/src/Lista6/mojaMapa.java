package Lista6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class mojaMapa<T> implements Map<T>{

    ArrayList<Element> lista = new ArrayList<>();

    @Override
    public int get(String key) throws NoSuchElementException {
        for(int i=0; i<size(); i++){
            if(lista.get(i).getKey().equals(key)){
                return lista.get(i).getValue();
            }
        }
        throw new NoSuchElementException();
    }

    @Override
    public void put(String key, int value) {
        for(int i=0; i<size(); i++){
            if(lista.get(i).getKey().equals(key)){
                lista.get(i).setValue(value);
                return;
            }
        }
        lista.add(new Element(key,value));
    }

    @Override
    public boolean containsKey(String key) {
        for(int i=0; i<size(); i++){
            if(lista.get(i).getKey().equals(key)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int remove(String key) throws NoSuchElementException {
        int usuwany;
        for(int i=0; i<size(); i++){
            if(lista.get(i).getKey().equals(key)){
                usuwany = lista.get(i).getValue();
                lista.remove(i);
                return usuwany;
            }
        }
        throw new NoSuchElementException();

    }

    @Override
    public void clear() {
        ArrayList<Element> lista2 = new ArrayList<>();
        lista = lista2;
    }

    @Override
    public int size() {
        return lista.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public KeyIterator keyIterator(){
        return new KeyIterator();
    }

    public ValueIterator valueIterator(){
        return new ValueIterator();
    }

    private class KeyIterator implements Iterator {
        private int pos = 0;

        public boolean hasNext() {
            return pos < lista.size();
        }
        public String next() throws NoSuchElementException {
            return lista.get(pos++).getKey();
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class ValueIterator implements Iterator {
        private int pos = 0;

        public boolean hasNext() {
            return pos < lista.size();
        }
        public Integer next() throws NoSuchElementException {
            return lista.get(pos++).getValue();
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}


