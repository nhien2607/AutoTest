package day5_dsNhanVien;

public class BA extends Employee {
	public double luongCoBan = 800;
	public double salary()
	{
		return luongCoBan * getEmployee_exp();
	}
	@Override
	public void salary1()
	{
		System.out.print("Lương của BA là: " + salary());
	}
	
}
