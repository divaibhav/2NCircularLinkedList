package implementation;

import myinterface.SinglyCircularADT;

public class MySinglyCircularLinkedList implements
        SinglyCircularADT {
    //only keeping tail reference
    private Node tail;
    //to keep number of nodes
    private int size;

    public MySinglyCircularLinkedList() {
        tail = null;
        size = 0;
    }

    @Override
    public void addFirst(int element) {
        Node node = new Node(element);
        if(isEmpty()){
            tail = node;
            //setting circular behaviour
            node.setNext(node);
        }
        else{
            node.setNext(tail.getNext());
            tail.setNext(node);
        }
        size++;
    }

    @Override
    public int removeFirst() {
        int response = 0; //considering 0 as invalid data
        if(!isEmpty()){

            Node firstNode = tail.getNext();
            if(tail == firstNode){
              //only a single node
              tail = null;
            }
            else {
                //multiple nodes
                tail.setNext(firstNode.getNext());
            }
            response = firstNode.getData();
            size--;
        }

        return response;
    }

    @Override
    public void addLast(int element) {
        Node node = new Node(element);
        if(!isEmpty()){
            node.setNext(tail.getNext());
            tail.setNext(node);
            tail = node;

        }
        else{
            tail = node;
            node.setNext(node);
        }
        size++;

    }

    @Override
    public boolean isEmpty() {
        return tail == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void traverse() {
        if(!isEmpty()) {
            Node temp = tail.getNext();

            while (temp != tail) {
                System.out.print(temp.getData() + ", ");
                temp = temp.getNext();
            }
            System.out.println(tail.getData());
        }
    }

    @Override
    public int sizeByTraversing() {
        int count = 0;
        if(!isEmpty()) {
            Node temp = tail.getNext();

            while (temp != tail) {
                count++;
                temp = temp.getNext();
            }
            count++;
        }

        return count;
    }
}
