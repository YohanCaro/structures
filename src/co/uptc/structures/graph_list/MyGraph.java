package co.uptc.structures.graph_list;

import java.util.Comparator;

import co.uptc.structures.simple_list.Cursor;
import co.uptc.structures.simple_list.MySimpleList;

/**
 * Clase que crea un grafo
   Fecha 17/02/2019
 * @author Yohan Caro 
 * @version 1.1
 *
 * @param <V> Vertices (vertex)
 * @param <E> Aristas (edges)
 */
public class MyGraph<V, E> extends MySimpleList<Vertex<V, E>> {
	
	private Comparator<E> comparatorEdges;
		
	public MyGraph(Comparator<E> comparatorEdges) {
		super();
		this.comparatorEdges = comparatorEdges;
	}
	
	/**
	 * Cuenta la cantidad de elementos de una arista y almacena el 
	 * de mayor cantidad
	 * @return max arista mayor
	 */
	public int getMaxEdges() {
		int max = 0, cont = 0;
		Cursor<Vertex<V, E>> cursor = new Cursor<>(this);
		Cursor<Edge<V, E>> auxEdge = new Cursor<>(cursor.getHead().getInfo().getEdges());
		
		while (!cursor.isOut()) {
			cont = 0;
			while (!auxEdge.isOut()) {
				cont++;
				auxEdge.next();
			}
			if (cont > max) {
				max = cont;
			}
			cursor.next();
		}
		return max;
	}
	
	
	/**
	 * Evalua cuale vertices no tienen aristas
	 * @return list con lo vertices
	 */
	public MySimpleList<V> getWhitOutEdges() {
		MySimpleList<V> list = new MySimpleList<>();
		
		Cursor<Vertex<V, E>> cursor = new Cursor<>(this);
		
		while (!cursor.isOut()) {
			if (cursor.getInfo().getEdges().isEmpty()) {
				list.add(cursor.getInfo().getVertex());
			}
			cursor.next();
		}

		return list;
	}

	/**
	 * Comprueba di el grafoes dirijido
	 * @return true si es dirijido
	 */
	public boolean isDigraph() {
		Cursor<Vertex<V, E>> cursor = new Cursor<>(this);
		Cursor<Edge<V, E>> auxEdge = new Cursor<>(cursor.getHead().getInfo().getEdges());
		
		while (!cursor.isOut()) {
			while (!auxEdge.isOut()) {
				if (auxEdge.getInfo().getType() == Edge.TypeG.ADYACENTE || auxEdge.getInfo().getType() == Edge.TypeG.INCIDENTE) {
					return true;
				}
				auxEdge.next();
			}
			cursor.next();
		}
		
		return false;
	}
	
	/**
	 * Retorna las aristas de menor valor
	 * @return list con aristas
	 */
	public MySimpleList<Edge<V, E>> getMinorEdges() {
		MySimpleList<Edge<V, E>> list = new MySimpleList<>();
		
		Cursor<Vertex<V, E>> cursor = new Cursor<>(this);
		Cursor<Edge<V, E>> auxEdge = new Cursor<>(cursor.getHead().getInfo().getEdges());
		
		Edge<V, E> edgeMinor = auxEdge.getInfo(); //Arista menor
		list.add(edgeMinor);
		auxEdge.next(); //Siguiente
		
		while (!cursor.isOut()) {
			while (!auxEdge.isOut()) {
				if (comparatorEdges.compare(edgeMinor.getLabel(), auxEdge.getInfo().getLabel()) >= 0) { //Si es menor o igual
					if (comparatorEdges.compare(edgeMinor.getLabel(), auxEdge.getInfo().getLabel()) == 0) { //Si es igual, añade normal
						list.add(auxEdge.getInfo());
					} else { //Si es mayor, reinica la lista y añade el nuevo menor
						list = new MySimpleList<>();
						list.add(auxEdge.getInfo());
						edgeMinor = auxEdge.getInfo();
					}
				} 
				auxEdge.next();
			}
			cursor.next();
			if (!cursor.isOut()) {
				auxEdge = new Cursor<>(cursor.getInfo().getEdges());
			}
		}
		return list;
	}
	
	/**
	 * Retorna las aristas de mayor valor
	 * @return list con aristas
	 */
	public MySimpleList<Edge<V, E>> getMajorEdges() {
		MySimpleList<Edge<V, E>> list = new MySimpleList<>();
		
		Cursor<Vertex<V, E>> cursor = new Cursor<>(this);
		Cursor<Edge<V, E>> auxEdge = new Cursor<>(cursor.getInfo().getEdges());
		
		Edge<V, E> edgeMajor = auxEdge.getInfo(); //Arista mayor
		list.add(edgeMajor);
		auxEdge.next(); //Siguiente
		
		while (!cursor.isOut()) {
			while (!auxEdge.isOut()) {
				if (comparatorEdges.compare(edgeMajor.getLabel(), auxEdge.getInfo().getLabel()) <= 0) { //Si es mayor o igual
					if (comparatorEdges.compare(edgeMajor.getLabel(), auxEdge.getInfo().getLabel()) == 0) { //Si es igual, añade normal
						list.add(auxEdge.getInfo());
					} else { //Si es mayor, reinica la lista y añade el nuevo mayor
						list = new MySimpleList<>();
						list.add(auxEdge.getInfo());
						edgeMajor = auxEdge.getInfo();
					}
				} 
				auxEdge.next();
			}
			cursor.next();
			if (!cursor.isOut()) {
				auxEdge = new Cursor<>(cursor.getInfo().getEdges());
			}
		}
		
		return list;
	}

}
