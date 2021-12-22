package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Heap<K> {
    private int maxN;
    private int n;
    private int[] arrayaux;
    private int[] arrayinverse;
    private K[] keys;

    public Heap() {
        this(1);
    }

    public Heap(int maxN) {
        if (maxN < 0)
            throw new IllegalArgumentException();
        this.maxN = maxN;
        n = 0;
        this.keys =  (K[]) new Object[maxN + 1];
        arrayaux = new int[maxN + 1];
        arrayinverse = new int[maxN + 1];
        for (int i = 0; i <= maxN; i++)
            arrayinverse[i] = -1;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean contains(int i) {

        return arrayinverse[i] != -1;
    }

    public int size() {
        return n;
    }

    public void insert(int i, K key) {
        n++;
        arrayinverse[i] = n;
        arrayaux[n] = i;
        keys[i] = key;
        swim(n);
    }

    public int minIndex() {
        return arrayaux[1];
    }

    public K min() {
        return keys[arrayaux[1]];
    }

    public int Extract_Min() {
        int min = arrayaux[1];
        exch(1, n--);
        sink(1);
        assert min == arrayaux[n + 1];
        arrayinverse[min] = -1;
        keys[min] = null;
        arrayaux[n + 1] = -1;
        return min;
    }

    public K keyOf(int i) {
        if (i < 0 || i >= maxN)
            throw new IllegalArgumentException();
        else
            return keys[i];
    }

    private boolean swapCompare(int i, int j) {
        return !(keys[arrayaux[i]].equals(keys[arrayaux[j]]));
    }

    private void exch(int i, int j) {
        int swap = arrayaux[i];
        arrayaux[i] = arrayaux[j];
        arrayaux[j] = swap;
        arrayinverse[arrayaux[i]] = i;
        arrayinverse[arrayaux[j]] = j;
    }

    private void swim(int k) {
        while (k > 1 && swapCompare(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && swapCompare(j, j + 1))
                j++;
            if (!swapCompare(k, j))
                break;
            exch(k, j);
            k = j;
        }
    }

    public Iterator<Integer> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<Integer> {
        private Heap<K> copy;

        public HeapIterator() {
            copy = new Heap<K>(arrayaux.length - 1);
            for (int i = 1; i <= n; i++)
                copy.insert(arrayaux[i], keys[arrayaux[i]]);
        }

        public boolean hasNext() {
            return !copy.isEmpty();
        }

        public Integer next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return copy.Extract_Min();
        }
    }

    public void inOrder(){
        for (int i : arrayaux) {
            if(keys[i] != null) System.out.println(keys[i]);
        }
    }
}
