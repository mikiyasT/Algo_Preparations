package stringExercicses;

public class BinarySearchTree {

	static Node root;
	static Node getRoot(){
		return root;
	}
	public BinarySearchTree(){}
	
	public void insert(int data){
		root = insertNode(root,data);
	}
	public void delete(int data){
		root = removeNode(root,data);
	}
	
	public static Node removeNode(Node node, int data){
		if(node == null)
			return null;
		else if(data < node.data){ //search left subtree untill u find data
			node.left = removeNode(node.left,data);
		}
		else if(data > node.data){ //search right subtree untill u find data
			node.right = removeNode(node.right,data);
		}
		else if(node.left != null && node.right != null){
			 //found the node and it has left and right children.
			//make the data equal to the min of the right subTree
			//remove the min node data searching down from the right tree[go down the tree and remove this node containing the min val, because it is already copied up on the removed node]
			node.data = findMin(node.right).data;
			node.right = removeNode(node.right,node.data);
		}
		else{
			node = (node.left != null) ? (node.left) :(node.right);
		}
		return node;
	}
	static Node findMin(Node node){
		if(node == null)
			return null;
		else if(node.left == null)//if left subtree of this node is null, then this node is the smallet as compared to the remaining right subtree elems
			return node;
		else
			return findMin(node.left);
		
		
	}
	
	public static Node insertNode(Node node,int data){
		if(node == null){
			node = new Node(data);			
		}
		else
		{
			if(data <= node.data)
			{
				node.left = insertNode(node.left,data);				
			}			
			else 
			{
				node.right = insertNode(node.right,data);				
			}			
		}
		return node;
	}
	//print tree
	public static void printTreePreOrder(Node root){
		if(root == null){
			//System.out.println("Node is empty");
			return;
		}
		//pre order
		System.out.println(root.data);
		printTreePreOrder(root.left);
		printTreePreOrder(root.right);
		
		//inorder
		//printTreePreOrder(root.left);
		//System.out.println(root.data);
		//printTreePreOrder(root.right);
		
		//postorder
		//printTreePreOrder(root.left);
		//printTreePreOrder(root.right);
		//System.out.println(root.data);
		
	}
	
	
	public static void main(String[] args) {
		int[] numbers = new int[]{23,45,67,34};
		BinarySearchTree tree = new BinarySearchTree();
		//Node treeRoot = tree.getRoot();
		
		for(int i = 0; i < 4;i++){
			System.out.println("inserting node " + numbers[i]);
			tree.insert(numbers[i]);
		}
		
		//print tree
		System.out.println("Start printing");
		tree.printTreePreOrder(tree.getRoot());
		System.out.println("Done printing");

		System.out.println("Start printing after removing 45");
		tree.delete(45);
		tree.printTreePreOrder(tree.getRoot());
		System.out.println("Done printing after removing 45");
		
		System.out.println("Start printing after inserting 45 back");
		tree.insert(45);
		tree.printTreePreOrder(tree.getRoot());
		System.out.println("Done printing after inserting 45");
	}

}

 class Node{
	int data;
	Node left,right;
	
	
	Node(){
		
	}
	
	Node(int d){
		data 	= d;
		left 	= null;
		right	= null;
			
	}
	Node(int d, Node l, Node r){
		data = d;
		left = l;
		right = r;
	}
	
}


