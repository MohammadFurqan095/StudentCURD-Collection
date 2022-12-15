package Stack;

import java.util.*;

class Student {
	
	private int studentid;
	private String fname, lname,mobileno;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return studentid+"\t "+fname+"\t "+lname+"\t "+mobileno;
	}
	
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
	
	Student() {  }
	Student(int studentid, String fname, String lname, String mobileno) {
		this.studentid=studentid;
		this.fname=fname;
		this.lname=lname;
		this.mobileno=mobileno;
	}
}

class MyStudentStack {
	private Stack<Student> student=new Stack<>();
	public void push(Student students) {
		student.push(students);
		System.out.println(students+" insert into stack collection");
	}
	public void pop() {
		if(student.isEmpty()==true) {
			System.out.println("stack is empty");
			return;
		}
		Student remove=student.pop();
		System.out.println("removed from stack collection");
	}
	
	public void show() {
		if(student.isEmpty()==true) {
			System.out.println("stack is empty");
			return;
		}
			for(Iterator<Student> itr=student.iterator();
					itr.hasNext()==true;) {
				Student element=itr.next();
				System.out.println(element);
			}
}
}
public class StudentStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyStudentStack myStudentStack=new MyStudentStack();
		while(true) {
			System.out.println("--------------------------");
			System.out.println("1. Insert studen detailes in stack");
			System.out.println("2. remove last student record in stack");
			System.out.println("3. display student stack");
			System.out.println("4. exit programme");
			
			Scanner sc=new Scanner(System.in);
			System.out.print("enter your choice? 1/2/3/4: ");
			int choice=sc.nextInt();
			
			switch (choice) {
			case 1:
				Student student=new Student();
				Scanner sc1=new Scanner(System.in);
				System.out.print("enter first name: ");
				student.setFname(sc1.nextLine());
				System.out.print("enter last name: ");
				student.setLname(sc1.nextLine());
				System.out.print("enter mobile number: ");
				student.setMobileno(sc1.nextLine());
				System.out.print("enter student id: ");
				student.setStudentid(sc1.nextInt());
				
				myStudentStack.push(student);
				break;
			case 2: 
				myStudentStack.pop();
				break;
			case 3:
				myStudentStack.show();
				break;
			case 4:
				System.out.println("thanks for using my software");
			System.exit(0);
			default:
				System.out.println("invalid option given!!!");
				break;
			}
		}
	}

}
