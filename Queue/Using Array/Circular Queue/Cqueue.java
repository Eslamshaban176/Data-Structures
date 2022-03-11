

public class CircularQueue<Type> {
   private int rear,front,Size;
   private final Type Queue[];
   public CircularQueue(int Size){
       this.Size = Size;
       Queue  =(Type[]) new Object[Size];
       rear = front = -1;
   }
   boolean isEmpty(){
       return (front == -1 && rear == -1);
   }
   boolean isFull(){
       return (rear == (front-1) % Size );
   }
   void enqueu(Type val){
       if(isFull()) return;
       else if(isEmpty()) front = rear = 0;
       else rear = (rear + 1) % Size;
       Queue[rear] = val;
   }
   Type dequeu(){
       Type temp = null;
       if(isEmpty()) return null;
       else if(rear == front) front = rear = -1;
       else {
           temp = Queue[front];
           front = (front + 1) % Size;
       }
       return temp;
   }
   
   Type front(){
       if(!isEmpty()) return Queue[front];
       return null;
   }
   void display() {
    int i;
    if (isEmpty()) {
        return;
    } else {
      System.out.println("Front  " + front);
      System.out.println("Items in Cqueue  ");
      for (i = front; i != rear; i = (i + 1) % Size)
        System.out.print(Queue[i] + " ");
      System.out.println(Queue[i]);
      System.out.println("Rear  " + rear);
    }
  }

}
