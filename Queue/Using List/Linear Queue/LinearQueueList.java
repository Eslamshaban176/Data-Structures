

public class QueueList<Type> {
    private class Node{
        Type data;
        Node next;
        Node(Type data){
            this.data = data;
            next = null;
        }
    }
    private Node rear,front;
    public QueueList(){
        rear = front = null;
    }
    boolean isEmpty(){
        return (front == null && rear == null);
    }
    void enqueu(Type data){
        Node newNode = new Node(data);
        if(isEmpty()){
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }
    Type dequeue(){
        if(isEmpty()) return null;
        Type temp = front.data;
        if(front == rear) front = rear = null;
        else front = front.next;
        return temp;
    }
    
    Type getFront(){
        if(!isEmpty())
             return front.data;
        return null;
    }
    Type getRear(){
        if(!isEmpty())
             return rear.data;
        return null;
    }
    void display(){
        if(!isEmpty()){
            Node temp = front;
            while(temp != rear.next){
                System.out.println(temp.data+" ");
                temp = temp.next;
            }
        }
    }
}
