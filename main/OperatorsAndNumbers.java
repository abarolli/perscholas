package main;

import utils.HomeworkAssignment;

public class OperatorsAndNumbers extends HomeworkAssignment {

	public static void main(String[] args) {
		
		new Main().run();
	}

	public void run() {
		initQuestionsList(7);

		runAllQuestions();
	}
	
	public void question1() {
		printOut("1: 0000 0001");
		printOut("8: 0000 1000");
		printOut("33: 0010 0001");
		printOut("78: 0100 1110");
		printOut("787: 0000 0011 0001 0011");
		printOut("1000 0100 1100 0011");
	}
	
	public void question2() {
		printOut("2");
		printOut("9");
		printOut("52");
		printOut("114");
		printOut("543");
		printOut("11367");
	}
	
	public void question3() {
		int x;
		x = 2;
		
		printOut(Integer.toBinaryString(x));
		
		x <<= 1; // decimal: 4, binary string: 0100
		printOut(Integer.toString(x));
		printOut(Integer.toBinaryString(x));
	}
	
	public void question4() {
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
	
	public void question5() {
		int x;
		x = 3;
		printOut(x);
		
		x++;
		
		printOut(x);
	}
	
	public void question6() {
		int x = 3;
		
		++x;
		printOut(x);
		x += 1;
		printOut(x);
		x = x + 1;
		printOut(x);
	}
	
	public void question7() {
		int x, y;
		x = 5;
		y = 8;
		
		int sum = x++ + y;
		
		printOut(sum);
	}
}
