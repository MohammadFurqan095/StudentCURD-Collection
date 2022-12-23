package Com.SortedMapPack;

import java.util.*;

import javax.swing.colorchooser.AbstractColorChooserPanel;

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
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(String fname, String lname, String mobileno) {
		this.fname = fname;
		this.lname = lname;
		this.mobileno = mobileno;
	}
    
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return studentid+"\t "+fname+"\t "+lname+"\t "+mobileno;
	}
}

class Transaction {
	void create(SortedMap<Integer, Student> map, Student student) {
		int studentid=-1;
		if(map.isEmpty()==true) {
			studentid=1;
		}
		else {
			studentid=map.lastKey()+1;
		}
		student.setStudentid(studentid);
		map.put(student.getStudentid(), student);
		System.out.println(student+" created in collection");
	}
	void show(SortedMap<Integer, Student> map) {
		if(map.isEmpty()==true) {
			System.out.println("collection empty");
			return;
		}
		Set<Integer> set=map.keySet();
		for(Iterator<Integer> itr=set.iterator();
				itr.hasNext()==true;) {
			Integer key=itr.next();
			Student student2=map.get(key);
			System.out.println("key= "+key+" value= "+student2);
		}
	}
	
	void delete(SortedMap<Integer, Student> map, int studentid)  {
		if(map.isEmpty()==true)  {
			System.out.println("collection empty");
			return;
		}
		boolean found=map.containsKey(studentid);
		if(found==false) {
			System.out.println("Invalid student id given to delete");
		}
		else {
			Student delstudent=map.remove(studentid);
			System.out.println(delstudent+" removed from collection");
		}
	}
	
	void update(SortedMap<Integer, Student> map, Student student) {
		if(map.isEmpty()==true) {
			System.out.println("collection empty");
			return;
		}
		
		boolean found=map.containsKey(student.getStudentid());
		if(found==false) {
			System.out.println("invalid key given to modify");
		}
		else {
			map.put(student.getStudentid(), student);
			System.out.println(student+" modified in collection");
		}
	}
}
public class CRUDSortedMapStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SortedMap<Integer, Student> map;
		map=new TreeMap<>();
		Transaction transaction=new Transaction();
		while(true) {
			System.out.println("==================================");
			Scanner sc=new Scanner(System.in);
			
			System.out.println("1. register new ");
			System.out.println("2. show student");
			System.out.println("3. delete by student id");
			System.out.println("4. modify by student id");
			System.out.println("5. exit program***");
			System.out.print("enter your choice? 1/2/3/4/5: ");
			int choice=sc.nextInt();
			switch(choice) {
			
			case 1:
				Student student=new Student();
				Scanner sc1=new Scanner(System.in);
				System.out.print("etner new student first name: ");
				student.setFname(sc1.nextLine());
				System.out.print("enter new student last name: ");
				student.setLname(sc1.nextLine());
				System.out.print("enter new student mobile number: ");
				student.setMobileno(sc1.nextLine());
				transaction.create(map, student);
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
				Student student2=new Student();
				Scanner sc3=new Scanner(System.in);
				
				System.out.print("etner modified student first name: ");
				student2.setFname(sc3.nextLine());
				System.out.print("enter modified student last name: ");
				student2.setLname(sc3.nextLine());
				System.out.print("enter modified student mobile number: ");
				student2.setMobileno(sc3.nextLine());
				System.out.print("enter student id against which you want to modify?");
				student2.setStudentid(sc3.nextInt());
				transaction.update(map, student2);
				break;
			case 5: 
				if(map.isEmpty()==true)  {
					System.out.println("collection empty");
				}
				else {
					Set<Integer> set=map.keySet();
					for(Iterator<Integer> itr=set.iterator();
							itr.hasNext()==true;) {
						Integer key=itr.next();
						Student student3=map.get(key);
						System.out.println("key= "+key+" value= "+student3);
					}
				}
				System.out.println("Thanx for using my software****");
				System.exit(0);
				default:
					System.out.println("Invalid choice given!!!");
					break;
			}
		}
	}

}
