import java.util.LinkedList;

public class HashTable <K, V> {
    public class HashObject{
        private K key;

        private V value;

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
    private int size = 0;
    public static final int ARR_SIZE = 128;
    private LinkedList<HashObject>[] arr = new LinkedList[ARR_SIZE];

    public HashTable(){
        for (int i = 0; i < ARR_SIZE; i++){
            arr[i] = null;
        }
    }

    private HashObject getObj(K key){
        if (key == null){
            return null;
        }

        int index = key.hashCode() % ARR_SIZE;
        LinkedList<HashObject> items = arr[index];

        if(items == null)
            return null;

        for(HashObject item : items) {
            if(item.getKey().equals(key))
                return item;
        }

        return null;
    }

    public V get(K key){
        HashObject item = getObj(key);

        if(item == null)
            return null;
        else
            return item.getValue();
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    public void put(K key, V value) {
        int index = key.hashCode() % ARR_SIZE;
        LinkedList<HashObject> items = arr[index];

        if(items == null) {
            items = new LinkedList<HashObject>();
            HashObject item = new HashObject();
            item.setKey(key);
            item.setValue(value);

            items.add(item);
            arr[index] = items;
            size++;
        }
        else {
            for(HashObject item : items) {
                if(item.getKey().equals(key)) {
                    item.setValue(value);
                    return;
                }
            }
            HashObject item = new HashObject();
            item.setKey(key);
            item.setValue(value);
            items.add(item);
            size++;
        }
    }

    public void delete(K key) {
        int index = key.hashCode() % ARR_SIZE;
        LinkedList<HashObject> items = arr[index];

        if(items == null)
            return;

        for(HashObject item : items) {
            if (item.getKey().equals(key)) {
                items.remove(item);
                size--;
                return;
            }
        }
    }
}