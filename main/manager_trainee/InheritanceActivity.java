package main.manager_trainee;

public class InheritanceActivity {
	public static void main(String[] args) {
		Manager m = new Manager(
					126534,
					"Peter",
					"Chennai, India",
					237844,
					65_000);
		
		System.out.println(m.calculateSalary());
		
		Trainee t = new Trainee(
					29846,
					"Jack",
					"Mumbai, India",
					442085,
					45_000);
		
		System.out.println(t.calculateSalary());
		
		for (Employee e : new Employee[] {m, t}) {
			System.out.println(e.calculateTransportAllowance());
		}
	}
}
