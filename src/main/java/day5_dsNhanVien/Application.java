package day5_dsNhanVien;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		double sumOfSalary = 0;
		double averageOfSalary = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập tổng số nhân viên: ");
		int totalEmployee = scanner.nextInt();
		Employee[] employee = new Employee[totalEmployee];

		for (int i = 0; i < totalEmployee; i++) {
			System.out.println("Nhập thông tin nhân viên thứ " + (i + 1) + ":");
			System.out.print("Chọn loại nhân viên (1 - Developer, 2 - Tester, 3 - BA): ");
			int choose = scanner.nextInt();

			if (choose == 1) {
				employee[i] = new Developer();
			} else if (choose == 2) {
				employee[i] = new Tester();
			} else if (choose == 3) {
				employee[i] = new BA();
			}
			employee[i].input();
		}
		System.out.println("Danh sách thông tin nhân viên:");
		for (int i = 0; i < totalEmployee; i++) {
			employee[i].output();
			employee[i].salary1();
			sumOfSalary += employee[i].salary();
			averageOfSalary = sumOfSalary / totalEmployee;
		}

		System.out.println("\nTổng lương của nhân viên là: " + (sumOfSalary * 1.1));
		System.out.println("Lương trung bình là: " + averageOfSalary);
		System.out.println("Thông tin của các nhân viên có mức lương cao hơn mức lương trung bình là: ");
        for (int i = 0; i < totalEmployee; i++) {
            if(employee[i].salary() > averageOfSalary){
                System.out.println(employee[i].getEmployee_name());
            }
	}
	}}
