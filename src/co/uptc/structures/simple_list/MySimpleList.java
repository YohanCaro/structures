package co.uptc.structures.simple_list;

import java.lang.reflect.Array;
import java.util.Comparator;

/**
 * Fecha 31/08/2018
 * @author Yohan Caro
 * Clase generica que crea una lista simplemente enlazada!
 * 
 * @param <T> Clase de un elemento u objeto!
 */
public class MySimpleList<T> {
	
    protected Node<T> head;
    private Comparator<T> comparator;

    /**
     * Constructor que inicaliza la cabeza y el comparador de la lista como nulos!
     */
    public MySimpleList() {
        this.head = null;
        this.comparator = null;
    }
    
    /**
     * Constructor que inicaliza la cabeza de la lista como nula e
     * inicializa el comparador por un que le llega de parametro!
     * @param comp comparador de elementos.
     */
    public MySimpleList(Comparator<T> comp) {
        this.comparator = comp;
        this.head = null;
    }
    
    /**
     * Constructor que toma la abeza de una lista que le llega!
     * @param simpleList una lista simple.
     */
    public MySimpleList(MySimpleList<T> simpleList) {
        this.head = simpleList.head;
        this.comparator = null;
    }
    
    /**
     * Metodo que a�ade un elemento a la lista!
     * @param info elemento a a�adr.
     */
    public void addLast(T info) {
        
        if (this.head != null) {
            Node<T> aux = this.head;
            while (aux.next != null) {
                aux = aux.next;
            }
            aux.next = new Node(info);
        } else {
            this.head = new Node(info);
        }
    }
    
    /**
     * Metodo que inserta una cabeza!
     * @param info elemento a insertar!
     */
    private void insert(T info) {
        this.head = new Node(info, this.head);
    }
            
    /**
     * Metodo que a�ade un elemento a la lista!
     * @param info elemento a a�adir.
     */
    public void add(T info) {
        if (comparator == null) {
            this.addLast(info);
        } else {
            this.addSort(info);
        }
    }
    
    /**
     * Metodo que a�ade ordenadamente!
     * @param info elemento a a�adir
     */
    public void addSort(T info) {
        if(this.head == null) {
            this.head = new Node<T>(info);
        } else {
            if (comparator.compare(info, this.head.info) < 0) {
                this.head = new Node(info, this.head);
            } else {
                Node<T> aux = this.head.next;
                Node<T> ant = this.head;
                
                while (aux != null && comparator.compare(info, aux.info) > 0) {
                    ant = aux;
                    aux = aux.next;
                }
                ant.next = new Node(info,aux);
            }
        }
    }
    
    
    /**
     * Give the size of the list
     * @return a integer with the size
     */
    public int length() {
    	if (head != null) {
    		int cont = 0;
    		Node<T> aux = this.head;
    		while (aux != null) {
    			aux = aux.next;
    			cont++;
    		}
    		return cont;
    	} else {
    		return -1;
    	}
    }
    
	/**
	 * Elimina un elemento de la lista!
	 * @param info dato
	 */
	public void remove(T info) {
		if (this.comparator != null) {
			this.removeCompare(info);
		} else {
			this.removeNoCompare(info);
		}
	}
	
	/**
     * Metodo que elimina un objeto de la lista utilizando el comparador!
     * @param info elemento a eliminar.
     */
    private void removeCompare(T info) {
        if (this.head != null) {
            if (comparator.compare(head.info, info) == 0) {
                this.head = this.head.next;
            } else {
                Node<T> aux = this.head.next;
                Node<T> ant = this.head;
                while (aux != null) {
                    if (comparator.compare(aux.info, info) == 0) {
                        ant.next = aux.next;
                    }
                    ant = aux;
                    aux = aux.next;
                }
            }
        }
    }
    
	/**
     * Metodo que elimina un objeto de la lista!
     * @param info elemento a eliminar.
     */
    private void removeNoCompare(T info) {
        if (this.head != null) {
            if (this.head.info.equals(info)) {
                this.head = this.head.next;
            } else {
                Node<T> aux = this.head.next;
                Node<T> ant = this.head;
                while (aux != null) {
                    if (aux.info.equals(info)) {
                        ant.next = aux.next;
                    }
                    ant = aux;
                    aux = aux.next;
                }
            }
        }
    }
    
    /**
     * Metodo que muestra si la lista esta vacia!
     * @return boolean con la informacion (true/false).
     */
    public boolean isEmpty() {
    	return (this.head == null);
    }
    
    /**
     * Setea la informacion
     * @param infoAnt informacion anterior
     * @param infoNew nueva infomacion
     */
    public void set(T infoAnt, T infoNew) {
    	Node<T> aux = this.search(infoAnt);
    	aux.info = infoNew;
    }
    
    /**
     * Busca un elemento en la lista
     * @param info dato a buscar
     * @return el dato buscado o null si no lo encuentra
     */
    public Node<T> search(T info) {
    	return (this.comparator!=null)?this.searchCompare(info):this.searchNoCompare(info);
    }
    
    /**
     * Search a element that is entered as parameter
     * @param info Element to search
     * @return Node of element
     */
    private Node<T> searchCompare(T info) {
       	Node<T> aux = new Node<T>(info);
    	if (head != null) {
    		if (comparator.compare(head.info, info) == 0) { 
                aux.info = info;
            } else {
            	aux = this.head.next;
            	while (aux != null && comparator.compare(aux.info, info) != 0) {
            		aux = aux.next;
            	}
            	if (aux != null) {
            		aux = (comparator.compare(aux.info, info) == 0)? aux:null;
            	}
            }
    	}
    	return aux;
    }

    /**
     * Busca un objeto en la lista sin comparar
     * @param info elemento a buscar
     * @return aux elemento encontrado / o null si no
     */
    private Node<T> searchNoCompare(T info) {
        Node<T> aux = this.head;
        while (aux != null) {
            if (aux.info.equals(info)) {
                return aux;
            }
            aux = aux.next;
        }
        return null;
    }
    
	/**
	 * Invierte los elementso de la lista
	 * @return list lista invertida
	 */
	public MySimpleList<T> invertList() {
		MySimpleList<T> list = new MySimpleList<>();
		Node<T> reverseAux = null;
		while (reverseAux != this.head) {
			Node<T> aux = this.head;
			while (aux.next != reverseAux) {
				aux = aux.next;
			}
			list.add(aux.getInfo());
			reverseAux = aux;
		}
		return list;
	}
	
	/**
	 * A�ade los elementos de otra lista al comienzo 
	 * @param list lista
	 */
	public void insertList(MySimpleList<T> list) {
		if (!list.isEmpty()) {
			Node<T> aux = list.head.next;
			while (aux.next != null) {
                aux = aux.next;
            }
			aux.next = this.head;
			this.head = list.head;
		}
	}
	
	/**
	 * A�ade los elemtos de un array al final de la lista
	 * @param array vector estatico
	 */
	public void addArray(T[] array) {
		for (int i = 0; i < array.length; i++) {
			this.addLast(array[i]);
		}
	}
		
	/**
	 * Pasa los elementos de la lista a un array
	 * @return array con datos
	 */
	@SuppressWarnings("unchecked")
	public T[] toArray(Class<T> classT) {
		Node<T> aux = this.head;
		T[] array = (T[]) Array.newInstance(classT, this.size());
		for (int i = 0; i < this.size(); i++, aux = aux.next) {
			array[i] = aux.info;
		}
		return array;
	}
	
    /**
     * Give the size of the list
     * @return a integer with the size
     */
    public int size() {
    	if (head != null) {
    		int cont = 0;
    		Node<T> aux = this.head;
    		while (aux != null) {
    			aux = aux.next;
    			cont++;
    		}
    		return cont;
    	} else {
    		return -1;
    	}
    }

    /**
     * Metodo que devuelve la cabeza!
     * @return head la cabeza
     */
    public Node<T> getHead() {
        return head;
    }
    
    /**
     * Metodo que setea el comparador
     * @param comparator comapardor
     */
    public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}
    
    public Comparator<T> getComparator() {
		return comparator;
	}
    
    public void setHead(Node<T> head) {
		this.head = head;
	}
    
}
