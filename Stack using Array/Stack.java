
import java.util.ArrayList;
public class Stack<T> {
   ArrayList<T> A;
   private int top,Size;
    public Stack(int Size){
      top = -1;
      this.Size = Size;
      this.A = new ArrayList<>(Size);   
    }
    boolean isEmpty(){
        return (top == -1);
    }
    boolean isFull(){
        return (top == Size-1);
    }
    void push(T val){
        if(isFull()) return ;
        else{
            ++top;
            if(A.size() > top) A.set(top, val);
            else A.add(val);
        }
    }
    void pop(){
        if(!isEmpty()) --top;
    }
    T peak(){
        if(!isEmpty())return A.get(top);
        return null;
    }
    
    void display(){
        if(!isEmpty())
             for(int i = top;i>=0;i--)
                 System.out.println(A.get(i));
    }
}
