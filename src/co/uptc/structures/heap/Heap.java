package co.uptc.structures.heap;

import java.util.Comparator;

import co.uptc.structures.simple_list.MySimpleList;

public class Heap<T> {
	
	private NodeHeap<T> root;
    private NodeHeap<T> last;
    private Comparator<T> comparator;
    private MySimpleList<T> simpleList; //Lista para testeo

    public Heap(Comparator<T> comparator) {
        this.root = null;
        this.last = null;
        this.comparator = comparator;
        this.simpleList = new MySimpleList<T>();
    }

    public NodeHeap<T> getRoot() {
        return root;
    }

    public void setRoot(NodeHeap<T> root) {
        this.root = root;
    }
    
    public boolean isEmpty() {
       return (this.root == null);
    }
    
    public void put(T info) {
    	this.simpleList.add(info);
        add(info);
        bubleUp();
    }
    
    private void add(T info) {
        if (this.last != null && this.last.father != null) {
            if (this.last.father.right == null) {
                this.last = this.last.father.setRight(new NodeHeap<>(info, this.last.father));
            } else {
                while (this.last.father != null && this.last == this.last.father.right) {
                    this.last = this.last.father;
                }
                if (this.last != this.root) {
                    this.last = this.last.father.right;
                }
                while (this.last.left != null) {
                    this.last = last.left;
                }
                this.last = this.last.setLeft(new NodeHeap<>(info, this.last));
            }
        } else {
            if (this.last == null) {
                this.last = this.root = new NodeHeap(info, null);
            } else {
                this.last = this.last.setLeft(new NodeHeap(info, this.last));
            }
        }
    }
    
    public T get(){
      T aux = this.root.info;
      this.root.info = this.last.info;
      deleteLast();
      sinkDown();
      return aux;
    }
    
    private void swap(NodeHeap<T> a, NodeHeap<T> b) {
        T aux = a.info;
        a.info = b.info;
        b.info = aux;
    }
    
    private void bubleUp(){
      NodeHeap<T> NodeHeap = this.last;
      while (NodeHeap.father!=null) {
          if (comparator.compare(NodeHeap.info,NodeHeap.father.info)<0){
              swap(NodeHeap,NodeHeap.father);
          }
          NodeHeap = NodeHeap.father;
      }
    }
    
    private void deleteLast() {
        if (this.last.father != null) {
            if (this.last.father.right != null) {
                this.last = this.last.father.left;
                this.last.father.right = null;
            } 
            else {
                NodeHeap <T> auxLast = last; 
                // up..
                while (this.last.father != null && this.last.father.left == this.last) {
                    this.last = this.last.father;
                }
                if (this.last.father == null) { // LLEGA A RAIZ POR LEFT...
                    while (this.last.right != null) {
                        this.last = last.right;
                    }
                } else {
                    this.last = this.last.father.left;
                    // down
                    while (this.last.right != null) {
                        this.last = this.last.right;
                    }
                }
                auxLast.father.left = null;
            }
        }
        else { 
           this.root = this.last = null;
        }
    }

    private void sinkDown() {
        NodeHeap<T> NodeHeap = this.root;
        while (NodeHeap != null) {
            if (NodeHeap.left!=null && comparator.compare(NodeHeap.info, NodeHeap.left.info) > 0 ||
                NodeHeap.right!=null && comparator.compare(NodeHeap.info, NodeHeap.right.info) > 0) {
                if ((NodeHeap.left!=null && NodeHeap.right!=null && 
                    comparator.compare(NodeHeap.left.info, NodeHeap.right.info) < 0) ||
                    NodeHeap.right==null) {
                    swap(NodeHeap,NodeHeap.left);
                    NodeHeap = NodeHeap.left;
                } else {
                    swap(NodeHeap, NodeHeap.right);
                    NodeHeap = NodeHeap.right;
                }
                
            }
            else {
               NodeHeap=null;
            }
        }
    }
    
	public void inOrder(NodeHeap<Integer> rootAux) {
		if (rootAux != null) {
			this.inOrder(rootAux.getLeft());
			System.out.println(rootAux.getInfo());
			this.inOrder(rootAux.getRight());
		}
	}

}
