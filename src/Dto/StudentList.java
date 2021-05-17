/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dto;
import helper.ScannerCus;
import helper.Validator;
import java.util.ArrayList;

/**
 *
 * @author Kaine
 */
public class StudentList extends ArrayList<Student> {
	
	public StudentList() {	
		super();
	}

	public Student search(String code) {
		code= code.trim().toUpperCase();
		for (int i = 0; i < this.size(); i++)
			if (this.get(i).getCode().equals(code)) return this.get(i);
		return null;
	}	

	private boolean isExist(String code) {
		code = code.trim();
		return search(code)!=null;
	}

	public void addStudent() {
		String newCode, newName;
		int newMark;
		String pattern = "^S*[0-9]{3}";
		
		ScannerCus sc = new ScannerCus();
		boolean isExist = false;

		do {
			do {
				newCode = sc.getString(Validator.StringType.ALPHANUM, 4, 4, "St. code S000: ");
				newCode = newCode.trim().toUpperCase();
			} while (!newCode.matches(pattern));
			
			isExist = isExist(newCode);	
			if (isExist) System.out.println("Code is duplicated!");
		} while (isExist);
		
		newName = sc.getString(Validator.StringType.ALPHANUMWITHSPACE, 1, Integer.MAX_VALUE, "Name of new student: ").trim().toUpperCase();

		newMark = sc.getInt(0, 10, "Invalid value, please try again", "Mark: ");

		Student st = new Student(newCode, newName, newMark);
		this.add(st);
		System.out.println("Student " + newCode + " has been added.");
	}

	public void searchStudent() {
		if (this.isEmpty()) System.out.println("Empty list. No search can be performed!");
		else {
			ScannerCus sc = new ScannerCus();
			String studentCode = sc.getString(Validator.StringType.ALPHANUMWITHSPACE, Integer.MIN_VALUE, Integer.MAX_VALUE, "Input student code for search: ");
			Student st = this.search(studentCode);
			
			if (st == null) System.out.println("Student " + studentCode + " doesn't existed");
			else System.out.println("Found: " + st);
		}
	}

	public void updataStudent() {
		if (this.isEmpty()) System.out.println("Empty list. No search can be performed!");
		else {
			ScannerCus sc = new ScannerCus();
			String studentCode = sc.getString(Validator.StringType.ALPHANUMWITHSPACE, Integer.MIN_VALUE, Integer.MAX_VALUE, "Input code of updated student: ");
			Student st = this.search(studentCode);

			if (st == null) System.out.println("Student " + studentCode + " doesn't existed");
			else {
				String oldName = st.getName();
				String msg = "Old name: " + oldName +", new name: ";
				String newName =  sc.getString(Validator.StringType.ALPHANUMWITHSPACE, 1, Integer.MAX_VALUE, msg);
				st.setName(newName);
				
				int oldMark = st.getMark();
				msg = "Old mark: " + oldMark + "New mark 0..10: "; 
				int newMark = sc.getInt(0, 10, "Invalid value, please try again", msg);
				st.setMark(newMark);

				System.out.println("Student " + st.getCode() + " has been updated.");
			}
		}
	}

	public void removeStudent() {
			if (this.isEmpty()) System.out.println("Empty list. No search can be performed!");
		else {
			ScannerCus sc = new ScannerCus();
			String studentCode = sc.getString(Validator.StringType.ALPHANUMWITHSPACE, Integer.MIN_VALUE, Integer.MAX_VALUE, "Input code of removed student: ");
			Student st = this.search(studentCode);

			if (st == null) System.out.println("Student " + studentCode + " doesn't existed");
			else {
				this.remove(st);
				System.out.println("Student " + studentCode + " has been removed.");
			}
		}
	}
	public void printAll() {
		if (this.isEmpty()) System.out.println("Empty list!");
		else {
			System.out.println("Student list: ");
			for (Student st: this) System.out.println(st);
			System.out.println("Total: " + this.size() + " student(s).");
		}
	}
	
}
