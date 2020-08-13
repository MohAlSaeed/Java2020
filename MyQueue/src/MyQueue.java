public class MyQueue <E>{

    private class Node {
        E data;
        Node next = null;
        Node(E d){
            data = d;
        }
    }
    Node head;
    Node tail;
    int size = 0;

    public MyQueue(){
        head = tail = null;
    }

    public void addtoqueue(E d){
        size++;
        if (head == null) {
            head = tail = new Node(d);
        } else
            tail = tail.next = new Node(d);
    }

    public E getqueue(){
        E d = head.data;
        if ((head = head.next) == null) {
            tail = null;
        }
        return d;
    }

    public boolean empty(){
        return head == null;
    }
}
