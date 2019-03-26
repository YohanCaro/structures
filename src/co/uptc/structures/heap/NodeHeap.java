package co.uptc.structures.heap;

/**
 * Clase que crea un Node de un Heap
 * Fecha 17/02/2019
 * @author Yohan Caro
 * 
 * @param <T> Clase del objeto
 */
public class NodeHeap<T> { 
	
	protected T info;
    protected NodeHeap<T> left;
    protected NodeHeap<T> right;
    protected NodeHeap<T> father;

    public NodeHeap(T info, NodeHeap<T> father) {
        this.info = info;
        this.father = father;
        this.left = null;
        this.right = null;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NodeHeap<T> getfather() {
        return father;
    }

    public void setfather(NodeHeap<T> father) {
        this.father = father;
    }

    public NodeHeap<T> getLeft() {
        return left;
    }

    public NodeHeap<T> setLeft(NodeHeap<T> left) {
        this.left = left;
        return left;
    }

    public NodeHeap<T> getRight() {
        return right;
    }

    public NodeHeap<T> setRight(NodeHeap<T> right) {
        this.right = right;
        return right;
    }
    
    public NodeHeap<T> setLeft(T info) {
       NodeHeap NodeHeap= new NodeHeap(info,this);
       this.setLeft(NodeHeap);
       return NodeHeap;
    }
    
    public NodeHeap<T> setRight(T info) {
       NodeHeap NodeHeap= new NodeHeap(info,this);
       this.setRight(NodeHeap);
       return NodeHeap;
    }
    
    public NodeHeap<T> getFather() {
		return father;
	}

}
