package task;

import java.util.Arrays;

public class OpenAddressMyHashMap {
    //   NULL VALUE EQUALS 0
    private int[] keys;
    private long[] values;
    private int size = 10;
    public OpenAddressMyHashMap() {
        this.keys = new int[this.size];
        this.values = new long[this.size];
    }

    public OpenAddressMyHashMap(final int size) {
        this.size = size;
        this.keys = new int[this.size];
        this.values = new long[this.size];
    }

    public int size() {
        return this.size;
    }

    public long get(final int key){
        long value = 0;
        int index = hash(key);

        if (index >= 0) {
            value = values[index];
        }

        return value;
    }

    public void put(final int key, final long value){
        int index = hash(key);

        if (index >= this.size) {
            resize(index, this.keys, this.values);
        }

        while(keys[index] != 0 && keys[index] != key){
            index++;
            if(index >= this.size){
                resize(index, this.keys, this.values);
            }
        }

        this.keys[index] = key;
        this.values[index] = value;
    }

    private static int hash(final int key) {
        return Integer.hashCode(key) & Integer.MAX_VALUE;
    }

    private void resize(final int index, final int[] keys, final long[] values){
        this.size = (index+1);
        this.keys = Arrays.copyOf(keys, (index+1));
        this.values = Arrays.copyOf(values, (index+1));
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OpenAddressMyHashMap (K-V):  \n");

        for (int i = 0; i < size; ++i){
            sb.append("[");
            sb.append(keys[i]).append(" - ").append(values[i]);
            sb.append("]");
        }

        return sb.toString();
    }
}
