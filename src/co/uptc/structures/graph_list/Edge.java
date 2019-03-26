package co.uptc.structures.graph_list;

/**
 * Clase que crea las aristas del grafo
 * Fecha 17/02/2019
 * @author Yohan Caro
 * @version 1.0
 *
 * @param <V> Vertices
 * @param <E> Aristas
 */
public class Edge<V, E> {

	private E label;
	private TypeG type;
	private Vertex<V, E> target;
	
	/**
	 * Constructor que inicializa
	 * @param target destino
	 * @param label valor
	 * @param type  tipo
	 */
	public Edge(Vertex<V, E> target, E label, char type) {
		this.label = label;
		this.target = target;
		
		if (type == 'A') {
			this.type = TypeG.ADYACENTE;
		} else if (type == 'I') {
			this.type = TypeG.INCIDENTE;
		} else {
			this.type = TypeG.NODIRIGIDO;
		}
	}

	/**
	 * Devuleve el label
	 * @return label valor
	 */
	public E getLabel() {
		return label;
	}

	/**
	 * Devuelve el tipo
	 * @return type tipo
	 */
	public TypeG getType() {
		return type;
	}

	/**
	 * Devuelve el target
	 * @return target destino
	 */
	public Vertex<V, E> getTarget() {
		return target;
	}
	
	public String printEdge() {
		return target.getVertex() + ", " + label + ", " + type;
	}

	/**
	 * Enum con los valores de los tipos de grafos
	 * @author Yohan Caro
	 * 
	 */
	enum TypeG {
		ADYACENTE, INCIDENTE, NODIRIGIDO;
		
	}
}
