import java.util.Scanner;
public class CoursePrerequisite 
{	
	public static void main(String [] args)
	{
		int courses;//get number of courses from user
		int action;//hold the choice that user choose;
		Scanner intScan = new Scanner(System.in);
		Scanner strScan = new Scanner(System.in);
		String prerequirement;//hold prerequirement course name 
		String course;//the course name you take
		
		
		System.out.println("How many courses are there??");
		courses = intScan.nextInt();
		
		Graph<String> graph = new Graph<String>(courses);
		System.out.println("1:Add a course");
		System.out.println("2:Enter relationship between courses");
		System.out.println("3:Remove relationship between courses");
		System.out.println("4:Print all courses that you can take right after the course done");
		System.out.println("4:Print all courses");
		action = intScan.nextInt();
		switch(action)
		{
			case 1:
			{//add a course
				System.out.println("Enter the course name");
				course = strScan.nextLine();
				graph.addEdges(, )
			}
			case 2:
			{//create a relationship between courses
				
			}
		}
		
		

		
		
		
	}//main
}//class
