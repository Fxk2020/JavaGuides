package lru;

import java.util.HashMap;

public class Lru {

    //双向链表
    class LinkedNode{
        LinkedNode pre;
        LinkedNode next;
        int key;
        int value;

        public LinkedNode(){
            pre = null;
            next = null;
        }
        public LinkedNode(int key,int value){
            this.key = key;
            this.value = value;
            pre = null;
            next = null;
        }
    }

    //哈希表
    HashMap<Integer, LinkedNode> hashMap ;
    private final int capacity;
    private int size;
    LinkedNode head;
    LinkedNode tail;

    public Lru(int capacity){
        this.capacity = capacity;
        size = 0;
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.pre = head;

        hashMap = new HashMap<>();
    }

    public int get(int key){
        if (hashMap.containsKey(key)){
            moveToHead(hashMap.get(key));
            return hashMap.get(key).value;
        }else {
            return -1;
        }
    }

    public void put(int key, int value){
        if (hashMap.containsKey(key)){

            hashMap.get(key).value = value;
            moveToHead(hashMap.get(key));
        }else {

            size++;
            LinkedNode tmp = new LinkedNode(key, value);
            if (size>capacity){
                LinkedNode linkedNode = removeNode(tail.pre);
                hashMap.remove(linkedNode.key);
                size--;
            }
            addToHead(tmp);
            hashMap.put(key, tmp);

        }
    }

    private void addToHead(LinkedNode linkedNode) {

        linkedNode.next = head.next;
        linkedNode.pre = head;
        head.next.pre = linkedNode;
        head.next = linkedNode;
    }

    private void moveToHead(LinkedNode linkedNode) {

        removeNode(linkedNode);
        linkedNode.next = head.next;
        linkedNode.pre = head;
        head.next.pre = linkedNode;
        head.next = linkedNode;
    }

    private LinkedNode removeNode(LinkedNode linkedNode) {

        linkedNode.pre.next = linkedNode.next;
        linkedNode.next.pre = linkedNode.pre;
        return linkedNode;
    }

}
