package com.example;

public class  Employee {
	
	private   String empId = "" ;
	private   String empName = "" ;
	private  int salary = 0;
	private String department;
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Employee(String empID, String empNAME,int salary,String department) {
		// TODO Auto-generated constructor stub
		this.empId = empID;
		this.empName = empNAME;
		this.salary = salary;
		this.department = department;
	}
	public Employee(int i, String empID, String empNAME,int salary) {
		// TODO Auto-generated constructor stub
		this.empId = empID;
		this.empName = empNAME;
		this.salary = salary;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String setEmpid(String empId) {
		return this.empId ;
	}
	
	public String setEmpname(String empName) {
		return this.empName;
	}
	public String getEmpid() {
		return empId;
	}
	public String getEmpname() {
		return empName;
	}
	

}
