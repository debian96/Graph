import java.util.LinkedList;
import java.util.Scanner;

class Graph {
	
	static Scanner sc = new Scanner(System.in);
	private int v;
	//An array of linked lists
	private LinkedList<Integer> adj[];//Adjacency Lists
	
	
	public Graph(int v) {
		this.v = v;
		
		// define the size of array as 
        // number of vertices
		adj = new LinkedList[v+1];
		
		// Create a new list for each vertex
        // such that adjacent nodes can be stored
		for (int i = 1; i < adj.length; i++) {
			adj[i] = new LinkedList<Integer>();
		}	
	}
	
	public static void main(String[] args) {
		int vertices,choice;
		System.out.println("Enter No Of Vertices:-");
		vertices = sc.nextInt();
		
		Graph graph = new Graph(vertices);

		while(true){

			System.out.println("---------------------------------------");
			System.out.println(" 1.Add Edge     ");
			System.out.println(" 2.Print Graph     ");
	                       
			System.out.println(" 8.Exit       ");
			System.out.println("---------------------------------------");
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();
			System.out.println("---------------------------------------");

			switch(choice)
			{
				case 1:
					graph.addEdge();
					break;
				case 2:
					graph.printGraph();
					break;
				case 8:
				    System.exit(0);
	                break;          
	            default:
	            	    System.out.println("\n Wrong Choice:\n");
	                break;
			}
		}
	}

	
	private  void printGraph() {
			System.out.print("VERTEX");
			System.out.print("                      ");
			System.out.print("ADJACENT NODES");
			System.out.println("");
			System.out.println("");
			
			for (int i = 1; i < v+1; i++) {
				System.out.print(i);
				System.out.print("                             ");
				for (Integer value : adj[i]) {
					System.out.print(value);
					System.out.print("  ");
				}
				System.out.println("");
			}	
	}

	// Adds an edge to an undirected graph
	private  void addEdge() {
		int source, dest;
		System.out.println("Enter Source:-");
		source = sc.nextInt();
		System.out.println("Enter Destination:-");
		dest = sc.nextInt();
		
		// Add an edge from src to dest. 
		adj[source].add(dest);
		
		// Since graph is undirected, add an edge from dest
        // to src also
		adj[dest].add(source);
		
		
	}
}
