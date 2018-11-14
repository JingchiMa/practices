package thumbtack;

import java.util.*;

public class OrderedHashMap<K extends Comparable<? extends K>, V> {
    // TreeSet
    // HashMap

    private final SortedSet<K> sortedSet;
    private final HashMap<K, V> hashMap;

    public OrderedHashMap() {
        this.sortedSet = new TreeSet<>();
        this.hashMap = new HashMap<>();
    }

    public void put(K key, V value) {
        hashMap.put(key, value);
        sortedSet.add(key);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (K key : this.sortedSet) {
            sb.append("{").append(key).append("=>").append(this.hashMap.get(key)).append("} ");
        }
        return sb.toString();
    }
}
