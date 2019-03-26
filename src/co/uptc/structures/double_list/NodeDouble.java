package co.uptc.structures.double_list;

/**
 * Class Node, clase que crea los nodos que se utilizaran en la lista
 * enlazada
 * @author Yohan Caro
 * 
 * Fecha 5/09/2018 
 * @param <T> Clase de la que seran guardados los objetos de la lista!
 */
public class NodeDouble<T> {
    protected T info;
    public NodeDouble<T>  next;
    public NodeDouble<T> ant;

    /**
     * Constructor que a�ade elemento a un nodo como:
     * @param info la informaci�n del nodo
     * @param ant el anterior nodo
     * @param next el siguiente nodo
     */
    public NodeDouble(T info, NodeDouble<T> ant, NodeDouble<T> next) {
        this.info = info;
        this.ant = ant;
        this.next = next;
    }

    /**
     * Constructor que crea un nodo solo con la infomaci�n!
     * @param info informaci�n que va a tener el nodo!
     */
    public NodeDouble(T info) {
        this.info = info;
//        this.ant = new Node<T>(info);
    }

    /**
     * Obtiene la informaci�n!
     * @return
     */
    public T getInfo() {
        return info;
    }

    /**
     * Obtiene el siguiente nodo!
     * @return next siguinte.
     */
    public NodeDouble<T> getNext() {
        return next;
    }
    
    /**
     * Obtiene el anterior nodo!
     * @return ant anterior.
     */
    public NodeDouble<T> getAnt() {
		return ant;
	}

    /**
     * Cambia la informaci�n del siguiente nodo!
     * @param next sig
     */
    public void setNext(NodeDouble<T> next) {
        this.next = next;
    }
    
    
    /**
     * Cambia la informaci�n del nodo!
     * @param info informacion
     */public void setInfo(T info) {
		this.info = info;
	}
     
     /**
      * Cambia la informacion del anterior nodo!
      * @param ant anteriror
      */
     public void setAnt(NodeDouble<T> ant) {
		this.ant = ant;
	}
}
