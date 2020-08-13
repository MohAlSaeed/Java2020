public class MyQueue2 <D>{
    private class Buffer{
        D data;
        Buffer next;
        Buffer(D d){
            this.data = d;
        }
    }
    Buffer head;
    Buffer tail;
    int size;

    public MyQueue2(){
        head = tail = null;
    }

    public void addtoMyQueue2 (D i){
        size++;
        if (head == null) {
            head = tail = new Buffer(i);
        } else
            tail = tail.next = new Buffer(i);
    }

    public D getQueue(){
        D out = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return out;
    }

    public boolean empty(){
        return head == null;
    }
}
