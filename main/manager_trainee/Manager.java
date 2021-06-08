package main.manager_trainee;

public class Manager extends Employee {
	
	public Manager(long id, String name, String address, long phone, double salary) {
		super(id, name, address, phone);
		setSalary(salary);
	}
}
