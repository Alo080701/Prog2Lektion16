package opgave02.models;

public class Node<E> {
    private E element;
    private Node<E> next;

    public Node(E element) {
        this.element = element;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public E getElement() {
        return element;
    }
}
