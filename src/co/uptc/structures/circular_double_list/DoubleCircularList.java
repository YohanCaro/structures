package co.uptc.structures.circular_double_list;

/**
 * Class CircularList, clase que crea una lista circular doblemente 
 * enlazada
 * @author Yohan Caro
 * 
 * Fecha 5/09/2018 
 * @param <T> Clase de la que seran guardados los objetos de la lista!
 */
public class DoubleCircularList<T> {
	
	public NodeDoubleCircular<T> first;
	public NodeDoubleCircular<T> last;
	
	/**
	 * Contructor que inicializa los atributos de la clase como nulos!
	 */
	public DoubleCircularList() {
		first = null;
		last = null;
	}

	/**
	 * Añade una información a la lista de primeras!
	 * @param info información a añadir
	 */
	public void addHead(T info) {
		if (first == null) {
			first = new NodeDoubleCircular<T>(info);
			first.ant = first;
			first.next = first;
			last = first;
			last.next = first;
		} else {
			NodeDoubleCircular<T> aux = new NodeDoubleCircular<T>(info, first.ant, first);
			first.ant = aux;
			aux.ant.next = aux;
			first = aux;
			last.next = first;
		}
	}
	
	/**
	 * Añade una información al final de la lista!
	 * @param info información a añadir.
	 */
	public void addLast(T info) {
		if (last == null) {
			last = new NodeDoubleCircular<T>(info);
			last.next = last;
			last.ant = last;
			first = last;			
		} else {
			NodeDoubleCircular<T> aux = new NodeDoubleCircular<T>(info, last, last.next);
			last.next = aux;
			aux.next.ant = aux;
			last = aux;
		}
	}
	
	/**
	 * Elimina un nodo de la lista
	 */
	public void delete(T info) {
		
	}

	/**
	 * Obtiene el primer elemento de la lista!
	 * @return first el primer elemento de la lista.
	 */
	public NodeDoubleCircular<T> getFirst() {
		return first;
	}

	/**
	 * Obtiene el ultimo elemento de la lista!
	 * @return last el ultimo elemento de la lista.
	 */
	public NodeDoubleCircular<T> getLast() {
		return last;
	}
	
}
