package main.manager_trainee;

public class Trainee extends Employee {
	public Trainee(long id, String name, String address, long phone, double salary) {
		super(id, name, address, phone);
		setSalary(salary);
		calculateTransportAllowance();
	}
	
	@Override
	public double calculateTransportAllowance() {
		setTransportAllowance(getSpecialAllowance());
		return getSpecialAllowance();
	}
}
