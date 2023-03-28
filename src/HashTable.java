import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class HashTable {

    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] arrayOfLists = new LinkedList[10];
    private int arraySize = 10;
    private float loadFactor = 0.75F;
    private int threshold = (int)(arraySize * loadFactor);
    private int counter;

    public HashTable(){}

    public HashTable(int arraySize, float loadFactor){
        arrayOfLists = new LinkedList[arraySize];
        this.arraySize = arraySize;
        this.loadFactor = loadFactor;
        this.threshold = (int)(arraySize * loadFactor);
    }

    public void put(int key, String value){
        // Allow null value, so no throw exception if the String value is null
        if (counter == threshold) {
            counter = 0;
            rehashing();
        }

        Entry entry = new Entry(key, value);
        int index = hashFunction(Math.abs(key));

        if (arrayOfLists[index] == null){
            arrayOfLists[index] = new LinkedList<>();
            arrayOfLists[index].addFirst(entry);
            counter++;
            return;
        }

        for (Entry item : arrayOfLists[index]) {
            if (item.key == key) {
                item.value = value;
                return;
            }
        }

        arrayOfLists[index].addLast(entry);
    }

    public String get(int key){
        int index = hashFunction(Math.abs(key));

        if(arrayOfLists[index] == null)
            return null;

        for (Entry item : arrayOfLists[index]) {
            if (item.key == key)
                return item.value;
        }

        return null;
    }

    public void remove(int key){
        int index = hashFunction(Math.abs(key));

        if(arrayOfLists[index] == null)
            return;

        for (Entry item : arrayOfLists[index]) {
            if (item.key == key){
                arrayOfLists[index].remove(item);
                return;
            }
        }

        if(arrayOfLists[index].isEmpty())
            counter--;
    }

    private void rehashing(){
        arraySize = arraySize * 2;
        LinkedList<Entry>[] oldArrayOfLists = arrayOfLists;
        arrayOfLists = new LinkedList[arraySize];

        for (LinkedList<Entry> bucket : oldArrayOfLists){
            if (bucket == null)
                continue;

            for (Entry item : bucket)
                this.put(item.key, item.value);
        }

        threshold = (int)(arraySize * loadFactor);
    }

    private int hashFunction(int key){
        return key % arraySize;
    }

    @Override
    public String toString() {
        return "HashTable{" +
                "arrayOfLists=" + Arrays.toString(arrayOfLists) +
                '}';
    }
}
