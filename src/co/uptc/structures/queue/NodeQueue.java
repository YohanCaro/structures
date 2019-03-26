package co.uptc.structures.queue;

/**
 * Clase Node - Clase del nodo
 * 
 * @author Yohan Caro
 * Fecha 10/09/2018
 *
 * @param <T> Tipo de Objeto
 */
public class NodeQueue<T> {
    protected T info;
    protected NodeQueue<T>  next;

    /**
     * Constructor que asigna la informaci�n y marca su siguiente nodo!
     * @param info informacion
     * @param next siguiente nodo!
     */
    public NodeQueue(T info, NodeQueue<T> next) {
        this.info = info;
        this.next = next;
    }
    
    /**
     * Constructor que solo trae la informaci�n
     * @param info informaci�n
     */
    public NodeQueue(T info) {
        this.info = info;
    }

    /**
     * Devuelve la informaci�n.
     * @return info informaci�n
     */
    public T getInfo() {
        return info;
    }

    /**
     * Devuelve el siguiente nodo.
     * @return next siguiente nodo.
     */
    public NodeQueue<T> getNext() {
        return next;
    }

    /**
     * Cambia la informaci�n del nodo siguiente.
     * @param next siguiente nodo;
     */
    public void setNext(NodeQueue<T> next) {
        this.next = next;
    }
    
}
