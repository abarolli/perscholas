package main.manager_trainee;

public abstract class Employee {
	private long id;
	private String name;
	private String address;
	private long phone;
	private double salary;
	private double specialAllowance;
	private double transportAllowance;
	private double hra;
	
	public Employee(long id, String name, String address, long phone) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.specialAllowance = 250.8;
		this.hra = 1000.5;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public double calculateSalary() {
		salary = salary + (salary * specialAllowance / 100) + (salary * hra / 100);
		return salary;
	}
	
	public double calculateTransportAllowance() {
		transportAllowance = 0.1 * salary;
		return transportAllowance;
	}
	
	public void setTransportAllowance(double allowance) {
		transportAllowance = allowance;
	}
	
	public double getSpecialAllowance() {
		return specialAllowance;
	}
}
