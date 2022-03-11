

public class LinkedList<Type> {
    private class Node{
        Type val;
        Node next;
        public Node(Type item){
            val = item;
            next = null;
        }
    }
    private static int SIZE;    
    private Node head,cur;
    public LinkedList(){
        head = null;
        SIZE = 0;
    }
    boolean isEmpty(){
        return (head == null);
    }
    public void insert(Type item){
        Node newNode= new Node(item);
        if(isEmpty()){
            head = newNode;
            SIZE++;
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
        SIZE++;
    }
    public void insert(Type item,int pos){
        Node newNode= new Node(item);
        if(isEmpty() || pos == 0){
            newNode.next = head;
            head = newNode;
            SIZE++;
            return;
        }
        Node temp = head;
       for(int i = 0 ; i < pos-1 && temp.next != null;i++){
           temp = temp.next;
        }
        newNode.next = temp;
        temp.next = newNode;
        SIZE++;
    }
    Type remove(Type data){
        Node temp = head;
        if(isEmpty()) return null ;
        if(data == temp.val){
            head = temp.next;
            SIZE--;
            return temp.val;
        }
        Node prev = temp;
        while(temp.next != null && temp.val != data){
            prev = temp;
            temp = temp.next;
        }
        if(temp == null) return null;
        prev.next = temp.next;
        SIZE--;
        return temp.val;
    }
    Type remove(int pos){
        Node temp = head;
        if(isEmpty()) return null ;
        if(pos == 0){
            head = temp.next;
            SIZE--;
            return temp.val;
        }
        for(int i = 0; i< pos-1 && temp.next != null;i++){
            temp = temp.next;
        }
        if(temp.next == null) return null;
        temp.next = temp.next.next;
        SIZE--;
        return temp.val;
    }
    int size(){
        return SIZE;
    }
    void display(){
            cur = head;
            while(cur != null){
                System.out.println(cur.val);
                cur = cur.next;
            }
    }
    void printReverse(Node temp){
        if(temp == null) return;
        printReverse(temp.next);
        System.out.println(temp.val);
    }
    // print All Elements in reverese
    void printReverse(){
        Node temp = head;
        printReverse(temp);
    }
    // reverse linkel list
   // 6 -> 7 -> 8 -> 9 -> null       linked list
  //  null <- 6 <- 7 <- 8 <- 9       reverse linked list
    void reverse(Node temp){
        // recursion
        if( temp.next == null){
            head = temp;
            return ;
        }
        reverse(temp.next);
        Node list = temp.next;
        list.next = temp;
        temp.next = null;
       
    }
    void reverse(){
        Node temp = head;
        reverse(temp);
    }
    
    boolean search(Type data){
        if(isEmpty()) return false;
        Node temp = head;
        while(temp != null){
            if(temp.val == data){
                return true;
            }
            temp = temp.next;
        }
     
        return false;
    }
}
