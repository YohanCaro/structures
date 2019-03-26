package co.uptc.structures.graph_matrix;

import java.util.Comparator;

import co.uptc.structures.simple_list.MySimpleList;

/**
 * Clase que crea una matriz adyacente
   Fecha 12/02/2019
 * @author Yohan Caro 
 * @version 2.0
 *
 * @param <V> Vertices (vertex)
 * @param <E> Aristas (edges)
 */
public class MatrixAdyacencia<V,E> {
	
	private V[] vertex;
	private E[][] edges;
	private E nan;
	private Comparator<E> comparator;
	
	/**
	 * Constructor que añade los datos
	 * @param vertex vector de vertices
	 * @param edges matriz de aristas
	 * @param nan valor NAN
	 */
	public MatrixAdyacencia(V[] vertex, E[][] edges, E nan, Comparator<E> comp) {
		this.vertex = vertex;
		this.edges = edges;
		this.nan = nan;
		this.comparator = comp;
	}	
	
	/**
	 * Cuenta la cantidad de elementos de una arista y almacena el 
	 * de mayor cantidad(Grafos no dirigidos)
	 * @return max arista mayor
	 */
	public int getMaxEdges() {
		int max = 0, cont = 0;
		for (int i = 0; i < vertex.length; i++) {
			cont = 0;
			for (int j = 0; j < vertex.length; j++) {
//				System.out.println(nan + ":" + edges[i][j] + " Son iguales? "+ ((nan == edges[i][j])?"SI":"No") + " .-.");
//				cont += (edges[i][j] != nan)?1:0;
				cont += (comparator.compare(edges[i][j], nan) != 0)?1:0;
			}
			max = (cont > max)?cont:max;
		}
		
		return max;
	}
	
	/**
	 * Cuenta la cantidad de elementos de una arista y almacena el 
	 * de menor cantidad(Grafos no dirigidos)
	 * @return min arista de menor valor
	 */
	public int getMinEdgesOfVertex(int i) {
		int cont = 0;
		for (int j = 0; j < vertex.length; j++) {
			if (comparator.compare(edges[i][j], nan) != 0) {
				cont++;
			}
		}
		return cont;
	}
	
	/**
	 * Evalua si un vertice no tiene aristas
	 * @return true/false
	 */
	public MySimpleList<V> getWhitOutEdges() {
		MySimpleList<V> list = new MySimpleList<>();
		
		for (int i = 0; i < edges.length; i++) {
			if (this.getMinEdgesOfVertex(i) == 0) {
				list.add(vertex[i]);
			}
		}
		return list;
	}
	
	/**
	 * Evaluacia si el grafo es dirigido
	 * @return true si es digrafo
	 */
	public boolean isDigraph() {		
		return !this.isPerfectMatrix();
	}
	
	/**
	 * Evalua si hay camino entre dos vertices
	 * @param v1 vertice uno
	 * @param v2 vertice dos
	 * @return true/false
	 */
	public boolean isPath(V v1, V v2) {
		int posV1 = this.getPos(v1);
		int posV2 = this.getPos(v2);
		
		if (posV1 != -1 || posV2 != -1) {
			return (comparator.compare(edges[posV1][posV2], nan) != 0)?true:false;
		}
		
		return false;
	}
	
	/**
	 * Obtiene la posición de un vertice en el vector
	 * @param v vertice a hallar su posición
	 * @return i la posicion del vector
	 */
	public int getPos(V v) {
		for (int i = 0; i < vertex.length; i++) {
			if (v == vertex[i]) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Evalua si la matriz es perfecta (Simetrica)
	 * @param matrix matriz a evaluar
	 * @return true / false
	 */
	public boolean isPerfectMatrix() {	
								
		for (int i = 0; i < edges.length; i++) {
			for (int j = i; j < edges[0].length; j++) {
				if(comparator.compare(edges[j][i], edges[i][j]) != 0) {
					return false;
				}
			}
		}
				
		return true;
	}	

}
