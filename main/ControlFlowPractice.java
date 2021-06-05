package main;

import java.util.Scanner;
import utils.HomeworkAssignment;


public class ControlFlowPractice extends HomeworkAssignment{
	
	public static void main(String[] args) {
		
		new ControlFlowPractice().run();
	}
	
	public void run() {
		initQuestionsList(6);
		
		runAllQuestions();
	}
	
	public void question1() {
		int x;
		x = 7;
		
		if (x < 10) printOut("Less than 10");
	
	}
	
	public void question2() {
		int x;
		x = 7;
		if (x < 10) printOut("Less than 10");
		else if (x > 10) printOut("Greater than 10");
		
	}
	
	public void question3() {
		int x;
		x = 15;
		
		if (x < 10) printOut("Less than 10");
		else if (x > 10 && x < 20) printOut("Between 10 and 20");
		else printOut("Greater than or equal to 20");
		
	}
	
	public void question4() {
		int x = 15;
		
		if (x < 10 || x > 20) printOut("Out of range");
		else printOut("In range");
	}
	
	public void question5() {
		
		Scanner myReader = new Scanner(System.in);
			
		printOut("Enter your grade: ");
		int grade = myReader.nextInt();
		
		if (grade < 0 || grade > 100) printOut("Score out of range");
		else if (grade < 60) printOut("F");
		else if (grade <= 69) printOut("D");
		else if (grade <= 79) printOut("C");
		else if (grade <= 89) printOut("B");
		else if (grade <= 100) printOut("A");
		
	}
	
	public void question6() {
		
		Scanner myReader = new Scanner(System.in);

		printOut("Enter an integer between 1 and 7:");
		int dayCode = myReader.nextInt();
		
		switch(dayCode) {
		case 1:
			printOut("Monday");
			break;
		case 2:
			printOut("Tuesday");
			break;
		case 3:
			printOut("Wednesday");
			break;
		case 4:
			printOut("Thursday");
			break;
		case 5:
			printOut("Friday");
			break;
		case 6:
			printOut("Saturday");
			break;
		case 7:
			printOut("Sunday");
			break;
		default:
			printOut("Out of range");
		}
	}
}