package Lista10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class QuickSort {
    Random random = new Random();

    public ArrayList<Vertex> sort(ArrayList<Vertex> list) {
        quicksort(list, 0, list.size());
        return list;
    }

    private void quicksort(ArrayList<Vertex> list, int startIndex, int endIndex) {
        if (endIndex - startIndex > 1) {
            int partition = partition(list, startIndex, endIndex);
            quicksort(list, startIndex, partition);
            quicksort(list, partition + 1, endIndex);
        }
    }

    private int partition(ArrayList<Vertex> list, int nFrom, int nTo) {
        int rnd = nFrom + random.nextInt(nTo - nFrom);
        swap(list, nFrom, rnd);
        int value = list.get(nFrom).getValue();
        int idxBigger = nFrom + 1, idxLower = nTo - 1;
        do {
            while (idxBigger <= idxLower && (list.get(idxBigger).getValue() <= value))
                idxBigger++;
            while (list.get(idxLower).getValue() > value)
                idxLower--;
            if (idxBigger < idxLower)
                swap(list, idxBigger, idxLower);
        } while (idxBigger < idxLower);
        swap(list, idxLower, nFrom);
        return idxLower;
    }

    private void swap(ArrayList<Vertex> list, int left, int right) {
        if (left != right) {
            Vertex temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right,temp);
        }
    }
}
