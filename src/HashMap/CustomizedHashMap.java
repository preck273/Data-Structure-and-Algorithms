package HashMap;

public class CustomizedHashMap<K, V>{

    private static class InputNode<K, V> {

        private K key;
        private V value;
        private InputNode<K, V> next;

        public InputNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            InputNode<K,V> temp = this;
            StringBuilder sb = new StringBuilder();
            while (temp != null) {
                sb.append(temp.key + " -> " + temp.value + ",");
                temp = temp.next;
            }
            return sb.toString();
        }

    }

    private int size;

    private InputNode<K, V> input[];

    public CustomizedHashMap(int size) {
        this.size = size;
        input = new InputNode[this.size];
    }

    public void put(K key, V value) {
        int hash = key.hashCode() % this.size;
        InputNode<K, V> e = input[hash];

        if (e == null) {
            input[hash]= new InputNode<K, V>(key, value);
        } else {
            while (e.next != null) {
                if (e.getKey() == key) {
                    e.setValue(value);
                    return;
                }
                e = e.next;
            }

            if (e.getKey() == key) {
                e.setValue(value);
                return;
            }

            e.next = new InputNode<K, V>(key, value);
        }
    }

    public V get(K key) {
        int hash = key.hashCode() % this.size;
        InputNode<K, V> e = input[hash];

        if (e == null) {
            return null;
        }

        while (e != null) {
            if (e.getKey() == key) {
                return e.getValue();
            }
            e = e.next;
        }

        return null;
    }

    public InputNode<K, V> remove(K key) {
        int hash = key.hashCode() % this.size;
        InputNode<K, V> e = input[hash];

        if (e == null) {
            return null;
        }

        if (e.getKey() == key) {
            input[hash] = e.next;
            e.next = null;
            return e;
        }

        InputNode<K, V> prev = e;
        e = e.next;

        while (e != null) {
            if (e.getKey() == key) {
                prev.next = e.next;
                e.next = null;
                return e;
            }
            prev = e;
            e = e.next;
        }

        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.size; i++) {
            if (input[i] != null) {
                sb.append(i + " " + input[i] + "\n");
            } else {
                sb.append(i + " " + "null" + "\n");
            }
        }

        return sb.toString();
    }

}


