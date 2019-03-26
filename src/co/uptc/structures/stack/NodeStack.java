package co.uptc.structures.stack;

/**
 * Clase Node - Clase del nodo
 * 
 * @author Yohan Caro
 * Fecha 05/09/2018
 *
 * @param <T> Tipo de Objeto
 */
public class NodeStack<T> {
    protected T info;
    protected NodeStack<T>  next;

    /**
     * Constructor que asigna la información y marca su siguiente nodo!
     * @param info informacion
     * @param next siguiente nodo!
     */
    public NodeStack(T info, NodeStack<T> next) {
        this.info = info;
        this.next = next;
    }

    /**
     * Constructor que solo trae la información
     * @param info información
     */
    public NodeStack(T info) {
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
    public NodeStack<T> getNext() {
        return next;
    }

    /**
     * Cambia la información del nodo siguiente.
     * @param next siguiente nodo;
     */
    public void setNext(NodeStack<T> next) {
        this.next = next;
    }
    
}
