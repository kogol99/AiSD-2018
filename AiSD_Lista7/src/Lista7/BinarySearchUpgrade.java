package Lista7;

public class BinarySearchUpgrade {

    public int binarySearchUpgrade(int[] list, int what ){
        int left=0;
        int right=list.length-1;
        int middle;
        double t;
        while(left<=right && what >= list[left] && what <= list[right]){
            middle = left + (((right-left) / (list[right] - list[left]))*(what - list[left]));

            if (left == right)
            {
                if (list[left] == what) return left;
                return -1;
            }
            if(list[middle]==what)
                return middle;
            if(what<list[middle])
                right=middle-1;
            else
                left=middle+1;
        }
        return -1;
    }

}
