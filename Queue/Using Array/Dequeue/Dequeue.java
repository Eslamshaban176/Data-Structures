

public class Deque<Type> {
    private int front , rear , size,MAX_SIZE;
    private final Type deque[];
    public Deque(int MAX_SIZE){
        this.MAX_SIZE = MAX_SIZE;
        deque =(Type[]) new Object[MAX_SIZE];
        front = rear = -1;
        size = 0;
    }
    boolean isEmpty(){
        return (rear == -1 && front == -1);
    }
    boolean isFull(){
        return (rear == (front - 1) % MAX_SIZE);
    }
    void insertFront(Type val){
        if(isFull()) return;
        else if(isEmpty()) front = rear = 0;
        else if(front == 0 ) front = MAX_SIZE-1;
        else front = (front -1) % MAX_SIZE;
        deque[front] = val;
        size++;
    }
    
    void insertRear(Type val){
        if(isFull()) return;
        else if(isEmpty()) front = rear = 0;
        else rear = (rear + 1) % MAX_SIZE;
        deque[rear] = val;
        size++;
    }
    Type front(){
        if(!isEmpty()) return deque[front];
        return null;
    }
    Type rear(){
        if(!isEmpty()) return deque[rear];
        return null;
    }
    int Size(){
        return size;
    }
    Type removeFront(){
        if(!isEmpty()){
            Type temp = deque[front];
            if(front == rear) front = rear = -1;
            else front = (front+1) % MAX_SIZE;
            size--;
            return temp;
        } return null;
    }
     Type removeRear(){
        if(!isEmpty()){
            Type temp = deque[rear];
            if(front == rear) front = rear = -1;
            else rear = (rear-1) % MAX_SIZE;
            size--;
            return temp;
        } return null;
    }
     void display(){
         if(!isEmpty()){
             int max = rear;
             if(front > rear) max = front;
             int temp = 0;
             System.out.print("Elements in deque ");
             while(temp <= max){
                 if(deque[temp] != null)
                 System.out.print(deque[temp]+" ");
                 temp++;
             }
         }
     }
}
