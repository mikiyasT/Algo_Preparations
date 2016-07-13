package BinarySearchTreeGeneric;

import java.util.Comparator;
import java.util.Iterator;

public class BinarySearchTreeGeneric<T extends Comparable<T>> implements Iterable<T>{
	private Node<T> root;
	private Comparator<T> comparator;
	
	public BinarySearchTreeGeneric(){
		root = null;
		comparator = null;
	}
	
	public BinarySearchTreeGeneric(Comparator comp){
		root = null;
		comparator = comp;
	}
	
	private int compare(T x, T y){
		if(comparator == null) return x.compareTo(y);
		else
			return comparator.compare(x,y);
	}
	
	public void insert(T data){
		root = insertNode(root,data);
	}

	private Node insertNode(Node<T> n, T data) {
		if(n == null)
			n = new Node<T>(data);
		else{
			if( compare(data,n.data) == 0)
				return n;
			else if(compare(data,n.data) < 0)
				n.left = insertNode(n.left,data);
			else
				n.right = insertNode(n.right,data);
			return n;
		}
		
		return n;
	}
	
	public void delete(T data){
		root = deleteNode(root,data);
	}
	
	public Node deleteNode(Node<T> n, T data){
		if(n == null)
			return null;
		else{
			if( compare(data,n.data) < 0){
				n.left = deleteNode(n.left,data);
			}
			else if(compare(data,n.data) > 0){
				n.right = deleteNode(n.right,data);
			}
			else{
				if(n.left != null && n.right != null){
					n.data = (T) findMin(n.right).data;
					n.right = deleteNode(n.right,n.data);
				}
				else
					n = (n.left == null) ? (n.right) : (n.left);
			}
		}
		return n;
	}
	
	private Node findMin(Node<T> node) {
		if(node == null)
			return null;
		else if( node.left == null)
			return node;
		else return findMin(node.right);
	}

	private class Node<T>{
		
		T data;
		Node<T> left, right;
		
		public Node(T d, Node<T> r, Node<T> l){
			this.data = d;
			this.left = l;
			this.right = r;
		}
		
		public Node(T d){
			this(d,null,null);
		}
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
}


