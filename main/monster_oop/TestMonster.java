package main.monster_oop;

public class TestMonster {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Monster m1 = new FireMonster("r2u2");
		Monster m2 = new WaterMonster("u2r2");
		Monster m3 = new StoneMonster("r2r2");
		
		Monster[] monsters = {m1, m2, m3};
		for (Monster m : monsters) {
			System.out.println(m.attack());
		}
		
		m1 = new StoneMonster("a2b2");
		System.out.println(m1.attack());
	}
}
