import java.util.Scanner;
import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class Main {
	static String[] vertices; // The sorted list of vertex names
	static AdjListNode[] adjList; // The adjacency list
	/*
	 * You are to write the following method. You will need to use a stack or
	 * queue of integers here (you may use java.util.{Stack,Queue}
	 */

	public static String[] topSort() {
		int[] indegree = new int[vertices.length];
		for (int i = 0; i < indegree.length; i++) {
			AdjListNode adjNode = adjList[i];
			while (adjNode != null) {
				int vertex = adjNode.v;
				++indegree[vertex];
				adjNode = adjNode.next;
			}
		}

		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0)
				stack.push(vertices[i]);
		}

		if (stack.isEmpty()) {
			return new String[vertices.length];
		}

		String[] sorted = new String[vertices.length];

		int counter = 0;
		while (!stack.isEmpty()) {
			String v = stack.pop();
			sorted[counter] = v;
			int index = Arrays.binarySearch(vertices, v);
			AdjListNode adjNode = adjList[index];
			while (adjNode != null) {
				if (--indegree[adjNode.v] == 0)
					stack.push(vertices[adjNode.v]);
				adjNode = adjNode.next;
			}
			counter++;
		}

		if (counter != vertices.length) {
			return new String[vertices.length];
		}

		return sorted;
	}

	public static void main(String[] args) throws FileNotFoundException {
		if (args.length != 1) {
			System.err.println("Incorrect number of args passed");
			System.exit(-1);
		}
		Scanner fileIn = new Scanner(new File(args[0]));
		vertices = ReadGraph.readVertices(fileIn);
		for (int i = 0; i < vertices.length; i++)
			System.out.println(vertices[i]);
		adjList = ReadGraph.readEdgesAdjList(fileIn);
		String[] sorted = topSort();
		for (int i = 0; i < sorted.length; i++)
			System.out.println(sorted[i]);

		/*
		 * At this point, "sorted" contains the vertices in topologically-sorted
		 * order (or all NULLs if the graph is not acyclic
		 */
	}
}
