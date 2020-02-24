package adt;

public interface SinglyADT<E> {
    void add(E item);

    void remove();

    int search(E item);

    void sort();

    void print();
}
