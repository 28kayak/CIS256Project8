
public class GraphTest 
{
	public static void main(String [] args)
	{
		Graph<Integer> g = new Graph<Integer>(5);
		g.addEdges(0, Integer.valueOf(5));
		g.printGraph();
		
	}
}
