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
	
	public void runAllQuestions(Object targetObj) {
		
		Class targetClass = targetObj.getClass();
		try {
			for (int i = 0; i < getQuestionsAll().size(); ++i) {
				printOut("Question " + (i + 1));
				targetClass.getMethod(getQuestionsAll().get(i)).invoke(targetObj);
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