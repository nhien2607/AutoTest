package day5_dsNhanVien;

import java.util.Scanner;

public abstract class Employee {
	public String employee_id;
	public String employee_name;
	public int employee_exp;
	
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	
	public int getEmployee_exp() {
		return employee_exp;
	}
	public void setEmployee_exp(int employee_exp) {
		this.employee_exp = employee_exp;
	}
	public void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Mã nhân viên: ");
		setEmployee_id(scanner.nextLine());
		System.out.print("Tên nhân viên: ");
		setEmployee_name(scanner.nextLine());
		System.out.print("Năm kinh nghiệm: ");
		setEmployee_exp(scanner.nextInt());
		
	}
	public void output() {
		System.out.println("Mã Nhân viên: " + getEmployee_id() + "\n" + "Tên nhân viên: " + getEmployee_name());
	}
	public abstract void salary1();
	public abstract double salary();
}
