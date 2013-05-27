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
		do
		{	
			System.out.println("1:Add a course");
			System.out.println("2:Enter relationship between courses");
			System.out.println("3:Remove relationship between courses");
			System.out.println("4:Find if there is previous prerequirement");
			System.out.println("5:Find if there are courses that you will need to take");
			System.out.println("6:Print all courses that you will need to take");
			System.out.println("7:Print all courses\n8:See you");
			action = intScan.nextInt();
			switch(action)
			{
				case 1:
				{//add a course
					System.out.println("Enter the course name");
					course = strScan.nextLine();
					//System.out.println("Enter the course number 0 to " + course);
					//int courseNum = intScan.nextInt();
					
					int i;
					for(i= 0; graph.getLable(i)!= null && i < courses; i++)
					{	}
					if(i < courses)
					{
						graph.setLabel(i, course);	
				
					}
					//EdgeNode aClass = new EdgeNode(courseNum);
					//graph.setLabel(courseNum, course);
					
					break;
				}	
				case 2:
				{//create a relationship between courses
					System.out.println("Enter pre-requirement course name");
				 	String preRequirement = strScan.nextLine();
				 	int indexPrerequirment = graph.getIndex(preRequirement);
				 	System.out.println("prerequirement index" + indexPrerequirment);
				 	System.out.println("Enter the course name");
				 	String theCourse = strScan.nextLine();
				 	int courseIndex = graph.getIndex(theCourse);
				 	//if()
				 	graph.addEdges(indexPrerequirment, courseIndex);
				 	break;
				
				}
				case 3:
				{//remove relationship
					System.out.println("remove course relationship");
					System.out.println("Enter pre-requirement course name");
				 	String preRequirement = strScan.nextLine();
				 	int indexPrerequirment = graph.getIndex(preRequirement);
				 	System.out.println("Enter the course name");
				 	String theCourse = strScan.nextLine();
				 	int courseIndex = graph.getIndex(theCourse);
				 	graph.removeEdge(indexPrerequirment, courseIndex);
				 	break;
				}
				case 4:
				{//report if one course is immediate pre-requirement of another
					String classname;
					String anotherClass;
					int classIndex;
					int anotherIndex;
					System.out.println("Enter a course name");
					classname = strScan.nextLine();
					classIndex = graph.getIndex(classname);
					System.out.println("Enter another course name");
					anotherClass = strScan.nextLine();
					anotherIndex = graph.getIndex(anotherClass);
					
					if(graph.isEdge(anotherIndex,classIndex ))
					{
						System.out.println("test" + anotherClass + "is the pre-requirment course of " + classname);
					}
					else if(graph.isEdge(classIndex, anotherIndex))
					{
						System.out.println(classname + "is the pre-requirment course of " + anotherClass);
					}
					else
					{
						System.out.println("these are not immidiate course each other");
					}
					
					break;
				}
				case 5:
				{//there might have some pre-requirements
					String classname;
					String anotherClass;
					int classIndex;
					int anotherIndex;
					System.out.println("Enter a course name");
					classname = strScan.nextLine();
					classIndex = graph.getIndex(classname);
					System.out.println("Enter another course name");
					anotherClass = strScan.nextLine();
					anotherIndex = graph.getIndex(anotherClass);
					
					if(graph.isPath(classIndex, anotherIndex))
					{
						System.out.println("pre-requiremnt:"+ classname + "is one of prerequiment course of" + anotherClass);
					}
					else 
					{
						System.out.println("this is not pre-request course");
					}
						
					if(graph.isPath(anotherIndex, classIndex))
					{
						System.out.println("pre-pquest :" +anotherClass + "is one of prerequiment course of" + classname );
					}
					else
					{
						System.out.println("there is no realtionship");
					}
					break;
				}
				case 6:
				{//output the course that can take directly 
					String coursename;
					int courseIndex;
					int [] precourses; 
					System.out.println("enter the course name");
					coursename = strScan.nextLine();
					courseIndex = graph.getIndex(coursename);
					precourses = graph.neighbors(courseIndex);
					System.out.println("courses you are going to take");
					for(int index = 0; index < precourses.length; index++)
					{
						System.out.println(graph.getLable(precourses[index]));
					}
					break;
					
				}
				case 7:
				{//output all courses 
					System.out.println("the list of courses");
					for(int i = 0; i < courses; i++)
					{
						if(graph.getLable(i) != null)
						{
							System.out.println(graph.getLable(i));
						}
						else
						{
							System.out.println("Empty");
						}
					}
					break;
				}
				case 8:
				{
					System.out.println("Programmed by Kaya Ota");
					System.out.println("Thank you");
					break;
				}
				
			}
		}while(action != 8);
		

		
		
		
	}//main
}//class
