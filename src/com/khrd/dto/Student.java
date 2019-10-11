package com.khrd.dto;

public class Student {
	private int no ;
	private String name;
	private int kor;
	private int math;
	private int eng;
	
	public Student() {}
	
	public Student(int no, String name, int kor, int math, int eng) {
		super();
		this.no = no;
		this.name = name;
		this.kor = kor;
		this.math = math;
		this.eng = eng;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	@Override
	public String toString() {
		return "Student [no=" + no + ", name=" + name + ", kor=" + kor + ", math=" + math + ", eng=" + eng + "]";
	}
	
}
