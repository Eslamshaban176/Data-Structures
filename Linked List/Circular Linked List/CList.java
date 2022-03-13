
public class CircularList {
    private class Node {
	int data;
	Node next;
	public Node(int data) {
            this.data = data;
            next= null;
	}
    }
    private Node head;
    public CircularList(){
        head = null;
    }
   
    void insert(int data){
        Node newNode= new Node(data);
        if(head == null){
            head = newNode;
        }else{
            Node p = head;
            while(p.next != head){
                p = p.next;
            }
            p.next = newNode;
        }
        newNode.next= head;
    }

    void remove(int key){
        Node curr=head ;
        Node prev = head;
        if(head == null) return;
         // Check if node is only node
        if(head.data == key && curr.next == head){
            head =null;
            return;
        }
        while (curr.data != key) {
            if (curr.next == head) 
                break;
            prev = curr;
            curr = curr.next;
        }
         if (curr == head) {
            prev = head;
            while (prev.next != head)
                prev = prev.next;
            head = curr.next;
            prev.next = head;
        }
 
        // check if node is last node
        else if (curr.next == head)
            prev.next = head;
        else 
            prev.next = curr.next;
        
            
        
    }
    

    void display(){
        if(head != null){
            Node cur = head.next;
            System.out.println(head.data+" ");
            while(cur != head){
                System.out.println(cur.data+" ");
                cur = cur.next;
            }
        }
    }
}
