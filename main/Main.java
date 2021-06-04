package main;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] methods = new String[7];
		for (int i = 0; i < methods.length; ++i) {
			methods[i] = "question" + (i + 1);
		}
		
		runAll(methods);
	}
	
	public static void printOut(Object s) {
		System.out.println(s);
	}
	
	public static void runAll(String[] methods) {
		var mainApp = new Main();
		
		try {
			for (int i = 0; i < methods.length; ++i) {
				printOut("Question " + (i + 1) + '\n');
				Main.class.getMethod(methods[i]).invoke(mainApp);
				printOut("----------------------------------");
			}			
		}
		catch (Exception e) {
			printOut("Uh oh!! Exception!");
			printOut(e.getMessage());
		}
	}
	
	public static void question1() {
		printOut("0000 0001");
		printOut("0000 1000");
		printOut("0010 0001");
		printOut("0100 1110");
		printOut("0000 0011 0001 0011");
		printOut("1000 0100 1100 0011");
	}
	
	public static void question2() {
		printOut("2");
		printOut("9");
		printOut("52");
		printOut("114");
		printOut("543");
		printOut("11367");
	}
	
	public static void question3() {
		int x;
		x = 2;
		
		printOut(Integer.toBinaryString(x));
		
		x <<= 1; // decimal: 4, binary string: 0100
		printOut(Integer.toString(x));
		printOut(Integer.toBinaryString(x));
	}
	
	public static void question4() {
		int x, y, z;
		
		x = 7;	// 0000 0111
		y = 17;	// 0001 0001
		// result of & bitwise operation: 00001
		
		z = 17 & 7;
		printOut(Integer.toString(z));
		printOut(Integer.toBinaryString(z));
		
		z = 17 | 7;
		// result of | bitwise operation: 10111
		printOut(Integer.toString(z));
		printOut(Integer.toBinaryString(z));
	}
	
	public static void question5() {
		int x;
		x = 3;
		printOut(x);
		
		x++;
		
		printOut(x);
	}
	
	public static void question6() {
		int x = 3;
		
		++x;
		printOut(x);
		x += 1;
		printOut(x);
		x = x + 1;
		printOut(x);
	}
	
	public static void question7() {
		int x, y;
		x = 5;
		y = 8;
		
		int sum = x++ + y;
		
		printOut(sum);
	}
}