


public class DCLL<Type> {
    private class Node{
        Type data;
        Node prev,next;
        Node(Type data){
            this.data = data;
            prev = null;
            next = head;
        }
    }
    private Node head;
    public DCLL(){
        head = null;
    }
    void append(Type data){
        Node node = new Node(data);
        if(head == null){
            head = node;
            node.next = head;
            node.prev = head;
        }
        else{
            Node temp = head.prev;
           node.prev = temp;
           temp.next = node;
           node.next = head;
           head.prev = node;
        }
     
    }
    void insert(Type data,int pos){
        Node node = new Node(data);
        if(head == null){
            head=node;
            node.next = head;
            head.prev = head;
            return;
        }
        if(pos == 0){
         
            Node temp = head.prev;
            node.next = head;
            node.prev = head.prev;
            head.prev = node;
            head = node;
            temp.next = head;
            return;
        }
        Node temp = head;
        for(int i = 0; i < pos && temp.next != head;i++)
            temp = temp.next;
        if(temp.next == head){
            this.append(data);
            return;
        }
        node.prev = temp.prev;
        temp.prev.next = node;
        node.next = temp;
        temp.prev =node;
            
    }
    void remove(Type key){
        if(head == null) return;
        if(key == head.data){
            Node temp = head.prev,p =head;
            head = head.next;
            if(head != p){ //not one node
                temp.next = head;
                head.prev = temp; 
            }else head = null;
        }else{
            Node temp =head.next;
            while(temp != head && key != temp.data)
                temp = temp.next;
            if(temp != head) {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }
            else{
                // last node
                temp.prev.next = head;
                head.prev = temp.prev;
            }
        }
    }
    void removePos(int pos){
        if (head == null)
            return;
	Node temp,p;
	if (pos == 0){
            temp = head.prev;
            p = head;
            head = head.next;
		if (head != p){ // not one node
                    head.prev = temp;
                    temp.next = head;
                }else head = null;
	}else{
            temp = head.next;
            for (int i = 0; i < pos-1 && temp.next != head; i++)
                temp = temp.next;

            if (temp.next == head && head.next != temp){
                temp.prev.next = head;
                head.prev = temp.prev;
            }else if(temp.next == head && head.next == temp)
                head = null;
            else{
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }
        }
    }
    void display(){
        if(head != null){
        Node temp = head.next;
        System.out.print(head.data+" ");
	while (temp != head){
            System.out.print(temp.data +" ");
            temp = temp.next;
        }
	System.out.println("");
        }
    }
    void printReverse(){
        if(head != null){
            Node temp = head.prev;
            while (temp != head){
                System.out.print(temp.data+" ");
                temp = temp.prev;
            }
            System.out.print(temp.data+"\n");
         }
    }
}
