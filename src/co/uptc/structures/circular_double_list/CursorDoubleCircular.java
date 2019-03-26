package co.uptc.structures.circular_double_list;

/**
 * Class Cursor, clase que se encarga de recorrer una lista doblemente
 * enlaza tanto hacia adelante como hacia atrás y modifica los elemetos 
 * de la lista dependiendo donde se encuentre.
 * @author Yohan Caro
 * 
 * Fecha 5/09/2018 
 * @param <T> Clase a la que le perteneceran los objetos de la lista.
 */
public class CursorDoubleCircular<T> extends DoubleCircularList<T> {
    
    private NodeDoubleCircular<T> cursor;

    /**
     * Constructor que inicilaiza al cursor con el primer elemento
     * de la lista.
     * @param circularList
     */
    public CursorDoubleCircular(DoubleCircularList<T> circularList) {
        this.cursor = circularList.first;
    }
    
    /**
     * Define si el cursor esta fuera de la lista!
     * En este caso si llega a estar por fuera de la lista, es porque la
     * lista esta vacia!
     * @return true or false
     */
    public boolean isLast() { 
        return this.cursor == null;
    }
    
    /**
     * Devuelve la infomación del cursor!
     * @return info del cursor.
     */
    public T getInfo() {
        return this.cursor.info;
    }
    
    /**
     * Ubica al cursor en el primer elemento!
     */
    public void restart() {
    	this.cursor = this.first;
    }
    
    /**
     * Mueve al cursor a la siguiente posición de la lista!
     */
    public void next() {
        this.cursor = cursor.next;
    }
    
    /**
     * Devuleve al cursor al anterior elemento de la lista!
     */
    public void back() {
    	this.cursor = cursor.ant;
    }
    
    /**
     * Devuelve la infoamcion de cursor y lo avanza!
     * @return la información del cursor antes de avanzar!
     */
    public T nextAndGetInfo() {
        T aux = cursor.info;
        this.cursor = cursor.next;
        return aux;
    }
    
    /**
     * Devuelve la infoamcion de cursor y lo retrocede!
     * @return la información del cursor antes de retroceder!
     */
    public T backAndGetInfo() {
    	T aux = cursor.info;
    	this.cursor = cursor.ant;
    	return aux;
    }
    
    /**
     * Añade un objeto atras del cursor!
     * @param info del nodo a añadir!
     */
    public void addBack(T info) {
    	if (this.cursor != null) {
    		NodeDoubleCircular<T> aux = new NodeDoubleCircular<T>(info, this.cursor.ant, this.cursor);
    		this.cursor.ant.next = aux;
    		this.cursor.ant = aux;
    	} else {
    		this.addHead(info);
    	}
    }
    
    /**
     * Añade un objeto a delante del cursor!
     * @param info del nodo a añadir!
     */
    public void addNext(T info) {
    	if (this.cursor != null) {
    		NodeDoubleCircular<T> aux = new NodeDoubleCircular<T>(info, this.cursor, this.cursor.next);
        	this.cursor.next.ant = aux;
        	this.cursor.next = aux;  
    	} else {
    		this.addLast(info);
    	}
    	
    }
    
    /**
     * Borra el nodo en donde se encuantra ubicado el cursor!
     */
    public void delete() {
    	NodeDoubleCircular<T> aux = cursor.ant;
    	cursor.ant.next = cursor.next;
    	cursor.next.ant = aux;
    	cursor = cursor.next;
    }
    
    /**
     * Selecciona la posición del nodo en la que se encuentra la infomación.
     * Si no encuentra nada el cursor se ubica en la posición en la que se 
     * encontraba anteriormente!
     * @param info informacion buscada! 
     * @return si encontro o no encontro el elemento
     */
    public boolean selectNode(T info) {
    	NodeDoubleCircular<T> aux = this.cursor.ant;
    	while (info != this.cursor.info && aux != this.cursor) {
    		this.next();
    	}
    	
    	if (aux != this.cursor) {
    		return false;
    	}
    	return true;
    }
    
    public void changeInfo(T info) {
    	this.cursor.info = info;
    }
    
}
