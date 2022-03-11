
package basics;

public class StackList<T>{
    private class Node{
        T data;
        Node next;
        Node(T data){
            this.data = data;
            next = null;
        }
    }
    private Node top,cur;
    StackList(){
        top = null;
    }
    boolean isEmpty(){
        return (top == null);
    }
    void push(T item){
        Node temp = new Node(item);
        if(top == null){
            top = temp;
            return;
        }
        temp.next = top;
        top = temp; 
    }
    T pop(){
        if(isEmpty()) return null;
        T temp = top.data;
        top = top.next; 
        return temp;    
    }
    T getTop(){
        if(!isEmpty()) return top.data;
        return null;
    }
    void display(){
        if(!isEmpty()){
          cur = top;
          while(cur != null){
              System.out.println(cur.data);
              cur = cur.next;
          }
        }
    }
    
}
