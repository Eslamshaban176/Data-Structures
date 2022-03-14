

public class DoublyLinkedList<Type> {
    private class Node{
        Type data;
        Node prev,next;
        Node(Type data){
            this.data = data;
            prev =next =null;
        }
    }
    private Node head;
    public DoublyLinkedList(){
        head = null;
    }
    void append(Type data){
        Node node = new Node(data);
        if(head == null){
            head = node;
        }else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = node;
            node.prev = temp;
        }
    }
    void inset(Type data,int pos){
        Node node = new Node(data);
        if(head == null){
            head=node;
            return;
        }
        if(pos == 0){
            node.next =head;
            head.prev = node;
            head = node;
            return;
        }
        Node temp = head;
        for(int i = 0; i < pos && temp != null;i++)
            temp = temp.next;
        if(temp == null){
            this.append(data);
            return;
        }
        node.prev = temp.prev;
        temp.prev.next = node;
        temp.prev =node;
        node.next = temp;
            
    }
    void remove(Type key){
        if(head == null) return;
        if(key == head.data){
            head = head.next;
            if(head != null)
                head.prev = null;
            return;
        }
        Node temp =head;
        while(temp != null && key != temp.data)
            temp = temp.next;
        if(temp == null) return;
        else{
            temp.prev.next = temp.next;
            if(temp.next != null)
                temp.next.prev = temp.prev;
        }
    }
    void removePos(int pos){
        if (head == null)
            return;
	Node temp = head;
	if (pos == 0){
            head = temp.next;
		if (head != null)
                    head.prev = null;
            return;
	}

	for (int i = 0; i < pos && temp != null; i++)
            temp = temp.next;

	if (temp == null)
            return;

	temp.prev.next = temp.next;
	if (temp.next != null)
            temp.next.prev = temp.prev;
    }
    void display(){
	Node temp = head;
	while (temp != null){
            System.out.print(temp.data +" ");
            temp = temp.next;
	}
	System.out.println("");
    }
    void printReverse(){
        Node temp = head;
	while (temp.next != null){
            temp = temp.next;
	}
	while (temp != null){
	    System.out.print( temp.data + " ");
            temp = temp.prev;
	}
        System.out.println("");
    }
}
