package co.uptc.structures.avl;

/**
 * Clase NodeAVL - Nodo del AVL
 * 
 * @author Yohan Caro
 * @version 1.0 - 10/10/2018
 *
 * @param <T> Tipo de objeto
 */
public class NodeAVL<T> {

	protected T info;
	protected NodeAVL<T> right;
	protected NodeAVL<T> left;
	protected int balance;

	public NodeAVL(T info, NodeAVL<T> right, NodeAVL<T> left) {
		this.info = info;
		this.right = right;
		this.left = left;
		balance = 0;
	}

	public NodeAVL(T info) {
		this.info = info;
		balance = 0;
	}
	
	public T getInfo() {
		return info;
	}
	
	public NodeAVL<T> getLeft() {
		return left;
	}
	
	public NodeAVL<T> getRight() {
		return right;
	}
	
	public void setInfo(T info) {
		this.info = info;
	}
		
	public void setLeft(NodeAVL<T> left) {
		this.left = left;
	}
	
	public void setRight(NodeAVL<T> right) {
		this.right = right;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
}
