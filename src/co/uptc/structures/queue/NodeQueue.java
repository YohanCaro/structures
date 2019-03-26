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
     * Constructor que asigna la información y marca su siguiente nodo!
     * @param info informacion
     * @param next siguiente nodo!
     */
    public NodeQueue(T info, NodeQueue<T> next) {
        this.info = info;
        this.next = next;
    }
    
    /**
     * Constructor que solo trae la información
     * @param info información
     */
    public NodeQueue(T info) {
        this.info = info;
    }

    /**
     * Devuelve la información.
     * @return info información
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
     * Cambia la información del nodo siguiente.
     * @param next siguiente nodo;
     */
    public void setNext(NodeQueue<T> next) {
        this.next = next;
    }
    
}
