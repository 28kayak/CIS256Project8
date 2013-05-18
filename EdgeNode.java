
public class EdgeNode
{
	private int vertexNum;
	public EdgeNode(int vnum)
	{
		vertexNum = vnum;
	}
	public void setvnum(int vnum)
	{
		vertexNum = vnum;
	}
	public int getvnum()
	{
		return vertexNum;
	}
	public boolean equls(Object obj)
	{
		boolean equality = false;
		if(this.getClass() == obj.getClass())
		{
			if(this.getvnum() == ((EdgeNode) obj).getvnum())
			{
				return equality = true;
			}
		}
		return equality;
	}
	
}
