package co.uptc.structures.stack;

/**
 * Clase MyStack - Clase creadora de la pila
 * 
 * @author Yohan Caro
 * Fecha 05/09/2018
 *
 * @param <T> Clase de los objetos de la pila
 */
public class MyStack<T> {

	private NodeStack<T> top;
	
	/**
	 * Constructor que inicializa el tope como nulo!
	 */
	public MyStack() {
		this.top = null;
	}
	
	/**
	 * Analiza si la pila esta vacia
	 * @return true or false
	 */
	public boolean isEmpty() {
		return this.top == null;
	}
	
	/**
	 * Añade nodos a la lista (empuja)
	 * @param info información del nuevo nodo
	 */
	public void push(T info) {
		this.top = new NodeStack<T>(info, this.top);
	}
	
	/**
	 * Suelta la informacion del tope y se pasa al siguiente! (salta al siguiente)
	 * @return aux (si hay infomacion) sino null.
	 */
	public T pop() {
		if (top != null) {
			T aux = this.top.info;
			this.top = this.top.next;
			return aux;
		}
		return null;
	}
}
