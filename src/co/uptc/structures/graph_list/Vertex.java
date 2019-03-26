package co.uptc.structures.graph_list;

import co.uptc.structures.simple_list.MySimpleList;

/**
 * Clase que crea los vertices del grafo
 * Fecha 17/02/2019
 * @author Yohan Caro
 * @version 1.0
 * 
 * @param <V> Vertice
 * @param <E> Aristas
 */
public class Vertex<V, E> {
	
	private V vertex;
	private MySimpleList<Edge<V, E>> edges;
	
	/**
	 * Constructor con un solo vertice
	 * @param vertex
	 */
	public Vertex(V vertex) {
		this.vertex = vertex;
	}
	
	/**
	 * Constructor con el vertce y la lista de aristas
	 */
	public Vertex(V vertex, MySimpleList<Edge<V, E>> edges) {
		this.vertex = vertex;
		this.edges = edges;
	}

	/**
	 * Devuelve el valor del vertice
	 * @return vertex vertice
	 */
	public V getVertex() {
		return vertex;
	}
	
	/**
	 * Devuelve la lista de aristas
	 * @return edges aristas
	 */
	public MySimpleList<Edge<V, E>> getEdges() {
		return edges;
	}

}
