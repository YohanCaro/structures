package co.uptc.structures.avl;

import java.util.Comparator;

import co.uptc.structures.simple_list.MySimpleList;

/**
 * Clase AVL - (Arbol Binario de Busqueda Balanceado)
 * 
 * @author Yohan Caro
 * @version 1.1 - 10/10/2018
 *
 * @param <T> Tipo de elemento a agregar en el arbol
 */
public class AVL<T> {
	
	private NodeAVL<T> root;
	private Comparator<T> comparator;
	private MySimpleList<T> simpleList;

	public AVL(NodeAVL<T> root) {
		this.root = root;
		simpleList = new MySimpleList<>();
	}
	
	public AVL(Comparator<T> comparator) {
		this.root = null;
		this.comparator = comparator;
		simpleList = new MySimpleList<>(comparator);
	}

	public boolean isEmpty() {
		return this.root==null;
	}
	
	public void addAVL(T info) { 
		if (this.root == null) {
			this.root = new NodeAVL<T>(info);
		} else {
			NodeAVL<T> aux = new NodeAVL<T>(info);
			this.root = this.addAVL(aux, this.root);
		}
	}
	
	//N
    private NodeAVL<T> addAVL(NodeAVL<T> rootAux, NodeAVL<T> subTree) { 
        NodeAVL<T> aux = subTree;
        
        if (this.comparator.compare(rootAux.info, subTree.info) < 0) {
        	if (subTree.left == null) {
        		subTree.left = rootAux;
        	} else {
        		subTree.left = this.addAVL(rootAux, subTree.left);
        		if (this.getBalance(subTree.left) - this.getBalance(subTree.right) == 2) {
        			aux = (this.comparator.compare(rootAux.info, subTree.left.info) < 0)?this.rotationLeft(subTree):this.doubleRotationLeft(subTree);
        		} 
        	}
        } else if (this.comparator.compare(rootAux.info, subTree.info) > 0) {
        	if (subTree.right == null) {
        		subTree.right = rootAux;
        	} else {
        		subTree.right =this.addAVL(rootAux, subTree.right);
        		if (this.getBalance(subTree.right) - this.getBalance(subTree.left) == 2) {
        			aux = (this.comparator.compare(rootAux.info, subTree.right.info) > 0)?this.rotationRight(subTree):this.doubleRotationRight(subTree);
        		}
        	}
        } 
        
        if (subTree.left == null && subTree.right != null) {
        	subTree.balance = subTree.right.balance + 1;
        } else if (subTree.right == null && subTree.left != null) {
        	subTree.balance = subTree.left.balance + 1;
        } else {
        	subTree.balance = Math.max(this.getBalance(subTree.left), this.getBalance(subTree.right)) + 1;
        }
        return aux;
    }
    
    public NodeAVL<T> rotationLeft(NodeAVL<T> rootAux) {
    	NodeAVL<T> aux = rootAux.left;
    	rootAux.left = aux.right;
    	aux.right = rootAux;
    	rootAux.setBalance(Math.max(this.getBalance(rootAux.left), this.getBalance(rootAux.right)) + 1);
    	aux.setBalance(Math.max(this.getBalance(aux.left), this.getBalance(aux.right)) + 1);
    	
    	return aux;
    }
    
    public NodeAVL<T> rotationRight(NodeAVL<T> rootAux) {
    	NodeAVL<T> aux = rootAux.right;
    	rootAux.right = aux.left;
    	aux.left = rootAux;
    	rootAux.setBalance(Math.max(this.getBalance(rootAux.left), this.getBalance(rootAux.right)) + 1);
    	aux.setBalance(Math.max(this.getBalance(aux.left), this.getBalance(aux.right)) + 1);
    	
    	return aux;
    }
    
    public NodeAVL<T> doubleRotationLeft(NodeAVL<T> rootAux) {
    	rootAux.left = this.rotationRight(rootAux.left);
    	NodeAVL<T> aux = this.rotationLeft(rootAux);
    	return aux;
    }
    
    public NodeAVL<T> doubleRotationRight(NodeAVL<T> rootAux) {
    	rootAux.right = this.rotationLeft(rootAux.right);
    	NodeAVL<T> aux = this.rotationRight(rootAux);
    	return aux;
    }
	
	public int getBalance(NodeAVL<T> rootAux) {
		return (rootAux == null)?-1:rootAux.balance;
	}
	
    //AVL
	public void remove(T info, NodeAVL<T> rootAux) {
		if (rootAux.info == info) {
			this.simpleList.remove(rootAux.info);
			if (this.searchMinor(info) != null) {
				NodeAVL<T> aux = this.searchMinor(info);
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
	
	public NodeAVL<T> searchMinor(T info) {
		NodeAVL<T> aux = this.search(info, this.root);
		NodeAVL<T> ant = null;
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
	
	public NodeAVL<T> search(T info, NodeAVL<T> rootAux) {
		NodeAVL<T> aux = null;
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
	
	public void inOrder(NodeAVL<T> rootAux) {
		if (rootAux != null) {
			this.inOrder(rootAux.getLeft());
			simpleList.addLast(rootAux.info);
			this.inOrder(rootAux.getRight());
		}
	}
	
	public void preOrder(NodeAVL<T> rootAux) {
		if (rootAux != null) {
			simpleList.addLast(rootAux.info);
			this.preOrder(rootAux.getLeft());
			this.preOrder(rootAux.getRight());
		}
	}
	
	public void postOrder(NodeAVL<T> rootAux) {
		if (rootAux != null) {
			this.postOrder(rootAux.getLeft());
			this.postOrder(rootAux.getRight());
			simpleList.addLast(rootAux.info);
		}
	}
	
	public void levelOrder(NodeAVL<T> rootAux) {		
		
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
	
	private void imprimirEntreConNivel(NodeAVL<T> aux, int nivel){
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
	
	public NodeAVL<T> getRoot() {
		return root;
	}
	
	public MySimpleList<T> getSimpleList() {
		return simpleList;
	}
	
	public void setRoot(NodeAVL<T> root) {
		this.root = root;
	}
}
