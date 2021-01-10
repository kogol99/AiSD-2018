package Lista7;

public class BinarySearch {

    public int binarySearch(int[] list, int what ){
        int left=0;
        int right=list.length-1;
        int middle;
        while(left<=right){
            middle=(left+right)/2;;
            if(what==list[middle])
                return middle;
            if(what<list[middle])
                right=middle-1;
            else
                left=middle+1;
        }
        return -1;
    }

}
