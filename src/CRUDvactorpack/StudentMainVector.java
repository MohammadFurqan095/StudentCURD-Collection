package CRUDvactorpack;

import java.util.*;

class Student{
	
	private int studentid;
	private String fname, lname,mobileno;
	
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	
	Student() { }
	Student(int studentid, String fname, String lname, String mobileno){
		this.studentid=studentid;
		this.fname=fname;
		this.lname=lname;
		this.mobileno=mobileno;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return studentid+"\t "+fname+"\t "+lname+"\t "+mobileno; 
	}
}
interface StudentDAO {
	void add(Vector<Student> students);
	void show(Vector<Student> students);
	void delete(Vector<Student> students);
	void update(Vector<Student> students);
	int[] findstudentid(Vector<Student> students);
}
class StudentDAOImpl implements StudentDAO {

	@Override
	public void add(Vector<Student> students) {
		// TODO Auto-generated method stub
		
		Student student=new Student();
		Scanner sc=new Scanner(System.in);
		
		System.out.print("enter new first name: ");
		student.setFname(sc.nextLine());
		System.out.print("enter new last name: ");
		student.setLname(sc.nextLine());
		System.out.print("enter mobile number: ");
		student.setMobileno(sc.nextLine());
		System.out.print("enter student id: ");
		student.setStudentid(sc.nextInt());
		
		students.addElement(student);
		System.out.println("new student detailes insert successfully in vector collection");
	}

	@Override
	public void show(Vector<Student> students) {
		// TODO Auto-generated method stub
		
		if(students.isEmpty()==true) {
			System.out.println("vector collection for student is empty");
			return;
		}
		Enumeration<Student> enumeration=students.elements();
		while(enumeration.hasMoreElements()==true)  {
			Student element=enumeration.nextElement();
			System.out.println(element);
		}
	}

	@Override
	public void delete(Vector<Student> students) {
		// TODO Auto-generated method stub
		if(students.isEmpty()==true) {
			System.out.println("vector collection for student is empty");
			return;
		}
		Scanner sc=new Scanner(System.in);
		System.out.print("enter id for delete: ");
		int studentid=sc.nextInt();
		int index=-1;
		for(int i=0;i<students.size();i++) {
			Student student=students.get(i);
			if(student.getStudentid()==studentid)
				index=i;
		}
		if(index==-1)
			System.out.println("invalid student id given");
		else {
			students.remove(index);
			System.out.println("student removed with id= "+studentid);
		}
	}

	@Override
	public void update(Vector<Student> students) {
		// TODO Auto-generated method stub
		if(students.isEmpty()==true) {
			System.out.println("collection is empty");
			return;
		}
		int[] res=this.findstudentid(students);
		if(res==null) {
			System.out.println("invalid id given");
			return;
		}
		Student student=new Student();
		Scanner sc=new Scanner(System.in);
		System.out.print("enter modified first name: ");
		student.setFname(sc.nextLine());
		System.out.print("enter modified last name: ");
		student.setLname(sc.nextLine());
		System.out.print("enter modified mobile number: ");
		student.setMobileno(sc.nextLine());
		
		student.setStudentid(res[1]);
		students.set(res[0], student);
		System.out.println("record modified with studnet id= "+res[1]);
	}
	

	@Override
	public int[] findstudentid(Vector<Student> students) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("type existing studnet id to modify: ");
		int studentid=sc.nextInt();
		int index=-1;
		for(int i=0; i<students.size();i++) {
			Student student2=students.get(i);
			if(student2.getStudentid()==studentid) {
				index=i;
				break;
			}
		}
		if(index==-1)  {
			int[] res=null;
			return res;
		}
		int[] res=new int[2];
		res[0]=index;
		res[1]=studentid;
		return res;
	}
	
}
public class StudentMainVector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StudentDAO dao=new StudentDAOImpl();
		Scanner sc=new Scanner(System.in);
		Vector<Student> studnet=new Vector<>();
		while(true)  {
			System.out.println("-----------------------");
			System.out.println("1. insert");
			System.out.println("2. Fetch all");
			System.out.println("3. Delete");
			System.out.println("4. modify existing  record by id");
			System.out.println("5. exit program");
			
			System.out.print("enter your choice? 1/2/3/4/5: ");
			int choice=sc.nextInt();
			
			switch (choice) {
			case 1:
				dao.add(studnet);
				break;
			case 2: 
				dao.show(studnet);
				break;
			case 3:
				dao.delete(studnet);
				break;
			case 4:
				dao.update(studnet);
				break;
			case 5:
				System.out.println("thanx for using this software");
				System.exit(choice);
			}

		}
		
//		Vector<Student> mycollection;
//		mycollection=new Vector<>();
//		StudentDAO dao=new StudentDAOImpl();
//		while(true) {
//			for(int i=1;i<4;i++) {
//				dao.add(mycollection);
//			}
//			dao.show(mycollection);
//			break;
//		}
		
	}

}
