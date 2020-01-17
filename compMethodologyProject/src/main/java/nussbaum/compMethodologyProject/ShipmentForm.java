package nussbaum.compMethodologyProject;

public class ShipmentForm {
	
	private final Prompter prompter;
	private final CustomerForm toForm;
	private final CustomerForm fromForm;
		
		public ShipmentForm(Prompter prompter) {
			this.prompter = prompter;
			toForm = new CustomerForm(prompter);
			fromForm = new CustomerForm(prompter);
		
		}
		public Shipment enterShippingMethod() {
			
			prompter.println("Enter Sender's address");
			Customer from = fromForm.enterCustomer();
			prompter.println("Enter Recepient's address");
			Customer to  = toForm.enterCustomer();
			String shippingMethod = prompter.promptForStringNext("Enter A Service Type:\nStandard(5-7 Days)\nExpedited(2-5 Days)\nOvernight");
		
			return new Shipment (from, to, shippingMethod.toUpperCase() );
		}
	

}
