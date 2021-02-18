package myinterface;

public interface SinglyCircularADT {
    void addFirst(int element);
    int removeFirst();
    void addLast(int element);
    boolean isEmpty();
    int size();
    void traverse();
    int sizeByTraversing();
}
