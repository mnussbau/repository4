package nussbaum.compMethodologyProject;



public class CustomerForm {
private final StringPrompter prompter;
private final Address address;
	
	public CustomerForm(StringPrompter prompter, Address address) {
		this.prompter = prompter;
		this.address = address;
	}
	public Customer enterCustomer() {
		
		
		String firstName = prompter.promptUser("Enter first name");
		String lastName = prompter.promptUser("Enter last name");
		String phoneNumber = prompter.promptUser("Enter  phone number");
		return new Customer(firstName, lastName, phoneNumber, this.address);
	}
	
	private String promptUser(String prompt) {
		
		return prompter.promptUser(prompt);
	}

}
