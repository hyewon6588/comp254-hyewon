package Ex1;

public class DoublyLinkedList<E> {
    private static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        public E getElement() { return element; }

        public Node<E> getPrev() { return prev; }

        public Node<E> getNext() { return next; }


        public void setPrev(Node<E> p) { prev = p; }


        public void setNext(Node<E> n) { next = n; }

    }

    private Node<E> header;

    private Node<E> trailer;

    private int size = 0;


    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    public E first() {
        if (isEmpty()) return null;
        return header.getNext().getElement();
    }

    public E last() {
        if (isEmpty()) return null;
        return trailer.getPrev().getElement();
    }


    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }


    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    public E removeFirst() {
        if (isEmpty()) return null;
        return remove(header.getNext());
    }


    public E removeLast() {
        if (isEmpty()) return null;
        return remove(trailer.getPrev());
    }

    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        // create and link a new node
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }


    public void concatList(DoublyLinkedList<E> otherList) {
        // Connect the end of this list to the beginning of the other list
        this.trailer.prev.next = otherList.header.next;
        otherList.header.next.prev = this.trailer.prev;

        // Connect the end of the other list to the trailer of this list
        otherList.trailer.prev.next = this.trailer;
        this.trailer.prev = otherList.trailer.prev;

        // Update the size
        this.size += otherList.size;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        Node<E> walk = header.getNext();
        while (walk != trailer) {
            sb.append(walk.getElement());
            walk = walk.getNext();
            if (walk != trailer)
                sb.append(", ");
        }
        sb.append(")");
        return sb.toString();
    }

    public static void main(String[] args)
    {
        DoublyLinkedList<Integer> listL = new DoublyLinkedList<Integer>();

        listL.addFirst(1);
        listL.addLast(2);
        listL.addLast(3);
        listL.addFirst(0);

        System.out.println(listL);
        System.out.println(listL.first());


        DoublyLinkedList<Integer> listM = new DoublyLinkedList<Integer>();

        listM.addFirst(5);
        listM.addLast(6);
        listM.addLast(7);
        listM.addFirst(4);

        System.out.println(listM);
        System.out.println(listM.first());

        listL.concatList(listM);
        System.out.println(listL);
    }
}
