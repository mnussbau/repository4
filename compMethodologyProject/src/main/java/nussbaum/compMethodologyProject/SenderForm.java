package nussbaum.compMethodologyProject;

public class SenderForm {
	
	private final StringPrompter prompter;
	private final Address address;
		
		public SenderForm(StringPrompter prompter, Address address) {
			this.prompter = prompter;
			this.address = address;
		}
		public Customer enterSender() {
			
			
			String firstName = prompter.promptUser("Enter sender's first name");
			String lastName = prompter.promptUser("Enter  sender's last name");
			String phoneNumber = prompter.promptUser("Enter sender's phone number");
			return new Customer(firstName, lastName, phoneNumber, this.address);
		}
		
		private String promptUser(String prompt) {
			
			return prompter.promptUser(prompt);
		}

}
