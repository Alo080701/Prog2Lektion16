package opgave02.models;

import java.util.Iterator;

public class SortedLinkedList<E extends Comparable<E>> implements SortedListEaaa<E> {
    private Node<E> head;
    private Node<E> tail;

    public SortedLinkedList() {

    }

    @Override
    public void add(E e) {
        Node<E> ny = new Node<>(e);
        Node<E> temp = head;
        if (tail == null) {
            head = ny;
            tail = ny;
        } else if (ny.getElement().compareTo(temp.getElement()) >= 0) {
            if (temp == tail) {
                tail.setNext(ny);
                tail = ny;
            } else {
                ny.setNext(temp.getNext());
                temp.setNext(ny);
            }
        }

    }

    @Override
    public boolean remove(E e) {
        boolean svar = false;
        Node<E> temp = head;
        if (head.getElement() == e) {
            head = temp.getNext();
            svar = true;
        }
        while (temp != null && temp.getNext() != null) {

            if (temp.getNext().getElement() == e) {

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
    public boolean contains(E e) {
        boolean svar = false;
        Node<E> temp = head;
        if (head.getElement() == e) {
            svar = true;
        }
        while (temp != null && temp.getNext() != null) {

            if (temp.getNext().getElement() == e) {
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
        Node<E> temp = head;
        while (temp != null) {
            svar++;
            temp = temp.getNext();
        }

        return svar;
    }

    @Override
    public boolean isEmpty() {
        return head == null & tail == null;
    }

    @Override
    public E getFirst() {
        return head.getElement();
    }

    @Override
    public void removeFirst() {
        head.setNext(head.getNext());
    }

    @Override
    public E getLast() {
        return tail.getElement();
    }

    @Override
    public void removeLast() {
        Node<E> temp = head;
        while (temp != tail) {
            if (temp.getNext() == tail) {
                tail = temp;
                temp.setNext(null);
            }
            temp = temp.getNext();
        }
    }

    @Override
    public Iterator<E> descendingIterator() {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}

