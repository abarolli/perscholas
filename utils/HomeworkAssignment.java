package utils;

import java.util.ArrayList;

public abstract class HomeworkAssignment {
	
	private ArrayList<String> questions = new ArrayList<String>();
	
	public void initQuestionsList(int length) {
		for (int i = 0; i < length; ++i) {
			questions.add("question" + (i + 1));
		}
	}
	
	public void printOut(Object s) {
		System.out.println(s);
	}
	
	public void runAllQuestions() {
		
		try {
			ArrayList<String> arr = getQuestionsAll();
			for (int i = 0; i < arr.size(); ++i) {
				printOut("Question " + (i + 1));
				this.getClass().getMethod(arr.get(i)).invoke(this);
				printOut("-------------------------------------");
			}
		}
		catch (Exception e) {
			printOut("Uh oh! Exception!");
			printOut(e.getMessage());
		}
		
	}
	
	public ArrayList<String> getQuestionsAll() {
		return questions;
	}
}
