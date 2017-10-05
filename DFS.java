import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Dfs_Graph {
	
	static Scanner sc = new Scanner(System.in);
	 private int v;
	//An array of linked lists
	 private LinkedList<Integer> adj[];//Adjacency Lists
	
	
	public Dfs_Graph(int v) {
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
		
		Dfs_Graph graph = new Dfs_Graph(vertices);

		while(true){

			
			System.out.println("\n---------------------------------------");
			System.out.println(" 1.Add Edge     ");
			System.out.println(" 2.Print Graph     ");
			System.out.println(" 3.Depth First Traversal     ");
	                       
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
				case 3:
					graph.dfs();
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
	
	
	private  void dfsUtil(int source, boolean[] visited) {
		
		visited[source] = true;
		System.out.print(source+"\t");
		
		
		
		Iterator<Integer> i = adj[source].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
            	dfsUtil(n, visited);
        }
		
	}

	private void dfs() {
		
		System.out.println("Enter Source:-");
		int source = sc.nextInt();
		
		// Mark all the vertices as not visited(By default
        // set as false)
		boolean Visited[] = new boolean[v+1];
		
		
		dfsUtil(source,Visited);
		
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
		
		
		
	}
}
