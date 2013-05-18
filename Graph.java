
public class Graph <E> implements Cloneable
{
	private boolean [][] edges;
	private Object [] labels;
	
	public <E> Graph(int nofVer)
	{
		edges = new boolean [nofVer][nofVer];//All values initially false
		labels = (E[]) new Object[nofVer];//All values initially null
	}
	public void addEdges(int source, int target)
	{
		edges[source][target] = true;
	}
	public Graph<E> clone()
	{
		Graph<E> cloned;
		try
		{ 
			cloned = (Graph<E>) super.clone();
		}
		catch(CloneNotSupportedException ex)
		{
			throw new RuntimeException("this class does not implement Clonable");
		}
		cloned.edges = edges.clone();
		cloned.labels = labels.clone();
		return cloned;
	}
	@SuppressWarnings("unchecked")
	public E getLable(int target)
	{
		return (E) labels[target];
	}
	public boolean isEdge(int source, int target)
	{ 
		return edges[source][target];
	}
	public int[] neighbors(int vertex)
	{
		int i;
		int count;
		int [] neighbor;
		//first count how many edges have the vertex as thier source
		count = 0;
		for(i = 0; i < labels.length; i++)
		{
			if(edges[vertex][i])
			{
				count++;
			}
		}
		//allocate the array for the answer
		neighbor = new int [count];
		//fill the array for the neighbor
		count = 0;
		for(i = 0; i < labels.length; i++)
		{
			if(edges[vertex][i])
			{
				neighbor[count++] = i;
			}
			
		}
		return neighbor;
	}//neighbor
	public void remoceEdge(int source, int target)
	{
		edges[source][target] = false;
	}
	public void setLabel(int vertex , E newLabel)
	{
		labels[vertex] = newLabel;
	}
}//class
