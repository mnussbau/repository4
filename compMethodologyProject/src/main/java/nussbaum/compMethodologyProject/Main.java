package nussbaum.compMethodologyProject;

import java.util.Scanner;

public class Main 
{
public static void main (String[]args) throws MissingDataException
{
	StringPrompter stringPrompter= new StringPrompterImpl();
	Scanner keyboard = new Scanner(System.in);
	
	System.out.println("Welcome to Super Shipping Service Company");
	
	System.out.println("Please enter your address");
	AddressForm af = new AddressForm(stringPrompter);
	Address sendersAddress = af.enterAddress();
	
	SenderForm sf = new SenderForm(stringPrompter, sendersAddress);
	Customer from = sf.enterSender();
	
	System.out.println("Please enter your address");
	Address receiversAddress = af.enterAddress();
	CustomerForm cf = new CustomerForm(stringPrompter, receiversAddress);
	Customer to = cf.enterCustomer();
	
	
	System.out.println("Please choose a shipping method:\n1.Standard(5-7 Days)\n2.Expedited(2-5 Days)\n3.Overnight");
	
	String serviceType=keyboard.nextLine();
	
	Shipment shipment = new Shipment (to, from, serviceType);
	boolean repeat = true;
	while(repeat)
	{
	
	System.out.println("What's the weight of the item in pounds? Weight limit is 50 pounds. ");
	double weight = keyboard.nextDouble();
	keyboard.nextLine();
	while(weight <= 0) {
		System.out.println("You entered an invalid weight. Please try again.");
			weight = keyboard.nextDouble();
		keyboard.nextLine();
	}
	System.out.println("Please enter a short description of the contents");
	String description= keyboard.nextLine();
	Item item = new Item(weight,description);
	
	
	
		shipment.addPackage(item);

	System.out.println("Would you like to add another package: Y or N?");
	String response = keyboard.nextLine();
	char letter = response.toUpperCase().charAt(0);
	if(letter == 'N')
	repeat=false;
		
	}
	
	System.out.println(shipment.displayReceipt());
	
}



	
}
