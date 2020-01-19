package nussbaum.compMethodologyProject;

public class Program {

	private final Prompter prompter;
	private final ShipmentForm sf;
	private final ItemForm iF;
	private Shipment shipment;

	public Program(Prompter prompter, ShipmentForm sf, ItemForm iF)

	{
		this.prompter = prompter;
		this.sf = sf;
		this.iF = iF;
	}

	public void showMenu() {
		prompter.println("Welcome to Super Shipping Service Company Inc.");
		int choice;
		while ((choice = getAnswer()) != 4) {

			switch (choice) {
			case 1:
				createShipment();
				break;

			case 2:			
				addItem();
				break;

			case 3:
				completeShipment();
				break;

			default:
				prompter.println("Invalid Option");
				break;

			}

		}

		prompter.println("\nThank you for using our service!");

	}

	public int getAnswer() {
		prompter.println("\nWhat would you like to do?");
		prompter.println("1. Create a Shipment");
		prompter.println("2. Add item to Shipment");
		prompter.println("3. Complete Shipment and display receipt");
		prompter.println("4. Exit");
		return prompter.promptForInt("please enter 1, 2, 3 or 4");
	}
	
	public void createShipment()
	{
		shipment = sf.enterShippingMethod();
		prompter.println("\nShipment Created");
		prompter.println("Tracking Number: " + shipment.getTrackingNumber());
	}

	public void addItem()
	{
		String trackingNumber = prompter.promptForStringNext("Enter tracking number");
		ItemForm iF = new ItemForm(prompter);
		Item item = iF.enterItemMethod();
		shipment.addItem(trackingNumber, item);
	}
	
	public void completeShipment()
	{
		if (shipment.getItems().isEmpty()) {
			prompter.println("You did not enter any items to the shipment yet!");
		} else {
			Receipt receipt = new Receipt(shipment);
			prompter.println(receipt.displayReceipt());
		}
	}
}
