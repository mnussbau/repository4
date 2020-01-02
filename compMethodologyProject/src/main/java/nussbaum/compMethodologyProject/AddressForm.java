package nussbaum.compMethodologyProject;



	
	public class AddressForm {
		private final StringPrompter prompter;
		
		public AddressForm(StringPrompter prompter) {
			this.prompter = prompter;
		}
		public Address enterAddress() {
			
			
			String street = prompter.promptUser("Enter your street: ");
			String city = prompter.promptUser("Enter your city: ");
			String state = prompter.promptUser("Enter your state: ");
			String zip = prompter.promptUser("Enter your zip: ");
			return new Address(street, city, state, zip);
		}
		
		private String promptUser(String prompt) {
			
			return prompter.promptUser(prompt);
		}

}
