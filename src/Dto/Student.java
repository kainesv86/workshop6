/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dto;

/**
 *
 * @author Kaine
 */
public class Student {
	private String code;
	private String name;
	private int mark;
	
	//Constructor

	public Student() {
		this.code = "";
		this.name = "";
		this.mark = 0;
	}
	
	public Student(String code, String name, int mark) {
		this.code = code.toUpperCase();
		this.name = name.toUpperCase();
		this.mark = (mark >= 0 && mark <= 10) ? mark : 0;
	}

	//Getter & Setter	

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		code = code.trim();
		if (code.length() > 0) this.code = code.toUpperCase(); 
	}	

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		name = name.trim();
		if (name.length() > 0) this.name = name.toUpperCase(); 
	}	

	public int getMark() {
		return this.mark;
	}

	public void setMark(int mark) {
		this.mark = (mark >= 0 && mark <= 10) ? mark : 0;
	}	

	//Method

	@Override
	public String toString() {
		return code + ", " + name + ", " + mark;
	}
}
