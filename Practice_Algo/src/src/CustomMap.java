import java.util.HashSet;
import java.util.Set;

public class CustomMap {


    public static void main(String[] args) {
        MyMap map = new MyMap<Integer, Integer>();
        map.add(5, 5);
        map.add(4, 4);
        map.add(3, 3);
        map.add(0, 0);
        map.add(2, 2);
        map.printAll();

        System.out.println(map.deleteObject(new MyMap(2, 2)));
        System.out.println(map.deleteObject(new MyMap(9, 2)));

        System.out.println("=============================");

        map.printAll();
    }


}

class MyMap<K, V> {

    K key;
    V value;
    MyMap next;
    private int size = 0;
    private MyMap[] buckets = null;
    private Set<Object> keySet = new HashSet<>();

    public MyMap(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public MyMap() {
    }


    //Method to add new object
    public void add(Object key, Object value) {
        Integer localkey = (Integer) key;
        int index = localkey % 10;
        keySet.add(index);
        if (buckets == null) {
            buckets = new MyMap[10];
        }

        MyMap obj = buckets[index];
        if (obj == null) {
            obj = new MyMap(key, value);
            buckets[index] = obj;
            size++;
            return;
        }

        while (obj.next != null) {
            if (obj.value.equals(value)) return;
            obj = obj.next;
        }

        obj.next = new MyMap(key, value);
        size++;
    }

    public MyMap getObject(MyMap myMap) {
        Integer localkey = (Integer) myMap.key;
        int index = localkey % 10;
        MyMap obj = buckets[index];
        if (buckets != null) {
            while (obj.next != null) {
                if (obj.value.equals(myMap.value)) return obj;
                obj = obj.next;
            }
        }


        return null;
    }


    // Method to delete object

    public boolean deleteObject(MyMap myMap) {
        Integer localkey = (Integer) myMap.key;
        int index = localkey % 10;
        MyMap obj = buckets[index];
        keySet.remove(index);
        if (obj != null && obj.next == null) {
            buckets[index] = null;
            size--;
            return true;
        }

        MyMap prev = null;

        if (buckets != null) {
            while (obj != null) {
                if (obj.value.equals(myMap.value)) {
                    prev.next = obj.next;
                    size--;
                    return true;
                }
                prev = obj;
                obj = obj.next;
            }
        }

        return false;
    }


    // Method to print all available object in map
    public void printAll() {
        if (this == null) {
            return;
        }
        keySet.stream().forEach(x -> {
            MyMap obj = buckets[(Integer) x];
            while (obj != null) {
                System.out.println(obj.value);
                obj = obj.next;
            }
        });

    }
}