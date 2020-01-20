package nussbaum.compMethodologyProject;

import nussbaum.compMethodologyProject.data.Item;
import nussbaum.compMethodologyProject.data.Shipment;
import nussbaum.compMethodologyProject.form.ItemForm;
import nussbaum.compMethodologyProject.form.ShipmentForm;
import nussbaum.compMethodologyProject.io.Prompter;

public class Program {

	private final Prompter prompter;
	private final ShipmentForm shippmentForm;
	private final ItemForm itemForm;
	private final ReceiptGenerator receiptGenerator;
	
	private Shipment shipment;

	public Program(Prompter prompter, ShipmentForm shippmentForm, ItemForm itemForm, ReceiptGenerator receiptGenerator) {
		this.prompter = prompter;
		this.shippmentForm = shippmentForm;
		this.itemForm = itemForm;
		this.receiptGenerator = receiptGenerator;
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

	public void createShipment() {
		if (shipment != null) {
			prompter.println("Existing shipment will be canceled");
			// TODO give user a chance to change their mind 
		}
		
		shipment = shippmentForm.enterShippingMethod();
		prompter.println("\nShipment Created");
		prompter.println("Tracking Number: " + shipment.getTrackingNumber());
	}

	public void addItem() {
		if (shipment == null) {
			prompter.println("You must first create a shipment");
			return;
		}
		
		Item item = itemForm.enterItemMethod();
		shipment.addItem(item);
		prompter.println("Item Added to Shipment");
	}

	public void completeShipment() {
		if (shipment == null) {
			prompter.println("You must first create a shipment");
			return;
		}
		
		if (shipment.getItems().isEmpty()) {
			prompter.println("You did not enter any items to the shipment yet!");
			return;
		} 
		
		prompter.println(receiptGenerator.displayReceipt(shipment));
		shipment = null;
	}
}
