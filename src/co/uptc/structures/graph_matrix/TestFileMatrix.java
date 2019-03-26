package co.uptc.structures.graph_matrix;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;

import co.uptc.structures.simple_list.Cursor;

/**
 * Clase que prueba la matriz de adyacencia
 * Cargar, muestra y evalua la matriz
 * Fecha 12/02/2019
 * @author Yohan Caro 
 * @version 2.2
 */
public class TestFileMatrix {
	
	private static Character[] vertex;
	private static Integer[][] edges;
	private static Integer nan;
	
	public static void main(String[] args) {
		load();
		show();
		query();
	}
	
	/**
	 * Muestra la matriz adyacente
	 */
	public static void show() {
		
		System.out.println("");
		System.out.println("Show \n");
		
		for (int i = 0; i < vertex.length; i++) {
			System.out.print(vertex[i] + "	");
		}
		System.out.println("");
		
		for (int i = 0; i < edges.length; i++) {
			for (int j = 0; j < edges.length; j++) {
				System.out.print(edges[i][j] + "	");
			}
			System.out.println(" ");
		}
	}
	
	/**
	 * Muestra los resultados de los metodos de la matriz adyacente
	 */
	public static void query() {
		MatrixAdyacencia<Character, Integer> matrix = new MatrixAdyacencia<Character, Integer>(vertex, edges, nan,
				new Comparator<Integer>() {

					@Override
					public int compare(Integer a, Integer b) {
						return a-b;
					}
				});
		
		System.out.println("\n Métodos \n");
		
		System.out.println("Cantidad de de aristas del vertice con mayor cantidad? (Vertices adyacentes) es: " + matrix.getMaxEdges());
		System.out.print("Verices sin aristas?  son: ");
		Cursor<Character> c = new Cursor<Character>(matrix.getWhitOutEdges());
		
		while (!c.isOut()) {
			System.out.print(c.nextAndGetInfo());
		}
		System.out.println();
		System.out.println("Grafo es dirigido?  es: " + matrix.isDigraph());
//		System.out.println("La arista de menor valor son: " + matrix.getMinEdges()); //Nace el vertice E - A = 2
//		System.out.println("Aristas sin camino?  es: " + matrix.getMaxVertex());
		char a = 'A';
		char b = 'D';
		System.out.println("Hay camino de: " + a + " a " + b + "? " + matrix.isPath(a, b)); //Hasta aquí
	}

	/**
	 * Carga la matriz adyacente de un archivo de texto plano (txt)
	 */
	public static void load() {
		Scanner sc = new Scanner(System.in);
		try {
			sc = new Scanner(new File("src/grafo_basico.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String desciption = sc.nextLine();
		System.out.println("Aqui dice algo: " + desciption);
		
		String line = sc.nextLine();
		
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
		
		nan = Integer.parseInt(sc.nextLine());
		System.out.println("El valor del nan es: " + nan);
		
		String[] strings = sc.nextLine().split(",");
		vertex = new Character[strings.length];
		for (int i = 0; i < vertex.length; i++) {
			vertex[i] = strings[i].charAt(0);
		}
		
		edges = new Integer[vertex.length][vertex.length];
		for (int i = 0; i < vertex.length; i++) {
			strings = sc.nextLine().split(",");
			for (int j = 0; j < edges.length; j++) {
				edges[i][j] = (strings[j].replace(" ","").compareTo("nan") == 0)?nan:Integer.parseInt(strings[j].replace(" ",""));
			}
		}
			
	}
	
	/*
	 * Crear el main 
	 * Metodo llamdo load()
	 * 
	 * Poner en el main
	 *  load()
	 *  adje.show() //Mostrar la matriz 
	 *  adje.query()
	 *  
	 *  Tester = new tester
	 *  load()
	 *  show()
	 *  query() //Listado de respuestas
	 *  
	 *  Tarea
	 *  - Crear en un archivo una serie de grafos de diferentes tipo matriz de advertencia (Repositorio para crear diferentes tipos de grafos)
	 *  Plantear grafos de tipo denso
	 *  - Mejorar la lectura de datos
	 */

}
