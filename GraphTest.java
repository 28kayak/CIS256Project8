
public class GraphTest 
{
	public static void main(String [] args)
	{
		int [] tonari = new int[5];
		Graph<Integer> g = new Graph<Integer>(5);
		g.addEdges(0, 3);
		g.addEdges(3, 2);
		g.addEdges(3, 3);
		g.addEdges(4, 2);
		g.addEdges(3, 4);
		g.printGraph();
		
		//g.neighbors(3);
		tonari = g.neighbors(3);
		for(int i = 0; i < tonari.length; i++)
		{
			System.out.println("tonari = " + tonari[i]);
		}
		//g.removeEdge(3, 2);
		g.removeEdge(4, 2);
		g.printGraph();
		g.setLabel(3, 3);//vertex and data
		System.out.println("label = " + g.getLable(3));//enter vertex num and get data
		if(g.isPath(0, 3))
		{
			System.out.println("yes, there is a path");
		}
		else
		{
			System.out.println("No, there is not path");
		}
		
	}
}
