package opgave01.models;

import java.util.Iterator;

public class LinkedList<T> implements ListEaaa<T> {

    private Node<T> head;
    private Node<T> tail;

    public LinkedList() {

    }

    @Override
    public void add(T t) {
        Node<T> ny = new Node<>(t);
        if (tail == null) {
            tail = ny;
            head = ny;
        } else {
            tail.setNext(ny);
            tail = ny;
        }
    }

    @Override
    public boolean remove1(T t) {
        boolean svar = false;
        Node<T> temp = head;
        if (head.getElement() == t) {
            head = temp.getNext();
            svar = true;
        }
        while (temp != null && temp.getNext() != null) {

            if (temp.getNext().getElement() == t) {

                temp.setNext(temp.getNext().getNext());
                svar = true;

            } else if (temp.getNext() == tail) {
                temp.setNext(null);
                tail = temp;
                svar = true;
            }

            temp = temp.getNext();
        }
        return svar;
    }

    @Override
    public void addFirst(T t) {
        Node<T> ny = new Node<>(t);
        ny.setNext(head);
        head = ny;
    }

    @Override
    public T getFirst() {
        return head.getElement();
    }

    @Override
    public void removeFirst() {
        head = head.getNext();
    }

    @Override
    public boolean contains(T t) {
        boolean svar = false;
        Node<T> temp = head;
        if (head.getElement() == t) {
            svar = true;
        }
        while (temp != null && temp.getNext() != null) {

            if (temp.getNext().getElement() == t) {
                svar = true;

            } else if (temp.getNext() == tail) {
                svar = true;
            }

            temp = temp.getNext();
        }
        return svar;

    }

    @Override
    public void clear() {
        head = null;
        tail = null;

    }

    @Override
    public int size() {
        int svar = 0;
        Node<T> temp = head;
        while (temp != null) {
            svar++;
            temp = temp.getNext();
        }

        return svar;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public T get(int index) {
        int svar = 0;
        Node<T> temp = head;
        while (temp != null && temp.getNext() != null) {
            if (svar == index) {
                return temp.getElement();
            }else {
                svar++;
                temp = temp.getNext();
            }
        }

        return null;
    }

    @Override
    public void add(int index, T t) {
        Node<T> temp = head;
        Node<T> ny = new Node<>(t);
        int count = 0;
        if (index == 0) {
            ny.setNext(head);
            head = ny;
        }
        while (temp != null) {
            if (count == index) {
                ny.setNext(temp.getNext());
                temp.setNext(ny);
            } else if (temp.getNext() == null && count > index) {
                temp.setNext(ny);
                tail = ny;
            } else {
                count++;
                temp = temp.getNext();
            }
        }
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(T t) {
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

}
