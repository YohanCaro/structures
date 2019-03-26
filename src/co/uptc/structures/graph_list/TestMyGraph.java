package co.uptc.structures.graph_list;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;

import co.uptc.structures.simple_list.Cursor;
import co.uptc.structures.simple_list.MySimpleList;

/**
 * Clase que testea el grafo
 * Muestra, carga y evalua el grafo
 * Fecha 17/02/2019
 * @author Yohan Caro
 * @version 1.0
 *
 */
public class TestMyGraph {
	
	private static MyGraph<Character, Integer> myGraph;
	
//	public TestMyGraph() {
//		this.myGraph = new MyGraph<Character, Integer>(new Comparator<Edge<Character, Integer>>() {
//
//			@Override
//			public int compare(Edge<Character, Integer> a, Edge<Character, Integer> b) {
//				return a.getLabel() - b.getLabel();
//			}
//			
//		});
//	}
	
	/**
	 * Carga el caso de prueba y lo asigna a la lista
	 */
	public static void load() {
		Scanner sc = new Scanner(System.in);
		try {
			sc = new Scanner(new File("D:\\docs_graphs\\graphs_snd.txt"));
		} catch (FileNotFoundException e) {
			System.err.println("Archivo no fue encontrado!");
		}
		
		String line = sc.nextLine();
		
		System.out.println(line);
		
		line = sc.nextLine();
		
		switch (line) {
		case "Character":
			System.out.println("El tipo de dato del vertice es: " + "Character");
			
			break;
		}
		
		line = sc.nextLine();
		switch (line) {
		case "Integer":
			System.out.println("El tipo de dato de las aristas es: " + "Integer");
			break;
		}
		
		line = sc.nextLine();
		
		Vertex<Character, Integer> vertex = null;
		Edge<Character, Integer> edge = null;
		
		String[] array = null;
		
		while (sc.hasNext()) {
			Character v = line.charAt(0);
			line = sc.nextLine();
			MySimpleList<Edge<Character, Integer>> edges = new MySimpleList<>();
			while (line.length() > 4) {
				array = line.split(",");
				edge = new Edge<Character, Integer>(new Vertex<Character, Integer>(array[0].replace(" ", "").charAt(0)),
							Integer.parseInt(array[1].replace(" ", "")),
							array[2].replace(" ", "").charAt(0));
				
				edges.add(edge);
				if (sc.hasNext()) {
					line = sc.nextLine();
				} 
			}
			vertex = new Vertex<Character, Integer>(v, edges);
			myGraph.add(vertex);
		}
	}
	
	/**
	 * Muesytra el grafo
	 */
	public static void show() {
		System.out.println("Show");
		Cursor<Vertex<Character, Integer>> cursor = new Cursor<>(myGraph);
		
		
		while (!cursor.isOut()) {
			Cursor<Edge<Character, Integer>> auxEdge = new Cursor<>(cursor.getInfo().getEdges());
			System.out.println(cursor.nextAndGetInfo().getVertex());
			while (!auxEdge.isOut()) {
				System.out.print(auxEdge.getInfo().getTarget().getVertex() + "," +
						auxEdge.getInfo().getLabel() + "," + auxEdge.getInfo().getType());
				System.out.println("");
				auxEdge.next();
			}
		}
	}
	
	/**
	 * Prueba de los metodos de MyGraph
	 */
	public static void query() {
		System.out.println("Query");
		System.out.println("El numero de vertices mayor es: " + myGraph.getMaxEdges());
		
		System.out.print("Verices sin aristas?  son: ");
		if (myGraph.getWhitOutEdges().isEmpty()) {
			System.out.println("No hay vertices vacios");
		} else {
			Cursor<Character> c = new Cursor<Character>(myGraph.getWhitOutEdges());
			while (!c.isOut()) {
				System.out.print(c.nextAndGetInfo());
			}
			System.out.println();
		}
		
		System.out.println("El Grafo  es: " + (myGraph.isDigraph()?"Dirigido":"No dirigido"));
		
		System.out.println("Aristas con menor valor son/es: " );
		Cursor<Edge<Character, Integer>> c = new Cursor<Edge<Character, Integer>>(myGraph.getMinorEdges());
		while (!c.isOut()) {
			System.out.println(c.nextAndGetInfo().printEdge());
		}
		System.out.println();
		
		System.out.println("Aristas con mayor valor son/es ");
		c = new Cursor<Edge<Character, Integer>>(myGraph.getMajorEdges());
		while (!c.isOut()) {
			System.out.println(c.nextAndGetInfo().printEdge());
		}
		
	}	

	public static void main(String[] args) {
		myGraph = new MyGraph<Character, Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer a, Integer b) {
				return a - b;
			}
			
		});

		load();
		show();
		query();
		
	}

}
