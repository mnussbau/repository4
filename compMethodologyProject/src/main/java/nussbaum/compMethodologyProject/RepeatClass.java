package nussbaum.compMethodologyProject;

public class RepeatClass {
	private final StringPrompter prompter;
	
	public RepeatClass(StringPrompter prompter) {
			this.prompter = prompter;
	}
	
	
	
	private String promptUser(String prompt) {
		
		return prompter.promptUser(prompt);
	}

}
