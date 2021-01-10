package Lista7;

import java.util.Random;

public class QuickSort {
    Random random = new Random();

    public int[] sort(int[] list) {
        quicksort(list, 0, list.length);
        return list;
    }

    private void quicksort(int[] list, int startIndex, int endIndex) {
        if (endIndex - startIndex > 1) {
            int partition = partition(list, startIndex, endIndex);
            quicksort(list, startIndex, partition );
            quicksort(list, partition + 1, endIndex);
        }
    }

    private int partition(int[] list, int nFrom, int nTo) {
        int rnd=nFrom+random.nextInt(nTo-nFrom);
        swap(list,nFrom,rnd);
        int value=list[nFrom];
        int idxBigger=nFrom+1, idxLower=nTo-1;
        do {
            while(idxBigger<=idxLower && (list[idxBigger]<=value) )
                idxBigger++;
            while(list[idxLower] > value)
                idxLower--;
            if(idxBigger<idxLower)
                swap(list,idxBigger,idxLower);
        } while(idxBigger<idxLower);
        swap(list,idxLower,nFrom);
        return idxLower;
    }

    private void swap(int[] list, int left, int right) {
        if (left != right) {
            int temp = list[left];
            list[left] = list[right];
            list[right] = temp;
        }
    }
}
