package definition;

import adt.SinglyADT;

public class SinglyLinkedList<E> implements SinglyADT<E> {
    private int size = 0;
    private Node<E> head = null;

    public int getSize() {
        return size;
    }

    public Node<E> getNode(int index) throws IndexOutOfBoundsException {
        Node<E> response = head;
        if (index < 0 && index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        } else {
            for (int i = 0; i < index && head != null; i++) {
                response = response.next;
            }
        }
        return response;
    }

    private void addFirst(E item) {
        head = new Node<>(item, head);
        size++;
    }

    private void addAfter(Node<E> node, E item) {
        Node<E> node1 = new Node<>(item, node.next);
        node.next = node1;
        size++;
    }

    public void add(int index, E item) {
        if (index == 0) {
            addFirst(item);
        } else {
            addAfter(getNode(index - 1), item);
        }
    }


    @Override
    public void add(E item) {
        add(size, item);
    }

    private void removeFirst() throws IndexOutOfBoundsException {
        if (head == null) {
            throw new IndexOutOfBoundsException(Integer.toString(size));
        } else {
            head = head.next;
            size--;
        }
    }

    private void removeAfter(Node<E> node) {
        if (node.next == null) {
            throw new IndexOutOfBoundsException(Integer.toString(size));
        } else {
            node.next = node.next.getNext();
            size--;
        }
    }

    public void remove(int index) {
        if (index < 0 && index > size)
            throw new IndexOutOfBoundsException(Integer.toString(size));
        else if (index == 0) {
            removeFirst();
        } else
            removeAfter(getNode(index - 2));
    }

    @Override
    public void remove() {
        remove(size);
    }

    @Override
    public int search(E item) {
        Node<E> temp = head;
        for (int i = 0; i < size; i++) {
            E data = temp.getData();
            if (item == data) {
                return i + 1;
            }
            temp = temp.getNext();
        }

        return 0;
    }

    @Override
    public void sort() {
        Node current = head, index = null;
        E temp;

        if (head == null) {
            return;
        } else {
            while (current != null) {

                index = current.next;

                while (index != null) {

                    if ((current.data).equals(index.data)) {
                        temp = (E) current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }

    public void print(int index) {
        Node<E> response = head;
        for (int i = 0; i < index; i++) {
            E data = response.getData();
            response = response.getNext();
            if (i == index - 1) {
                System.out.println(data);
            }
        }
    }

    @Override
    public void print() {
        Node<E> response = head;
        System.out.println("---Here are all your contacts---");
        for (int i = 0; i < size; i++) {
            E data = response.getData();
            response = response.getNext();
            System.out.println(data);
        }
    }

    private static class Node<E> implements Comparable<E> {
        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public Node<E> getNext() {
            return next;
        }

        @Override
        public int compareTo(E o) {
            return 0;
        }
    }

}

