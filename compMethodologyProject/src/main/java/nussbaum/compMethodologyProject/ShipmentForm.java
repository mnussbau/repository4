package nussbaum.compMethodologyProject;

public class ShipmentForm {
	
	private final StringPrompter prompter;
	private final Customer to;
	private final Customer from;
		
		public ShipmentForm(StringPrompter prompter, Customer to, Customer from) {
			this.prompter = prompter;
			this.to = to;
			this.from = from;
		}
		public Shipment enterShippingMethod() {
			
			
			String shippingMethod = prompter.promptUser("Enter A Service Type:\nOverNight\nExpedited\nStandard");
			return new Shipment(to, from, shippingMethod.toUpperCase() );
		}
		
		private String promptUser(String prompt) {
			
			return prompter.promptUser(prompt);
		}


}
