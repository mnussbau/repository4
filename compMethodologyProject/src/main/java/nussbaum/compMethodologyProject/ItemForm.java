package nussbaum.compMethodologyProject;

public class ItemForm {
	
	private final StringPrompter prompter;
	
	public ItemForm(StringPrompter prompter) {
		this.prompter = prompter;
	}
	
	public Item enterItemMethod() {
		String weight = prompter.promptUser("Please enter your weight: ");
		String description = prompter.promptUser("Please enter a description for your item: ");
		return new Item(weight, description);
		
	}
	
	
	
	private String promptUser(String prompt) {
		
		return prompter.promptUser(prompt);
	}

}
