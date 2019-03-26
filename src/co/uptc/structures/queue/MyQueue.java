package co.uptc.structures.queue;

import java.util.Comparator;

/**
 * Clase MyQueue - Una estructura de datos que actua como una cola o fila.
 * 
 * @author Yohan Caro
 * Fecha 10/09/2018
 *
 * @param <T> Clase de los objetos que van a ser añadidos en la cola!
 */
public class MyQueue<T> {
	
	private NodeQueue<T> first;
	private NodeQueue<T> last;
	
	/**
	 * Constructor que inicaliza el primer y el ultimo elemento como nulos.
	 */
	public MyQueue() {
		this.first = null;
		this.last = null;
	}
	
	/**
	 * Analiza si la lista esta vacia
	 * @return truesi esta vacia/ false si no.
	 */
	public boolean isEmpty() {
		return (this.first == null);
	}
	
	/**
	 * Añade un elemnto en la ultima posición de la cola.
	 * @param info dato a añadir en un nuevo nodo.
	 */
	public void put(T info) {
		if (first == null) {
			this.last = this.first = new NodeQueue<T>(info);
		} else {
			this.last.next = new NodeQueue(info);
			this.last = this.last.next;
		}
	}
	
	/**
	 * Devuleve el primer elemento de la cola, sí esxite.
	 * @return aux si existe/ sino null.
	 */
	public T get() {
		if (first != null) {
			NodeQueue<T> aux = this.first;
			this.first = this.first.next;
			return aux.getInfo();
		} 
		return null;
	}
	
	/**
	 * Ordena por particion-fusion (Sort Merge)
	 * Divide una cola en dos diviendo los colocando el numero menor en uno
	 * de estos siempre y cuando cumpla una condición, sino agrega al siguiente
	 * en la otra cola y se ubica en esta.
	 * Despues la une en una sola.
	 * @param compare comparador para saber si es menor, igual o mayor.
	 */
	public void sort(Comparator<T> compare) {
		MyQueue<T> aux = new MyQueue<>();
		MyQueue<T> aux2 = new MyQueue<>();
		
		boolean flag = true;
		
		while (flag) {
			//Particion
			boolean act = true;
			while (!this.isEmpty()) {
				if (act) {
					if (this.first.next == null) {
						aux.put(this.get());
					} else {
						if (!(compare.compare(this.first.info, this.first.next.info) <= 0)) {
							act = false;
						} 
						aux.put(this.get());
					}	
				} else {
					if (this.first.next == null) {
						aux2.put(this.get());
					} else {
						if (!(compare.compare(this.first.info, this.first.next.info) <= 0)) {
							act = true;
						} 
						aux2.put(this.get());
					}
				}
			}
			
			if (aux2.isEmpty()) {
				flag = false;
				while (!aux.isEmpty()) {
					this.put(aux.get());
				}
			}
			
			if (flag) {
				this.linkQueue(aux, aux2, compare);
			}
		}
	}
	
	/**
	 * Une dos colas en una una sola siempre y cuando se necesite!
	 * Si una de las colas esta vacia, termina de llenar los datos que faltan
	 * de la otra cola en la cola original.
	 * @param aux cola 1
	 * @param aux2 cola 2
	 * @param compare comarador para saber si el objeto es mayor o menor
	 */
	public void linkQueue(MyQueue<T> aux, MyQueue<T> aux2, Comparator<T> compare) {
		//Fusion
		while (!aux.isEmpty() && !aux2.isEmpty()) {
			if (compare.compare(aux.first.info, aux2.first.info) <= 0) {
				this.put(aux.get());
			} else {
				this.put(aux2.get());
			}
		}
		//Uno vacio
		if (aux.isEmpty()) {
			while (!aux2.isEmpty()) {
				this.put(aux2.get());
			}
		} else {
			while (!aux.isEmpty()) {
				this.put(aux.get());
			}
		}
	}
		
}
