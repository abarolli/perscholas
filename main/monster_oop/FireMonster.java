package main.monster_oop;

public class FireMonster extends Monster {
	
	public FireMonster(String name) {
		super(name);
	}
	
	@Override
	public String attack() {
		return "Fire shot!";
	}
}
