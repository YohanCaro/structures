package co.uptc.structures.simple_list;

/**
 * Clase generadora de los nodos
 * Fecha 31/08/2018
 * @author Yohan Caro
 */
public class Node<T> {
    protected T info;
    public Node<T>  next;

    /**
     * Constructor que añade una info nueva y un elemento siguiente!
     * @param info información a agregar
     * @param next siguiente elemento a agregar
     */
    public Node(T info, Node<T> next) {
        this.info = info;
        this.next = next;
    }

    /**
     * Constructor que solo crear la info
     * @param info a settear
     */
    public Node(T info) {
        this.info = info;
    }

    /**
     * Devuelve la información
     * @return info
     */
    public T getInfo() {
        return info;
    }

    /**
     * Devuelve el siguiente elemento
     * @return next
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Cambia el siguiente elemento
     * @param next sigueinte dato
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }
    
}
