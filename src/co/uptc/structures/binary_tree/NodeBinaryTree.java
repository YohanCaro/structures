package co.uptc.structures.binary_tree;

public class NodeBinaryTree<T> {

	protected T info;
	protected NodeBinaryTree<T> right;
	protected NodeBinaryTree<T> left;
	protected int balance;

	public NodeBinaryTree(T info, NodeBinaryTree<T> right, NodeBinaryTree<T> left) {
		this.info = info;
		this.right = right;
		this.left = left;
		balance = 0;
	}

	public NodeBinaryTree(T info) {
		this.info = info;
		balance = 0;
	}
	
	public T getInfo() {
		return info;
	}
	
	public NodeBinaryTree<T> getLeft() {
		return left;
	}
	
	public NodeBinaryTree<T> getRight() {
		return right;
	}
	
	public void setInfo(T info) {
		this.info = info;
	}
		
	public void setLeft(NodeBinaryTree<T> left) {
		this.left = left;
	}
	
	public void setRight(NodeBinaryTree<T> right) {
		this.right = right;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
}
