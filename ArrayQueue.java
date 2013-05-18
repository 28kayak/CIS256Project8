
public class ArrayQueue 
{
	private Object[] queue;
	//array that holds queue element
	private int capacity;
	//size of array: capacity of the queue
	private int numItems = 0;
	//number of items on the queue
	private int front = 0;
	//index of front of queue 
	private int rear = -1;
	//index of rear of queue 
	
	//constructors
	public ArrayQueue()
	{
		queue = new Object[100];
		capacity = 100;
	}
	public ArrayQueue(int maxSize)
	{
		queue = new Object[maxSize];
		capacity = maxSize;
	}
	public void enqueue(Object item)
	{//add an element to the front of this queue 
		rear = (rear + 1)%capacity;
		queue[rear] = item;
		numItems = numItems + 1;
		
	}
	public Object dequeue()
	{//remove an element from the rear of this queue
		Object toReturn = queue[front];
		queue[front] = null;
		front = (front + 1) % capacity;
		numItems = numItems - 1;
		return toReturn;
	}
	public boolean isEmpty()
	{//check if this empty is empty 
		return (numItems == 0);
	}
	public boolean isFull()
	{//check if this queue is full
		return (numItems == capacity);
	}
}
