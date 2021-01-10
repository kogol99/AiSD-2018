package Lista6;

public interface Map<T> {
    int get(String key );
    void put(String key , int value );
    boolean containsKey(String key );
    int remove(String key );
    void clear();
    int size();
    boolean isEmpty();
}