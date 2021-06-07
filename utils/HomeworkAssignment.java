package utils;

public abstract class HomeworkAssignment implements RunnableHomework {
	
	private String[] questions;
	
	public void initQuestionsList(int length) {
		questions = new String[length];

		for (int i = 0; i < length; ++i) {
			questions[i] = "question" + (i + 1);
		}
	}
	
	public void runAllQuestions() {
		
		try {

			for (int i = 0; i < questions.length; ++i) {
				printOut("Question " + (i + 1));
				this.getClass().getMethod(questions[i]).invoke(this);
				printOut("-------------------------------------");
			}
		}
		catch (Exception e) {
			printOut("Uh oh! Exception!");
			printOut(e.getMessage());
		}
		
	}
	
	public void printOut(Object s) {
		System.out.println(s);
	}
}
