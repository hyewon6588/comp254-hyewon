package Ex2;

public class SinglyLinkedList<E>{
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
    private Node<E> head = null;


    private Node<E> tail = null;


    private int size = 0;


    public SinglyLinkedList() { }

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }


    public E first() {
        if (isEmpty()) return null;
        return head.getElement();
    }


    public E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (size == 0)
            tail = head;
        size++;
    }

    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty())
            head = newest;
        else
            tail.setNext(newest);
        tail = newest;
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) return null;
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0)
            tail = null;
        return answer;
    }

    public void swapNode(E e1, E e2) {

        //if both nodes are the same or list has less than two nodes
        if (e1.equals(e2) || size < 2) {
            return;
        }

        Node<E> prevA = null, currentA = head;
        while (currentA != null && !currentA.getElement().equals(e1)) {
            prevA = currentA;
            currentA = currentA.getNext();
        }

        Node<E> prevB = null, currentB = head;
        while (currentB != null && !currentB.getElement().equals(e2)) {
            prevB = currentB;
            currentB = currentB.getNext();
        }

        if (currentA == null || currentB == null) {
            // One or both nodes not found in the list
            return;
        }

        if (prevA != null) {
            prevA.setNext(currentB);
        }else {
            head = currentB;
        }

        if (prevB != null) {
            prevB.setNext(currentA);
        }else {
            head = currentA;
        }

        if(currentA.getNext()==null){
            tail=currentB;
        }
        if (currentB.getNext()==null){
            tail=currentA;
        }

        Node<E> temp = currentA.getNext();
        currentA.setNext(currentB.getNext());
        currentB.setNext(temp);

    }

    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        Node<E> walk = head;
        while (walk != null) {
            sb.append(walk.getElement());
            if (walk != tail)
                sb.append(", ");
            walk = walk.getNext();
        }
        sb.append(")");
        return sb.toString();
    }

    public static void main(String[] args)
    {

        SinglyLinkedList<String> list = new SinglyLinkedList<String>();

        list.addFirst("MSP");
        list.addLast("ATL");
        list.addLast("BOS");
        list.addFirst("LAX");

        System.out.println(list);

        System.out.println("Removed item: "+list.removeFirst());

        System.out.println(list);

        list.swapNode("MSP","ATL");
        System.out.println(list);
    }
}
