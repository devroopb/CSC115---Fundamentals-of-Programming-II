public class Student{
	private String studentID;
	private String name;

	public static void main(String[]args){
		Student a = new Student();
		Student b = new Student("V00982754","Harry Potter");

		//System.out.println(a.getStudentID() + " " + a.getName());
		//System.out.println(a);

		//a.setName("aaaaaa");
		//System.out.println(a);
		//System.out.println(b);

		Student[]Fandom = new Student[10];										//Student array
		Fandom[0] = new Student ("V00245488","The Doctor");
		Fandom[1] = b;
		Fandom[2] = new Student ("V00245678","Percy Jackson");
		Fandom[3] = new Student ("V00348274","Katniss Everdean");
		Fandom[4] = new Student ("V00658774","Kal El");
		Fandom[5] = new Student ("V00687794","Ned Stark");
		Fandom[6] = new Student ("V00345746","Frodo Baggins");
		Fandom[7] = new Student ("V00984863","Dean Winchester");
		Fandom[8] = new Student ("V00373744","Bruce Wayne");
		Fandom[9] = new Student ("V00398798","Devroop Banerjee");
		
		System.out.println("Class List of Fandoms");

		for(int i = 0; i< Fandom.length; i++){
			System.out.println(Fandom[i]);
		}
	}

	public Student(){										//default constructor
		String studentID = null;
		String name = null;
	}

	public Student(String ID, String name){
		studentID = ID;
		this.name = name;
	}

	public void setStudentID(String studentID){

	}

	public void setName(String name){

	}

	public String getStudentID(){
		return studentID;
	}

	public String getName(){
		return this.name;
	}

	public String toString(){
		return studentID + " " + name;
	}
}