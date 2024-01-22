package day5_dsNhanVien;

public class Developer extends Employee {
	public double luongCoBan = 1000;
	public double salary()
	{
		return luongCoBan * getEmployee_exp();
	}
	@Override
	public void salary1() {
		System.out.print("Lương của Developer là: " + salary());
	}

}
