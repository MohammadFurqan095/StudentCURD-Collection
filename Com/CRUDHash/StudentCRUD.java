package Com.CRUDHash;

import java.util.*;

class Student {

	private int studentid;
	private String fname, lname, mobileno;
	
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
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(int studentid, String fname, String lname, String mobileno) {
		this.studentid = studentid;
		this.fname = fname;
		this.lname = lname;
		this.mobileno = mobileno;
	}
	
}
class Transaction {
	void show(Map<Integer, Student> map) {
		if(map.isEmpty()==true) {
			System.out.println("Collction is empty");
			return;
		}
		Set<Map.Entry<Integer, Student>> set;
		set=map.entrySet();
		Iterator<Map.Entry<Integer, Student>> itr;
		itr=set.iterator();
		while(itr.hasNext()==true) {
			Map.Entry<Integer, Student> element;
			element=itr.next();
			Integer key=element.getKey();
			Student student=element.getValue();
			System.out.println("key= "+key+" value= "+student);
		}
	}
	void insert(Map<Integer, Student> map, Student student) {
		map.put(student.getStudentid(), student);
		System.out.println(student+" one record inserted");
	}
	
	void delete(Map<Integer, Student> map, int studentid) {
		if(map.isEmpty()==true) {
			System.out.println("Collection is empty!!!");
			return;
		}
		if(map.containsKey(studentid)==true) {
			System.out.println("key fount!");
			Student studentdel=map.remove(studentid);
			System.out.println(studentdel+" Removed from collection");
		}
		else {
			System.out.println("invalid student id given");
		}
	}
	

	void update(Map<Integer, Student> map, Student student) {
		if(map.isEmpty()==true) {
			System.out.println("collection empty");
			return;
		}
		if(map.containsKey(student.getStudentid())==true) {
			System.out.println("key found");
			map.put(student.getStudentid(), student);
			System.out.println("Modified successfully");
		}
		else {
			System.out.println("invalid key given");
		}
	}
}
public class StudentCRUD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<Integer, Student> map;
		map=new HashMap<Integer, Student>();
		
		Transaction transaction=new Transaction();
		
		while(true) {
			System.out.println("------------------");
			Scanner sc=new Scanner(System.in);
			System.out.println("1. register new student");
			System.out.println("2. display all student");
			System.out.println("3. delete by id");
			System.out.println("4. modify by id");
			System.out.println("5. exit program");
			System.out.print("enter your choice? 1/2/3/4/5: ");
			 
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				Scanner sc1=new Scanner(System.in);
				Student student=new Student();
				System.out.print("enter new first name: ");
				student.setFname(sc1.nextLine());
				System.out.print("enter new last naem: ");
				student.setLname(sc1.nextLine());
				System.out.print("enter new student mobile number: ");
				student.setMobileno(sc1.nextLine());
				System.out.print("enter new studnet id: ");
				student.setStudentid(sc1.nextInt());
				
				transaction.insert(map, student);
				break;
			case 2: 
				transaction.show(map);
				break;
			case 3:
				Scanner sc2=new Scanner(System.in);
				System.out.print("enter student id to delete: ");
				int studentid=sc2.nextInt();
				transaction.delete(map, studentid);
				break;
			case 4:
				Scanner sc3=new Scanner(System.in);
				Student student2=new Student();
				System.out.print("enter modify first name: ");
				student2.setFname(sc3.nextLine());
				System.out.print("enter modify last name: ");
				student2.setLname(sc3.nextLine());
				System.out.print("enter modify mobile number: ");
				student2.setMobileno(sc3.nextLine());
				System.out.print("enter modify student id: ");
				student2.setStudentid(sc3.nextInt());
				transaction.update(map, student2);
				break;
			case 5: 
				System.exit(0);
				default:
					System.out.println("Invalid choice given!!");
					break;
			}
			
		}
	}

}
