package Lista6;

public interface Set<T>{
    void add(String value);
    boolean contains(String value);
    void remove(String value);
    void clear();
    int size();
    boolean isEmpty();
}