package nussbaum.compMethodologyProject;

public class ItemForm {

	private final Prompter prompter;

	public ItemForm(Prompter prompter) {
		this.prompter = prompter;
	}

	public Item enterItemMethod() {
		prompter.nextLine();
		String description = prompter.promptForString("Please enter a description for your item: ");
		String weight = promptUser("Please enter the weight of the item: ");
		return new Item(description, weight);

	}

	private String promptUser(String prompt) {

		return prompter.promptForStringNext(prompt);
	}

}
