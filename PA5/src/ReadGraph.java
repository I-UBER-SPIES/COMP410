
import java.util.Arrays;

import java.util.Scanner;

public class ReadGraph {
	private static String[] vertices;
	public static String[] readVertices(Scanner fileIn) {
		int numVert = fileIn.nextInt();
		Main.vertices = new String[numVert];
		for (int i = 0; i < numVert; i++) {
			Main.vertices[i] = fileIn.next();
		}
		Arrays.sort(Main.vertices); // amarillo, austin, dallas, houston, lubbock
		vertices = Main.vertices;
		return Main.vertices;
	}

	public static AdjListNode[] readEdgesAdjList(Scanner fileIn) {
		Main.adjList = new AdjListNode[Main.vertices.length];
		String sourceVertex;
		String destVertex;
		int weight = 0;
		
		while(fileIn.hasNext()){
			sourceVertex = fileIn.next();
			destVertex = fileIn.next();
			weight = fileIn.nextInt();
			int indexSrc = Arrays.binarySearch(Main.vertices, sourceVertex);
			int indexDest = Arrays.binarySearch(Main.vertices, destVertex);
			
			if(indexSrc < 0 || indexDest < 0){
				throw new RuntimeException("Vertex not in vertex list");
			}
			if(Main.adjList[indexSrc] != null){
				AdjListNode newNode = Main.adjList[indexSrc];
				Main.adjList[indexSrc] = new AdjListNode(indexDest, weight, newNode);
			}else{
				Main.adjList[indexSrc] = new AdjListNode(indexDest, weight, null);
			}
		}
		
		return Main.adjList;
	}

}
