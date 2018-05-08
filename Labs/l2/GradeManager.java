/**
 name: GradeManager.java
 purpose: Process students' grades
 author: Devroop Banerjee
 last modified: 25/09/15
 list of credits: none
*/
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class GradeManager{
	/**
	 Open file named "fName", parse the data and construct an array of Student objects.
	 return the array.
	*/
	public static Student[] getInput(String fName)throws FileNotFoundException{
		//change the array size by reading the input file
		
		Scanner s = new Scanner(new File("classList.txt"));
		int size = s.nextInt();
		Student[] classList = new Student[size];
		
		

			for(int i = 0; i < size; i++){
				int num = s.nextInt();
				System.out.println(num);
			}	
		return classList;
	}
	
	/**
	 An interactive method to get student number and mark from keyboard. If user enters the required information, a Student object is created and returned. "null" is returned otherwise.
	*/
	public static Student addStudent(){
		System.out.print("Add a Student? Y/N ");
		Scanner console=new Scanner(System.in);
		String answer=console.nextLine().trim();
		answer=answer.toLowerCase();

		if (answer.charAt(0) == 'y'){
			System.out.print("Enter the student number: ");
			String strN=console.nextLine().trim();
			System.out.print("Enter the mark: ");
			int mark=console.nextInt();
			console.close();
			return new Student(strN, mark);
		}

		console.close();
		return null;
	}
	
	/**
	 Calculate the average mark from the array of Student objects in "list", the number of students is stored in "count". The result is a decimal number. Return the average as a double number.
	*/
	public static double average(Student[] list, int count){
		return 0.0;
	}
	
	/**
	 Print the student information to screen. "list" is an array of Student objects. 
	 "count" is the number of students in the array. 
	 The first line contains some descriptive words, then the student information is printed, one student per line. 
	 At the end, the class averaged is printed, preceded by some descriptive words. No return values.
	*/
	public static void report(Student[] list, int count){
	}
	
	/**
	 Double the size of the array "list". "list" is an array of Student objects. 
	 The values in "list" is copied to the newly created array. The enlarged array is returned.
	*/
	public static Student[] enlargeList(Student[] list){

		if(list.length == size){
			Student [] temp = new Student[(list.length)*2];
			for(int i = 0; i < list.length; i++){
				temp[i] = list[i];
			}
			list = temp;
		}
		return list;
	}
	
	public static void main(String[] args){
		if (args.length!=1){
			System.out.println("Usage GradeManager inputFileName");
			System.exit(1);
		}

		Scanner inFile=null;

		try{
			//do the whole try block in the lab
			Student[] classList=getInput(args[0]);
			int c = classList.length;
			report(classList,c);
			Student newone = addStudent();

			if(newone != null){
				if(c == classList.length);
			}
			classList[c] = newone;
			c++;
			report(classList,c); 
			
		}
		catch (FileNotFoundException fe){
			fe.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(inFile!=null)
				inFile.close();
		}
	}
}