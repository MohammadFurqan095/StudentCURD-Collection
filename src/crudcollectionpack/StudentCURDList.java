package crudcollectionpack;

import java.util.*;
class Student {
	
	private int studentid;
	private String fname, lname, mobileno;
	
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
	public Student(int studentid, String fname, String lname, String mobileno) {
		this.studentid = studentid;
		this.fname = fname;
		this.lname = lname;
		this.mobileno = mobileno;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str=studentid+"\t "+fname+"\t "+lname+"\t "+mobileno;
		return str;
	}
}

interface StudentDAO{
	void insert(List<Student> students);
	void fetchall(List<Student> students);
	void delete(List<Student> students);
	void update(List<Student> students);
	int[] findStudentid(List<Student> students);
	
}

class StudentDAOImpl implements StudentDAO{

	@Override
	public void insert(List<Student> students) {
		// TODO Auto-generated method stub
		Student student=new Student();
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter student fname: ");
		student.setFname(sc.nextLine());
		System.out.print("Enter student last name: ");
		student.setLname(sc.nextLine());
		System.out.print("Enter student mobile number: ");
		student.setMobileno(sc.nextLine());
		System.out.print("Enter student id: ");
		student.setStudentid(sc.nextInt());
		
		students.add(student);
		System.out.println(student.getStudentid()+" inserted in collection");
	}

	@Override
	public void fetchall(List<Student> students) {
		// TODO Auto-generated method stub
		if(students.isEmpty()==true) {
			System.out.println("collection is empty");
			return;
		}
		for(Iterator<Student> itr=students.iterator();itr.hasNext()==true; ) {
			Student student=itr.next();
			System.out.println(student.toString());
		}
	}

	@Override
	public void delete(List<Student> students) {
		// TODO Auto-generated method stub
		if(students.isEmpty()==true) {
			System.out.println("collection is empty");
			return;
		}
		Scanner sc=new Scanner(System.in);
		System.out.print("enter student id to delete record: ");
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
	public void update(List<Student> students) {
		// TODO Auto-generated method stub
		if(students.isEmpty()==true) {
			System.out.println("collection is empty");
			return;
		}
		int[] res=this.findStudentid(students);
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
	public int[] findStudentid(List<Student> students) {
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
public class StudentCURDList {
	
	public static void main(String[] args) {
		
		StudentDAO dao=new StudentDAOImpl();
		Scanner sc=new Scanner(System.in);
		List<Student> student=new ArrayList<>();
		
		while(true)  {
			System.out.println("1. insert");
			System.out.println("2. Fetch all");
			System.out.println("3. Delete");
			System.out.println("4. modify existing  record by id");
			System.out.println("5. exit program");
			
			System.out.print("enter your choice? 1/2/3/4/5: ");
			int choice=sc.nextInt();
			
			switch(choice) {
			case 1:
				dao.insert(student);
				break;
			case 2:
				dao.fetchall(student);
				break;
			case 3:
				dao.delete(student);
				break;
			case 4:
				dao.update(student);
				break;
			case 5:
				System.out.println("thanx for using my software");
				System.exit(0);
			}
		}
	}
}
