package co.uptc.structures.circular_list;

/**
 * Clase CircularList
 * 
 * @version 1.1 25/03/2019
 * @author Yohan Caro
 *
 * @param <T> Tipo de objeto a enlistar
 */
public class CircularList<T> {
	
	public NodeCircularList<T> nodeAccess;
	
	/**
	 * Constructor de lista vacia
	 */
	public CircularList() {
		this.nodeAccess = null;
	}
	
	/**
	 * Constructor que crea una lista apartir de un nodo
	 * @param head nodo
	 */
	public CircularList(NodeCircularList<T> head) {
		this.nodeAccess = head;
	}
	
	/**
	 * Constructor que toma el nodo de acceso de otra lista
	 * @param circularList lista circular
	 */
	public CircularList(CircularList<T> circularList) {
		this.nodeAccess = circularList.nodeAccess;
	}

	/**
	 * Añade un nodo a la lista!
	 * @param info dato
	 */
	public void add(T info) {
		if (nodeAccess == null) {
			nodeAccess = new NodeCircularList<T>(info);
			nodeAccess.next = nodeAccess;
		} else {
			NodeCircularList<T> ult = nodeAccess;
			NodeCircularList<T> aux = new NodeCircularList<T>(info, nodeAccess);
			while (nodeAccess.next != ult) {
				nodeAccess = nodeAccess.next;
			}
			nodeAccess.next = aux;
			nodeAccess = ult;
		}
	}
	
	/**
	 * Elimina un elemento de la lista
	 * @param info dato a eliminar
	 */
	public void delete(T info) {
		if (nodeAccess != null) {
			if (nodeAccess.info == info) {
				if (nodeAccess.next == nodeAccess) {
					nodeAccess = null;
				} else {
					nodeAccess = nodeAccess.next;
				}
			} else {
				NodeCircularList<T> aux = this.nodeAccess.next;
                NodeCircularList<T> ant = this.nodeAccess;
                
                while (aux != null) {
                    if (aux.info == info) {
                    	ant.next = aux.next;
                    }
                    ant = aux;
                    aux = aux.next;
                }
			}
		}
		
	}

	/**
	 * Obtiene el nodo de acceso 
	 * @return nodeAccess nodo
	 */
	public NodeCircularList<T> getNodeAccess() {
		return nodeAccess;
	}
	
}
