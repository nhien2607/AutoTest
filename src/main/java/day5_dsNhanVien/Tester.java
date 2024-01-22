package day5_dsNhanVien;

public class Tester extends Employee {
	public double luongCoBan = 500;
	public double salary()
	{
		return luongCoBan * getEmployee_exp();
	}
	@Override
	public void salary1()
	{
		System.out.print("Lương của Tester là: " + salary());
	}

}
