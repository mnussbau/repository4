package nussbaum.compMethodologyProject;
public class AddressForm {
	private final Prompter prompter;

	public AddressForm(Prompter prompter) {
		this.prompter = prompter;
	}

	public Address enterAddress() {

		prompter.nextLine();
		String street = prompter.promptForString("Street: ");
		String city = promptUser("City: ");
		prompter.nextLine();
		String state = prompter.promptForString("State: ");
		int position = state.indexOf(" ");
		if (position >= 0)
			state = state.substring(0, position) + state.substring(position + 1);
		String zip = promptUser("Zip: ");
		while (zip.length() != 5) {
			prompter.println("Please enter a 5 digit zip code");
			zip = promptUser("Zip: ");
		}
		return new Address(street, city, state.toUpperCase(), zip);
	}

	private String promptUser(String prompt) {

		return prompter.promptForStringNext(prompt);
	}

}