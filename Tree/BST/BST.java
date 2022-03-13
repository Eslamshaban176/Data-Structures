public class BST {
    private class Node{
            int data;
            Node left, right;
            Node(int value){
                data = value;
                left = right = null;
            }
    }
    private Node root;
    public BST(){
		root = null;
    }

    Node Insert(Node Root, int item){
	if (Root == null){
		Node newnode = new Node(item);
		Root = newnode;
	}

	else if (item < Root.data)
            Root.left = Insert(Root.left, item);
	else
            Root.right= Insert(Root.right, item);
	
            return Root;
    }

    void Insert(int item){
        root= Insert(root, item);
    }

    public void preOrder() {
        preOrder(this.root);
    }

    private void preOrder(Node node) {
        if (node == null) 
            return;
        System.out.print( node.data+" ");
        preOrder(node.left);
        preOrder(node.right);    
    }
    public void postOrder() {
	postOrder(this.root);
    }

    private void postOrder(Node node) {
        if (node == null) 
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print( node.data+" ");      
    }
    public void inOrder() {
	inOrder(this.root);
    }

    private void inOrder(Node node) {
	if (node == null) 
            return;
        inOrder(node.left);
        System.out.print( node.data+" ");
        inOrder(node.right);        
    }
    Node Search(Node Root, int key){
	if (Root == null)
            return null;
	else if (Root.data == key)
            return Root;
	else if (key < Root.data)
       	    return Search(Root.left, key);
	else
            return Search(Root.right, key);
    }

    boolean Search(int key){
        Node result = Search(root, key);
        return (result == null);
    }

    Node Findmin(Node Root){
	if (Root == null)
            return null;
	else if (Root.left == null)
            return Root;
	else
            return Findmin(Root.left);
    }

    Node Findmax(Node Root){
	if (Root == null)
            return null;
	else if (Root.right == null)
            return null;
	else
            return Findmax(Root.right);
    }

    Node Delete(Node Root, int key){
	if (Root == null) // Empty Tree
            return null;
	if (key < Root.data) // Item exists in left sub tree
            Root.left = Delete(Root.left, key);
	else if (key > Root.data) // item exists in right sub tree
            Root.right =Delete(Root.right, key);
	else{
            if (Root.left == null && Root.right == null) // leaf node
		Root = null;
            else if (Root.left != null && Root.right == null){ // one child on the left
		Root.data = Root.left.data;
		Root.left = null;
            }
            else if (Root.left == null && Root.right != null){ // one child on the right
		Root.data = Root.right.data;
                Root.right = null;
            }else{
                Node max = Findmax(Root.left);
                Root.data = max.data;
                Root.left = Delete(Root.left, max.data);
            }
        }
	return Root;
    }
}