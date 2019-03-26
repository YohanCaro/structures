package co.uptc.structures.binary_tree;

import java.util.Comparator;

import co.uptc.structures.simple_list.MySimpleList;

public class BinaryTree<T> {
	
	private NodeBinaryTree<T> root;
	private Comparator<T> comparator;
	private MySimpleList<T> simpleList;

	public BinaryTree(NodeBinaryTree<T> root) {
		this.root = root;
		simpleList = new MySimpleList<>();
	}
	
	public BinaryTree(Comparator<T> comparator) {
		this.root = null;
		this.comparator = comparator;
		simpleList = new MySimpleList<>(comparator);
	}

	public boolean isEmpty() {
		return this.root==null;
	}
	
	public void add(T info) {
		this.add(new NodeBinaryTree<T>(info), this.root);
	}
	
	private void add(NodeBinaryTree<T> aux, NodeBinaryTree<T> root) {
		if (root == null) {
			this.setRoot(aux);
		} else {
			if (this.comparator.compare(root.info, aux.info) > 0) {
				if (root.getLeft() == null) {
					//Añada a la izq
					root.setLeft(aux);
				} else {
					//Avance
					this.add(aux, root.getLeft());
				}
			} else {
				if (root.getRight() == null) {
					//Añada a la der
					root.setRight(aux);
				} else {
					//Avance
					this.add(aux, root.getRight());
				}	
			}
		}
	}
	
	//N
    public void addAVL(T info) { 
        if(this.root == null) { 
        	this.root =  new NodeBinaryTree<T>(info); 
        } else { 
            this.addAVL(this.root, info); 
        } 
    }
    
    private void addAVL(NodeBinaryTree<T> rootAux, T info) { 
        if (rootAux == null) {
        	rootAux = new NodeBinaryTree<T>(info);
        } else if(comparator.compare(info, rootAux.info) >= 0) {
        	
        }
    }
    
    private void rotationLeft(NodeBinaryTree<T> rootAux) {
    	NodeBinaryTree<T> aux = rootAux.right;
    	rootAux.right = aux.left;
    	
    }
    
    private void rotationRight(NodeBinaryTree<T> rootAux) {
    	NodeBinaryTree<T> aux = root.left;
    	rootAux.left = aux.right;
    	rootAux.right = rootAux;
    	rootAux.setBalance(Math.max(rootAux.left.getBalance(), rootAux.right.getBalance()) + 1);
    }
    
    private void doubleRotationLeft(NodeBinaryTree<T> rootAux) {
    	
    }
    
    private void doubleRotationRight(NodeBinaryTree<T> rootAux) {
    	
    }
	
	public int getBalance(NodeBinaryTree<T> rootAux) {
		return (rootAux == null)?-1:rootAux.balance;
	}
	
    //AVL
	public void remove(T info, NodeBinaryTree<T> rootAux) {
		if (rootAux.info == info) {
			this.simpleList.remove(rootAux.info);
			if (this.searchMinor(info) != null) {
				NodeBinaryTree<T> aux = this.searchMinor(info);
				rootAux.info = aux.info;
				aux = null;
			} else {
				rootAux = null;
			}
		} else {
			if (this.comparator.compare(rootAux.info, info) > 0) {
				if (rootAux.getLeft() != null) {
					this.remove(info, rootAux.getLeft());
				}
			} else {
				if (rootAux.getRight() != null) {
					this.remove(info, rootAux.getRight());
				} 	
			}
		}
	}
	
	public NodeBinaryTree<T> searchMinor(T info) {
		NodeBinaryTree<T> aux = this.search(info, this.root);
		NodeBinaryTree<T> ant = null;
		aux = aux.getLeft();
		while (aux != null) {
			ant = aux;
			aux = aux.getRight();
		}
		return ant;
	}
	
	public boolean exist(T info) {
		return this.search(info, this.root)!=null;
	}
	
	public NodeBinaryTree<T> search(T info, NodeBinaryTree<T> rootAux) {
		NodeBinaryTree<T> aux = null;
		if (rootAux.info == info) {
			aux = rootAux;
		} else {
			if (this.comparator.compare(rootAux.info, info) > 0) {
				if (rootAux.getLeft() != null) {
					aux = this.search(info, rootAux.getLeft());
				}
			} else {
				if (rootAux.getRight() != null) {
					aux = this.search(info, rootAux.getRight());
				} 	
			}
		}
		return aux;
	}
	
	public void inOrder(NodeBinaryTree<T> rootAux) {
		if (rootAux != null) {
			this.inOrder(rootAux.getLeft());
			simpleList.addLast(rootAux.info);
			this.inOrder(rootAux.getRight());
		}
	}
	
	public void preOrder(NodeBinaryTree<T> rootAux) {
		if (rootAux != null) {
			simpleList.addLast(rootAux.info);
			this.preOrder(rootAux.getLeft());
			this.preOrder(rootAux.getRight());
		}
	}
	
	public void postOrder(NodeBinaryTree<T> rootAux) {
		if (rootAux != null) {
			this.postOrder(rootAux.getLeft());
			this.postOrder(rootAux.getRight());
			simpleList.addLast(rootAux.info);
		}
	}
	
	public void levelOrder(NodeBinaryTree<T> rootAux) {		
		
//		if (rootAux != null) {
//			if (this.simpleList.search(rootAux.getInfo()) == null) {
//				this.simpleList.addLast(rootAux.getInfo());
//			}
//			if (rootAux.left != null && rootAux.rigth != null) {
//				this.simpleList.addLast(rootAux.left.info);
//				this.simpleList.addLast(rootAux.rigth.info);
//				this.levelOrder(rootAux.left);
//				this.levelOrder(rootAux.rigth);
//			} else if (rootAux.left != null) {
//				this.simpleList.addLast(rootAux.left.info);
//				this.levelOrder(rootAux.left);
//			} else if (rootAux.rigth != null) {
//				this.simpleList.addLast(rootAux.rigth.info);
//				this.levelOrder(rootAux.rigth);
//			}
//		}
	}
	
	private void imprimirEntreConNivel(NodeBinaryTree<T> aux, int nivel){
	     if(aux !=null){
	          imprimirEntreConNivel(aux.getLeft(), nivel + 1);
	          System.out.println(aux.info + "(" + nivel + ") - ");
	          imprimirEntreConNivel(aux.getRight(), nivel+1);
	     }
	}
	 
	public void imprimirEntreConNivel(){
		imprimirEntreConNivel(this.root, 1);
		System.out.println();
	}
	
	public void restartList() {
		simpleList = new MySimpleList<>();
	}
	
	public NodeBinaryTree<T> getRoot() {
		return root;
	}
	
	public MySimpleList<T> getSimpleList() {
		return simpleList;
	}
	
	public void setRoot(NodeBinaryTree<T> root) {
		this.root = root;
	}
}
