import java.util.HashMap;

public class LRUCache {
    class Node {
        private int key;
        private int value;
        private Node previous;
        private Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.previous = null;
            this.next = null;
        }
    }
    public int capacity;
    public int size;
    public Node head;
    public Node tail;
    public HashMap<Integer, Node> map;
    public LRUCache(int capacity) {
        this.map = new HashMap<Integer, Node>(capacity);
        this.capacity = capacity;
        this.size = 0;
        this.head = null;
        this.tail = null;
    }
    public int get(int key) {
        Node node = this.map.get(key);
        if (node == null) {
            return -1;
        } else {
            this.removeNode(node);
            this.addNode(node);
            return node.value;
        }
    }
    public void set(int key, int value) {
        Node node = this.map.get(key);
        if (node == null) {
            node = new Node(key, value);
        } else {
            this.removeNode(node);
            node.value = value;
        }
        this.addNode(node);
    }
    public void addNode(Node node) {
        if (this.capacity == 0) {
            return;
        }
        if (this.size == 0) {
            this.head = node;
            this.tail = node;
            this.size += 1;
            this.map.put(node.key, node);
        } else if (this.size < this.capacity) {
            this.tail.next = node;
            node.previous = this.tail;
            node.next = null;
            this.tail = node;
            this.size += 1;
            this.map.put(node.key, node);
        } else {
            this.removeNode(this.head);
            this.addNode(node);
        }
    }
    public void removeNode(Node node) {
        this.map.remove(node.key);
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
            this.size = 0;
        } else {
            if (node == this.head) {
                this.head = this.head.next;
                this.head.previous = null;
            } else if (node == this.tail) {
                this.tail = this.tail.previous;
                this.tail.next = null;
            } else {
                node.previous.next = node.next;
                node.next.previous = node.previous;
            }
            this.size -= 1;
        }
    }
    public void print() {
        Node index = this.head;
        while (index != null) {
            System.out.print(index.key + " => " + index.value + ", ");
            index = index.next;
        }
        System.out.println();
    }
    public void rePrint() {
        Node index = this.tail;
        while (index != null) {
            System.out.print(index.key + " => " + index.value + ", ");
            index = index.previous;
        }
        System.out.println();
    }
    public static void main(String[] args) {
//        LRUCache cache = new LRUCache(2);
//        cache.set(2, 1);
//        cache.set(1, 1);
//        System.out.println(cache.get(2));
//        cache.set(4, 1);
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(2));
        
        LRUCache cache = new LRUCache(10);
        cache.set(10,13);
        cache.set(3,17);
        cache.set(6,11);
//        cache.print();
//        cache.rePrint();
        cache.set(10,5);
//        cache.print();
//        cache.rePrint();
        cache.set(9,10);
//        cache.print();
//        cache.rePrint();
        System.out.println("get 13: " + cache.get(13));
//        cache.print();
//        cache.rePrint();
        cache.set(2,19);
//        cache.print();
//        cache.rePrint();
        System.out.println("get 2: " + cache.get(2));
//        cache.print();
//        cache.rePrint();
        System.out.println("get 3: " + cache.get(3));
//        cache.print();
//        cache.rePrint();
        cache.set(5,25);
//        cache.print();
//        cache.rePrint();
        System.out.println("get 8: " + cache.get(8));
//        cache.print();
//        cache.rePrint();
        cache.set(9,22);
//        cache.print();
//        cache.rePrint();
        cache.set(5,5);
//        cache.print();
//        cache.rePrint();
        cache.set(1,30);
//        cache.print();
//        cache.rePrint();
        System.out.println("get 11: " + cache.get(11));
//        cache.print();
//        cache.rePrint();
        cache.set(9,12);
//        cache.print();
//        cache.rePrint();
        System.out.println("get 7: " + cache.get(7));
//        cache.print();
        System.out.println("get 5: " + cache.get(5));
//        cache.print();
        System.out.println("get 8: " + cache.get(8));
//        cache.print();
        System.out.println("get 9: " + cache.get(9));
//        cache.print();
        cache.set(4,30);
//        cache.print();
        cache.set(9,3);
//        cache.print();
        System.out.println("get 9: " + cache.get(9));
//        cache.print();
        System.out.println("get 10: " + cache.get(10));
//        cache.print();
        System.out.println("get 10: " + cache.get(10)); 
//        cache.print();
        cache.set(6,14);
//        cache.print();
        cache.set(3,1);
//        cache.print();
        System.out.println("get 3: " + cache.get(3));
//        cache.print();
        cache.set(10,11);
//        cache.print();
        System.out.println("get 8: " + cache.get(8));
//        cache.print();
        cache.set(2,14);
//        cache.print();
        System.out.println("get 1: " + cache.get(1));
//        cache.print();
        System.out.println("get 5: " + cache.get(5));
//        cache.print();
        System.out.println("get 4: " + cache.get(4));
//        cache.print();
        cache.set(11,4);
//        cache.print();
        cache.set(12,24);
//        cache.print();
        cache.set(5,18);
//        cache.print();
        System.out.println("get 13: " + cache.get(13));
//        cache.print();
        cache.set(7,23);
//        cache.print();
        System.out.println("get 8: " + cache.get(8));
//        cache.print();
        System.out.println("get 12: " + cache.get(12));
//        cache.print();
        cache.set(3,27);
//        cache.print();
        cache.set(2,12);
//        cache.print();
        System.out.println("get 5: " + cache.get(5));
//        cache.print();
        cache.set(2,9);
        cache.set(13,4);
        cache.set(8,18);
        cache.set(1,7);
        System.out.println("get 6: " + cache.get(6));
        cache.set(9,29);
        cache.set(8,21);
        System.out.println("get 5: " + cache.get(5));
        cache.set(6,30);
        cache.set(1,12);
        System.out.println("get 10: " + cache.get(10));
        cache.set(4,15);
        cache.set(7,22);
        cache.set(11,26);
        cache.set(8,17);
        cache.set(9,29);
        System.out.println("get 5: " + cache.get(5));
        cache.set(3,4);
        cache.set(11,30);
        System.out.println("get 12: " + cache.get(12));
        cache.set(4,29);
        System.out.println("get 3: " + cache.get(3));
        System.out.println("get 9: " + cache.get(9));
        System.out.println("get 6: " + cache.get(6));
        cache.set(3,4);
        System.out.println("get 1: " + cache.get(1));
        System.out.println("get 10: " + cache.get(10));
        cache.set(3,29);
        cache.set(10,28);
        cache.set(1,20);
        cache.set(11,13);
        System.out.println("get 3: " + cache.get(3));
        cache.set(3,12);
        cache.set(3,8);
        cache.set(10,9);
        cache.set(3,26);
        System.out.println("get 8: " + cache.get(8));
        System.out.println("get 7: " + cache.get(7));
        System.out.println("get 5: " + cache.get(5));
        cache.set(13,17);
        cache.set(2,27);
        cache.set(11,15);
        System.out.println("get 12: " + cache.get(12));
        cache.set(9,19);
        cache.set(2,15);
        cache.set(3,16);
        System.out.println("get 1: " + cache.get(1));
        cache.set(12,17);
        cache.set(9,1);
        cache.set(6,19);
        System.out.println("get 4: " + cache.get(4));
        System.out.println("get 5: " + cache.get(5));
        System.out.println("get 5: " + cache.get(5));
        cache.set(8,1);
        cache.set(11,7);
        cache.set(5,2);
        cache.set(9,28);
        System.out.println("get 1: " + cache.get(1));
        cache.set(2,2);
        cache.set(7,4);
        cache.set(4,22);
        cache.set(7,24);
        cache.set(9,26);
        cache.set(13,28);
        cache.set(11,26);
    }
}