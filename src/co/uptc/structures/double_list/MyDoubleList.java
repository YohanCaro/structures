package co.uptc.structures.double_list;

import java.util.Comparator;

/**
 * Class DoubleList, clase que crea una lista doblemente enlazada
 * @author Yohan Caro
 * 
 * Fecha 5/09/2018 
 * @param <T> Clase de la que seran guardados los objetos de la lista!
 */
public class MyDoubleList<T> {
	
	public NodeDouble<T> first;
	public NodeDouble<T> last;
	private Comparator<T> compare;
	
	/**
	 * Contructor que inicializa los atributos de la clase como nulos!
	 */
	public MyDoubleList() {
		first = null;
		last = null;
		compare = null;
	}
	
	/**
	 * Contructor que inicializa los atributos de la clase como nulos, menos el 
	 * comparador!
	 */
	public MyDoubleList(Comparator<T> compare) {
		this.first = null;
		this.last = null;
		this.compare = compare;
	}
	
	public MyDoubleList(MyDoubleList<T> doubleList) {
		this.first = doubleList.first;
	}

	/**
	 * Añade una información a la lista de primeras!
	 * @param info información a añadir
	 */
	public void addHead(T info) {
		if (first == null) {
			first = new NodeDouble<T>(info);
			last = first;
		} else {
			NodeDouble<T> aux = new NodeDouble<T>(info, null, first);
			first.ant = aux;
			first = aux;
		}
	}
	
	/**
	 * Añade una información al final de la lista!
	 * @param info información a añadir.
	 */
	public void addLast(T info) {
		if (last == null) {
			last = new NodeDouble<T>(info);
			first = last;		
		} else {
			NodeDouble<T> aux = new NodeDouble<T>(info, last, null);
			last.next = aux;
			last = aux;
		}
	}
	
	/**
	 * Añade una infomacion a la lista de forma ordenada!
	 * Si no hay elementos añade normal!
	 * Si hay, busca un elemento mayor al que va añadir,
	 * luego añade atras de ese elemento (si lo encuentra)!
	 * @param info informacion a añadir!
	 */
	public void addSort(T info) {
		if (first == null) { 
			first = new NodeDouble<T>(info);
			last = first;
		} else {			
			NodeDouble<T> aux = this.first; 
			NodeDouble<T> ant = null;		
			
			while (aux != null && compare.compare(info, aux.getInfo()) > 0) { 
				ant = aux;
				aux = aux.next;
			}
			
			if (aux == null) {
				this.addLast(info);
			} else if (ant == null) {
				this.addHead(info);
			} else {
				NodeDouble<T> nuevo = new NodeDouble<T>(info, ant, aux);
				aux.ant = nuevo;
				ant.next = nuevo;
			}
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
	public NodeDouble<T> getFirst() {
		return first;
	}

	/**
	 * Obtiene el ultimo elemento de la lista!
	 * @return last el ultimo elemento de la lista.
	 */
	public NodeDouble<T> getLast() {
		return last;
	}
	
}
