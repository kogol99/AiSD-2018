package Lista6;

import java.util.ArrayList;

public class mojZbior<T> implements Set<T> {
    ArrayList<ElementSet> lista = new ArrayList<>();

    @Override
    public void add(String value){
        if(!contains(value)){
            lista.add(new ElementSet(value));
        }
    }

    @Override
    public boolean contains(String value){
        for (int i=0; i<size(); i++){
            if((lista.get(i).getValue().equals(value))){
                return true;
            }
        }
        return false;
    }

    @Override
    public void remove(String value){
        for (int i=0; i<size(); i++){
            if(lista.get(i).getValue().equals(value)){
                lista.remove(i);
            }
        }
    }

    @Override
    public void clear(){
        ArrayList<ElementSet> lista2 = new ArrayList<>();
        lista = lista2;
    }

    @Override
    public int size(){
        return lista.size();
    }

    @Override
    public boolean isEmpty(){
        return size() == 0;
    }

}
