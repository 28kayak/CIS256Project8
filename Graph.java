import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
public class Graph <E> implements Cloneable
{
	//private boolean [][] edges;
	private LinkedList<EdgeNode> [] edges;
	//private Object [] edges;
	private Object [] vertexList;
	private int [] numOfEdges;
	private int vertexCounter;
	//private ArrayList<E> labels;
	@SuppressWarnings("unchecked")
	public <E> Graph(int nofVer)
	{
		//System.out.println("constructing");
		edges = (LinkedList<EdgeNode>[]) new  LinkedList[nofVer];
		for(int i = 0; i < nofVer; i++)
		{
			edges[i] = new LinkedList();
		}
		
		vertexList = (E[]) new Object [nofVer];
		numOfEdges = new int[nofVer];
		vertexCounter = 0;
	}
	//private ArrayList<E> labels;
	
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
		//ArrayQueue queue = new ArrayQueue(edges.length);
		//int i;
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
			System.out.println(neighbor[count]);
			count++;
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
		vertexCounter++;
	}
	
	public boolean isPath(int source, int target)
	{
		//System.out.println("inside of isPath");
		boolean [] processed;
		int [] neighbor;
		//int count = 0;
		ArrayQueue queue = new ArrayQueue(vertexList.length);
		processed = new boolean [vertexList.length]; 
		//Graph<E> cursor;
		int deQ;
		//do a process
		//((Graph<E>) vertexList[source]).getLable(target);
		//mark processed vertex
		processed[source] = true;
		//enter vertex in queue 
		queue.enqueue(source);
		//get into Step 1
		while(!queue.isEmpty())
		{
			//System.out.println("inside of while");
			//pop from queue 
			 deQ = (int) queue.dequeue();
			//System.out.println(cursor.getLable(cursor.vertexList[]))
			System.out.println();
			neighbor = this.neighbors(deQ);
			for(int i = 0; i < neighbor.length; i++)
			{
				System.out.println("in side of for loop");
				//isPath() returns in the middle of checking. 
				//if(neighbor[i] == target)
				//{
					//return true;
				//}
				//else
				//{
					if(processed[neighbor[i]] == false)
					{
						//System.out.println("inside of if-statement");
						System.out.println(neighbor[i]);
						processed[neighbor[i]] = true;
						queue.enqueue(neighbor[i]);
					}
				//}
			}
		}
		if(processed[target])
		{//inside of processed means the source has a path to reaches target
			return true;
		}
		else
		{
			return false;
		}
				
		
	}
	
	public void printGraph()
	{
		for(int i = 0; i < edges.length; i++)
		{
			//System.out.print(i);
			for(int j = 0; j < edges.length; j++)
			{
				//System.out.print(j);
				if(isEdge(i, j))
				{
					System.out.print(" T ");
				}
				else
				{
					System.out.print(" F ");
				}
			}
			System.out.println();
			
		}
	}
	
	@SuppressWarnings("unchecked")
	public int getIndex(E label)
	{
		for(int i = 0; i < vertexList.length; i++)
		{
			System.out.println("label =" + label);
			System.out.println("vertex list = " + vertexList[i]);
			if(label.equals((E)vertexList[i]))
			{
				return i;
			}
		}
		return -1;
	}
}//class
