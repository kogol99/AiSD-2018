package Lista7;

public class LinearSearch {

    public int linearSearch(int[] list, int what ){
        int index= -1;
        for(int i=0; i<list.length; i++){
            if(list[i] == what) return i;
        }
        return index;
    }
}
