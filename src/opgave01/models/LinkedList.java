package opgave01.models;

import java.sql.SQLOutput;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
        Node<T> temp = head;
        int count = 0;
        if (index > size() - 1) {
            throw new IndexOutOfBoundsException("Fejl");
        }
        return getRecursive(temp, count, index);

    }

    private T getRecursive(Node<T> temp, int count, int index) {
        if (index == 0) {
            return head.getElement();
        }
        if (count == index) {
            return temp.getElement();
        } else {
            return getRecursive(temp.getNext(), count + 1, index);
        }
    }


    @Override
    public void add(int index, T t) {
        Node<T> temp = head;
        Node<T> ny = new Node<>(t);
        int count = 0;
        if (index > size()) {
            throw new IndexOutOfBoundsException("Fejl");
        }
        if (index == 0) {
            ny.setNext(head);
            head = ny;
        }
        count++;

        while (temp != null && count <= index) {

            if (count == index) {
                if (temp == tail) {
                    tail.setNext(ny);
                    tail = ny;
                } else {
                    ny.setNext(temp.getNext());
                    temp.setNext(ny);

                }
            }
            count++;
            temp = temp.getNext();

        }
    }

    @Override
    public T remove(int index) {
        Node<T> temp = head;
        int count = 0;
        if (index > size()) {
            throw new IndexOutOfBoundsException("Fejl");
        }
        if (index == 0) {
            head = temp.getNext();
            return head.getElement();

        }
        while (temp != null && temp.getNext() != null) {
            if (count == index) {
                temp.setNext(temp.getNext().getNext());
                return temp.getElement();
            } else if (temp.getNext() == tail) {
                temp.setNext(null);
                tail = temp;
                return temp.getElement();
            }
            count++;
            temp = temp.getNext();
        }
        return null;
    }

    @Override
    public int indexOf(T t) {
        int count = 0;
        Node<T> temp = head;
        while (temp != null) {
            if (temp.getElement() == t) {
                return count;
            }
            count++;
            temp = temp.getNext();
        }

        return -1;
    }

    @Override
    public Iterator<T> iterator() {
       return new Iterator<T>() {
           Node<T> current = head;
           @Override
           public boolean hasNext() {
               return current != null;
           }

           @Override
           public T next() {
               T data = current.getElement();
               current = current.getNext();
               return data;
           }
       };
    }



}
