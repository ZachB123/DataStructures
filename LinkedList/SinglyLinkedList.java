import javax.swing.LayoutStyle;

//E is the object type that the list stores
public class SinglyLinkedList<E> {
    
    //reference to beginning of list
    private Node<E> head;
    //reference to end of list
    private Node<E> tail;
    //number of nodes in list
    public int size;

    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * adds elem to beginning of list
     * @param elem element to be added to beginning of list
     */
    public void addFirst(E elem) {
        head = new Node<>(elem, head); //first creates new node that points to current first node then sets head to the new node
        if(size == 0) {
            tail = head; //run on the first element added to initialize tail
            //with one element in list the element is the head and tail
        }
        size++;
    }

    /**
     * adds elem to the end of the list
     * @param elem element to be added to end of list
     */
    public void addLast(E elem) {
        Node<E> node = new Node<E>(elem, null); //references null since it is the last element
        if(isEmpty()) {
            head = node;
        }
        // else {
        //     tail.setNext(node); I think this does nothing?
        // }
        tail = node; //no matter what the new element we create has to be tail since we are adding it to end
        size++;
    }

    /**
     * Removes and returns the first node in the list
     * if list is empty null is returned and list is unchanged
     * @return first node in list
     */
    public E removeFirst() {
        if(isEmpty()) {return null;}
        E value = head.getElement();
        head = head.getNext();
        size--;
        if(isEmpty()) {tail = null;}
        return value;
    }

    /**
     * returns but does not remove the first node in the list
     * if list is empty null is returned and list is unchanged
     * @return first node in list
     */
    public E first() {
        if(isEmpty()) {return null;}
        return head.getElement();
    }

    /**
     * returns but does not remove the last node in the list
     * if list is empty null is returned and list is unchanged
     * @return last node in list
     */
    public E last() {
        if(isEmpty()) {return null;}
        return tail.getElement();
    }

    /**
     * Returns true if the list is empty false otherwise
     * @return if the list is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * returns the number of nodes in the linked list
     * @return size of list
     */
    public int size(){
        return size;
    }

    /**
     * Node class that contains the elements and reference to next node
     */
    private class Node<E> {
        //the value at this node
        private E element;
        //reference to the next node in list
        private Node next;

        Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }

        /**
         * get the value of this node
         * @return element
         */
        public E getElement() {
            return element;
        }

        /**
         * get the reference to the next node in the list
         * @return the next node
         */
        public Node getNext() {
            return next;
        }

        public void setNext(Node n) {
            next = n;
        }

        public String toString() {
            return "Value: " + element;
        }
    }

    public String toString() {
        String s = "Size: " + size + "\n";
        Node<E> currentNode = head;
        while(currentNode != null) {
            s += currentNode.toString() + "\n";
            currentNode = currentNode.getNext();
        }
        return s;
    }
}
