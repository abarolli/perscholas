package main;

import utils.HomeworkAssignment;

public class Arrays extends HomeworkAssignment {
	
	public static void main(String[] args) {
		
		new Arrays().run();
	}
	
	public void run() {
		initQuestionsList(9);
		
		runAllQuestions();
	};
	
	public void question1() {
		int[] arr = new int[3];
		
		for (int i = 0; i < arr.length; ++i) {
			arr[i] = (1 + i);
			printOut(arr[i]);
		}
	}
	
	public void question2() {
		int[] arr = {13, 5, 7, 68, 2};

		printOut(arr[arr.length / 2]);
	}
	
	public void question3() {
		String[] arr = {"red", "green", "blue", "yellow"};
		
		printOut(arr.length);
		
		String[] arr1 = arr.clone();
		printOut(java.util.Arrays.toString(arr1));
	}
	
	public void question4() {
		int[] arr = {1, 2, 3, 4, 5};
		
		printOut(arr[0]);
		printOut(arr[arr.length - 1]);
		
//		printOut(arr[arr.length]); returns IndexOutOfBoundsException
		
//		arr[5] = 4; returns the same exception
	}
	
	public void question5() {
		int[] arr = new int[5];
		
		for (int i = 0; i < arr.length; ++i) {
			arr[i] = i * 2;
			printOut(arr[i]);
		}
	}
	
	public void question6() {
		int[] arr = {1, 2, 3, 4, 5};
		for (int i = 0; i < arr.length; ++i) {
			if (i != (arr.length / 2)) {
				printOut(arr[i]);
			}
		}
	}
	
	public void question7() {
		String[] arr = {"a", "b", "c", "d", "e"};
		
		String first = arr[0];
		arr[0] = arr[arr.length / 2];
		arr[arr.length / 2] = first;
		printOut(java.util.Arrays.toString(arr));
	}
	
	public void question8() {
		int[] arr = {4, 2, 9, 13, 1, 0};
		
		java.util.Arrays.sort(arr);
		printOut("Array in ascending order: " + java.util.Arrays.toString(arr));
		printOut("The smalles number is " + arr[0]);
		printOut("the largest number is " + arr[arr.length - 1]);
	}
	
	public void question9() {
		Object[] arr = {1, "2", "3", "4", 5.0};
		
		printOut(java.util.Arrays.toString(arr));
	}
}