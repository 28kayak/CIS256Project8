import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
public class Graph <E> implements Cloneable
{
	//private boolean [][] edges;
	//private LinkedList<EdgeNode> [] edges;
	private Object [] edges;
	private Object [] vertexList;
	private int [] numOfEdges;
	//private ArrayList<E> labels;
	@SuppressWarnings("unchecked")
	public <E> Graph(int nofVer)
	{
		//edges = new (LinkedList<EdgeNode>) Object[nofVer];
		//edges = new boolean [nofVer][nofVer];//All values initially false
		//labels = (ArrayList<E>) new ArrayList<E>();//All values initially null
		edges = (LinkedList<EdgeNode>[]) new  Object[nofVer];
		/*for(int i = 0; i < nofVer; i++)
		{
			edges[i] = new LinkedList();
		}
		*/
		vertexList = (E[]) new Object [nofVer];
		numOfEdges = new int[nofVer];
	}
	@SuppressWarnings("unchecked")
	public void addEdges(int source, int target)
	{
		// boolean success;
		//edges[source][target] = true;
		//((LinkedList<EdgeNode>) edges[source]).addLast(new EdgeNode(target));
		if(isEdge(source, target))
		{//duplicate edge
			System.out.println("duplicate edges");
		}
		else
		{
			((LinkedList<EdgeNode>)edges[source]).addLast(new EdgeNode(target));
			numOfEdges[source]++;
		}
		 
	}
	@SuppressWarnings("unchecked")
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
		cloned.vertexList = vertexList.clone();
		return cloned;
	}
	@SuppressWarnings("unchecked")
	public E getLable(int target)
	{
		return (E) vertexList[target];
	}
	public boolean isEdge(int source, int target)
	{ 
		@SuppressWarnings("unchecked")
		Iterator<EdgeNode> iterator = ((LinkedList<EdgeNode>)edges[source]).iterator();
		while(iterator.hasNext())
		{
			if(target == iterator.next().getvnum())
			{
				return true;
			}
		}
		return false;
		
		//if(((LinkedList<EdgeNode>)edges[source]).listIterator(target) == null);
		//return edges[source][target];
	}
	public int[] neighbors(int vertex)
	{
		ArrayQueue queue = new ArrayQueue(edges.length);
		int i;
		int count;
		int [] neighbor;
		//EdgeNode cursor;// = (LinkedList<EdgeNode>) edges[];
		Iterator<EdgeNode> iterator = ((LinkedList<EdgeNode>)edges[vertex]).iterator();
		//first count how many edges have the vertex as their source
		count = 0;
		neighbor = new int [numOfEdges[vertex]];
		while(iterator.hasNext())
		{
			neighbor[count] = iterator.next().getvnum();
			//queue.enqueue(iterator);
		}
		
		/*
		 * 
		for(i = 0; i < vertexList.length; i++)
		{
			if(iterator.hasNext())
			{
				count++;
			}
		}
		//allocate the array for the answer
		neighbor = new int [count];
		//fill the array for the neighbor
		count = 0;
		for(i = 0; i < vertexList.length; i++)
		{
			if(iterator.hasNext())
			{
				neighbor[count++] = i;
			}
			
		}
		*/
		return neighbor;
	}//neighbor
	@SuppressWarnings("unchecked")
	public void removeEdge(int source, int target)
	{
		Iterator<EdgeNode> iterator = ((LinkedList<EdgeNode>)edges[source]).iterator();
		if(target == iterator.next().getvnum())
		{
			((LinkedList<EdgeNode>)edges[source]).remove();
		}
		//edges[source][target] = false;
	}
	public void setLabel(int vertex , E newLabel)
	{
		vertexList [vertex] = newLabel;
	}
	/*
	public boolean isPath(int source, int target)
	{
		boolean [] processed; 
		
		
	}
	*/
	public void printGraph()
	{
		for(int i = 0; i < edges.length; i++)
		{
			for(int j = 0; j < edges.length; j++)
			{
				if(isEdge(i, j))
				{
					System.out.print("T ");
				}
				else
				{
					System.out.print("F");
				}
			}
			System.out.println();
			
		}
	}
}//class
