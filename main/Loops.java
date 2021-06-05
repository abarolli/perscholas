package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utils.HomeworkAssignment;

public class Loops extends HomeworkAssignment{
	
	private static Loops mainApp = new Loops();
	
	public static void main(String[] args) {
		
		mainApp.run();
	}
	
	public void run() {
		initQuestionsList(9);
		
		runAllQuestions();
	}
	
	public void question1() {
		for (int i = 1; i <= 10; ++i) {
			printOut(i);
		}
	}
	
	public void question2() {
		int x = 0;
		while (x <= 100) {
			printOut(x);
			x += 10;
		}
	}
	
	public void question3() {
		
		int x = 1;
		do {
			printOut(x);
			++x;
		}
		while (x <= 10);
	}
	
	public void question4() {
		for (int i = 5; i <= 100; i += 5) {
			if (i >= 25 && i <= 75) continue;
			printOut(i);
		}
	}
	
	public void question5() {
		for (int i = 1; i <= 100; ++i) {
			if (i > 50) break;
			if (i % 5 == 0) printOut(i);
		}
	}
	
	public void question6() {
		
		final int NUMBER_OF_WEEKS = 2;
		final int NUMBER_OF_DAYS_PER_WEEK = 5;
		
		for (int i = 1; i <= NUMBER_OF_WEEKS; ++i) {
			printOut("Week " + i);
			for (int j = 1; j <= NUMBER_OF_DAYS_PER_WEEK; ++j) {
				printOut("Day " + j);
			}
		}
	}
	
	public void question7() {
		
		for (int i = 10; i <= 200; ++i) {
			String str = Integer.toString(i);
			String revStr = new StringBuilder(str).reverse().toString();
			
			if (str.equals(revStr)) printOut(i);
		}
		
	}
	
	public void question8() {
		
		int count = 0;
		while (true) {
			int currentFibNum = fibonacci(count);
			if (currentFibNum > 50) break;
			
			printOut(currentFibNum);
			++count;
		}
	}
	
	static private ArrayList<Integer> arr = new ArrayList<Integer>(List.of(0, 1));
	public int fibonacci(int n) {
		
		if (n < arr.size()) {
			return arr.get(n);
		}
		
		arr.add(fibonacci(n - 1) + fibonacci(n - 2));
		return arr.get(n);
	}
	
	public void question9() {
		for (int i = 0; i < 5; ++i) {
			for (int j = 0; j < 5; ++j) {
				printOut("Inner loop: i: " + i + ", j: " + j);
			}
		}
	}
}


// abstract class HomeworkAssignment {
	
// 	private ArrayList<String> questions = new ArrayList<String>();
	
// 	public void initQuestionsList(int length) {
// 		for (int i = 0; i < length; ++i) {
// 			questions.add("question" + (i + 1));
// 		}
// 	}
	
// 	public void printOut(Object s) {
// 		System.out.println(s);
// 	}
	
// 	public void runAllQuestions(Object targetObj) {
		
// 		Class targetClass = targetObj.getClass();
// 		try {
// 			for (int i = 0; i < getQuestionsAll().size(); ++i) {
// 				printOut("Question " + (i + 1));
// 				targetClass.getMethod(getQuestionsAll().get(i)).invoke(targetObj);
// 				printOut("-------------------------------------");
// 			}
// 		}
// 		catch (Exception e) {
// 			printOut("Uh oh! Exception!");
// 			printOut(e.getMessage());
// 		}
		
// 	}
	
// 	public ArrayList<String> getQuestionsAll() {
// 		return questions;
// 	}
// }