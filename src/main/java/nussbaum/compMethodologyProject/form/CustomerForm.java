package nussbaum.compMethodologyProject.form;

import nussbaum.compMethodologyProject.data.Address;
import nussbaum.compMethodologyProject.data.Customer;
import nussbaum.compMethodologyProject.io.Prompter;

public class CustomerForm {
	private final Prompter prompter;
	private final AddressForm addressForm;

	public CustomerForm(Prompter prompter) {
		this.prompter = prompter;
		addressForm = new AddressForm(prompter);

	}

	public Customer enterCustomer() {

		String firstName = promptUser("First name: ");
		String lastName = promptUser("Last name: ");
		String phoneNumber = promptUser("Phone number: ");
		while (phoneNumber.length() != 10) {
			prompter.println("Please enter a 10 digit phone number");
			phoneNumber = promptUser("Phone number: ");

		}
		Address address = addressForm.enterAddress();
		return new Customer(firstName, lastName, phoneNumber, address);

	}

	private String promptUser(String prompt) {

		return prompter.promptForStringNext(prompt);
	}

}
