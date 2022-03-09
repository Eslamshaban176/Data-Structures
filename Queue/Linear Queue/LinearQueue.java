

public class Queue <type> {
    int Size;
    private int rear,front;
    private final type Queue[];
    public Queue(int Size){
        this.Size = Size;
       Queue =(type[]) new Object[Size];
       front = rear = -1;
    }
    boolean isEmpty(){
        return (front == -1 && rear == -1);
    }
    boolean isFull(){
        return (rear == Size - 1);
    }
    void enqueue(type val){
        if(isFull()) return;
        else if(isEmpty()) front = rear = 0;
        else rear++;
        Queue[rear] = val;
    }
    type dequeue(){
        type temp = null;
        if(isEmpty()) return null;
        else if(front == rear) front= rear = -1;
        else {
            temp = Queue[front];
            front++; 
            return temp;
        }
        return null;
    }
    type peek(){
        if(!isEmpty())
            return Queue[front];
        return null;
    }
    void display(){
        if(!isEmpty()){
            for(int i=front;i <=rear;i++)
                System.out.println(Queue[i]);
        }
    }
}
