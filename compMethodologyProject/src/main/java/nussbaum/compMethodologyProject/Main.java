package nussbaum.compMethodologyProject;

import java.util.Scanner;

public class Main 
{
public static void main (String[]args) throws MissingDataException
{
	Scanner keyboard = new Scanner(System.in);
	
	StringPrompter stringPrompter= new StringPrompterImpl();
	
	
	System.out.println("Welcome to Super Shipping Service Company");
	
	System.out.println("Please enter your address");
	AddressForm af = new AddressForm(stringPrompter);
	Address sendersAddress = af.enterAddress();
	
	SenderForm sf = new SenderForm(stringPrompter, sendersAddress);
	Customer from = sf.enterSender();
	
	
	Address receiversAddress = af.enterAddress();
	CustomerForm cf = new CustomerForm(stringPrompter, receiversAddress);
	Customer to = cf.enterCustomer();
	
	
	ShipmentForm shipmentForm = new ShipmentForm(stringPrompter, to, from);
	
	Shipment shipment = shipmentForm.enterShippingMethod();
	
	
	boolean repeat = true;
	while(repeat)
	{
	
	ItemForm iF= new ItemForm(stringPrompter);
	Item item = iF.enterItemMethod();
	
		shipment.addPackage(item);

	System.out.println("Would you like to add another package: Y or N?");
	String response = keyboard.nextLine();
	char letter = response.toUpperCase().charAt(0);
	if(letter == 'N')
	repeat=false;
		
	}
	Reciept receipt = new Reciept(to, from, shipment);
	receipt.displayReceipt();
	//System.out.println(shipment.displayReceipt());
	
}



	
}
