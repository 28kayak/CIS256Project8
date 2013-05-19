
public class GraphTest 
{
	public static void main(String [] args)
	{
		int [] tonari = new int[5];
		Graph<Integer> g = new Graph<Integer>(5);
		g.addEdges(0, 3);
		g.addEdges(3, 2);
		g.addEdges(1, 3);
		g.addEdges(2, 2);
		g.printGraph();
		
		//g.neighbors(3);
		tonari = g.neighbors(3);
		for(int i = 0; i < tonari.length; i++)
		{
			System.out.println("tonari = " + tonari[i]);
		}
		
	}
}
