package Ex3;

public class CircularlyLinkedList<E> implements Cloneable{
    private static class Node<E> {


        private E element;


        private Node<E> next;


        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }


        public E getElement() { return element; }


        public Node<E> getNext() { return next; }


        public void setNext(Node<E> n) { next = n; }
    }
    private Node<E> tail = null;


    private int size = 0;

    public CircularlyLinkedList() { }


    public int size() { return size; }


    public boolean isEmpty() { return size == 0; }


    public E first() {
        if (isEmpty()) return null;
        return tail.getNext().getElement();
    }


    public E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }


    public void rotate() {
        if (tail != null)
            tail = tail.getNext();
    }


    public void addFirst(E e) {
        if (size == 0) {
            tail = new Node<>(e, null);
            tail.setNext(tail);
        } else {
            Node<E> newest = new Node<>(e, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }


    public void addLast(E e) {
        addFirst(e);
        tail = tail.getNext();
    }


    public E removeFirst() {
        if (isEmpty()) return null;
        Node<E> head = tail.getNext();
        if (head == tail) tail = null;
        else tail.setNext(head.getNext());
        size--;
        return head.getElement();
    }

    public CircularlyLinkedList<E> clone(){
        CircularlyLinkedList<E> other = new CircularlyLinkedList<>();
        Node<E> current = tail.getNext();
        if (size>0) {
             do{
                other.addLast(current.element);
                current=current.next;
            }while(current!=tail.next);
        }
        return other;
    }

    public String toString() {
        if (tail == null) return "()";
        StringBuilder sb = new StringBuilder("(");
        Node<E> walk = tail;
        do {
            walk = walk.getNext();
            sb.append(walk.getElement());
            if (walk != tail)
                sb.append(", ");
        } while (walk != tail);
        sb.append(")");
        return sb.toString();
    }

    //main method
    public static void main(String[] args)
    {
        //create circularly linked list
        CircularlyLinkedList<String> circularList = new CircularlyLinkedList<String>();
        circularList.addFirst("KOREA");
        circularList.addLast("JAPAN");
        circularList.addLast("CANADA");
        circularList.addLast("USA");
        System.out.println(circularList);

        //remove
        circularList.removeFirst();
        System.out.println(circularList);

        //rotate
        circularList.rotate();
        System.out.println(circularList);

        //clone
        System.out.println("Cloned List: "+circularList.clone());


    }
}
