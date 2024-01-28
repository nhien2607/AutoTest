package day7_Homework;

import java.util.Scanner;

import day5_dsNhanVien.Employee;

public class nhanVien {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập tổng số nhân viên: ");
		int tongNhanVien = scanner.nextInt();
		String Nhanvien[] = new String [tongNhanVien];
		Scanner scanner2 = new Scanner(System.in);
		System.out.println("Nhập tên nhân viên: ");
		for (int i = 0; i < tongNhanVien; i++) {
			Nhanvien[i] = scanner2.nextLine();
		}
		for (int i = 0; i < tongNhanVien; i++) {
			System.out.println("Danh sách tên nhân viên:" + Nhanvien[i]);
		}
	}

}