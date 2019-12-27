package nussbaum.compMethodologyProject;

import java.util.Scanner;

public class Main 
{
public static void main (String[]args) throws MissingDataException
{
	Scanner keyboard = new Scanner(System.in);
	
	System.out.println("Welcome to Super Shipping Service Company");
	
	System.out.println("please enter the sender's name");
	String senderName = keyboard.nextLine();
	
	System.out.println("Please enter your address");

	System.out.println("Street: ");
	String originStreet = keyboard.nextLine();
	System.out.println("City: ");
	String originCity = keyboard.nextLine();
	System.out.println("State: ");
	String originState = keyboard.nextLine().toUpperCase();
	System.out.println("Zip: ");
	String originZip = keyboard.nextLine();
	while (senderName == null ||originStreet == null || originStreet.equals("") || originCity == null || originCity.equals("") || originState == null || originState.equals("")
			|| originZip == null || originZip.equals("") || originZip.length()!=5) {
			System.out.println("Some fields are missing or invalid please try again");
			System.out.println("please enter the sender's name");
				senderName = keyboard.nextLine();
			
			System.out.println("Please enter your address");
			
			System.out.println("Street: ");
				originStreet = keyboard.nextLine();
			System.out.println("City: ");
				originCity = keyboard.nextLine();
			System.out.println("State: ");
				originState = keyboard.nextLine().toUpperCase();
			System.out.println("Zip: ");
				originZip = keyboard.nextLine();
			}
	Address from = new Address(senderName, originStreet, originCity, originState, originZip);
	
	System.out.println("please enter the recepient's name");
	String destinationName = keyboard.nextLine();
	
	System.out.println("Please enter the destination address");
	System.out.println("Street: ");
	String destinationStreet = keyboard.nextLine();
	System.out.println("City: ");
	String destinationCity = keyboard.nextLine();
	System.out.println("State: ");
	String destinationState = keyboard.nextLine().toUpperCase();
	System.out.println("Zip: ");
	String destinationZip = keyboard.nextLine();
	
	while (destinationStreet == null || destinationStreet.equals("") || destinationCity == null || destinationCity.equals("") || destinationState == null || destinationState.equals("")
			|| destinationZip == null || destinationZip.equals("") || destinationZip.length()!=5) {
			System.out.println("Some fields are missing or invalid please try again");
			System.out.println("please enter the sender's name");
				destinationName = keyboard.nextLine();
			
			System.out.println("Please enter your address");
			
			System.out.println("Street: ");
				destinationStreet = keyboard.nextLine();
			System.out.println("City: ");
				destinationCity = keyboard.nextLine();
			System.out.println("State: ");
				destinationState = keyboard.nextLine().toUpperCase();
			System.out.println("Zip: ");
				destinationZip = keyboard.nextLine();
			}
	
	Address to = new Address(destinationName, destinationStreet, destinationCity, destinationState, destinationZip);
	
	System.out.println("Please choose a shipping method:\n1.Standard(5-7 Days)\n2.Expedited(2-5 Days)\n3.Overnight");
	
	int serviceType=keyboard.nextInt();
	while(serviceType !=1 && serviceType != 2  && serviceType != 3) {
		System.out.println("You entered an invalid option");
		System.out.println("Please choose a shipping method:\n1.Standard(5-7 Days)\n2.Expedited(2-5 Days)\n3.Overnight");
		
		serviceType=keyboard.nextInt();
		
	}
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
	displayReceipt(shipment);
	
}

public static void displayReceipt(Shipment shipment)
{
System.out.println("Sender's Address:" + shipment.getFromAddress());
System.out.println("Recepient's Address:" + shipment.getToAddress());
System.out.println("__________________________________________________________________________________________");
System.out.println("\nItems in shipment:");
for(Item i: shipment.getItems())
{
System.out.println(i.format() + " Cost:" + i.calculateWeightCost());
}
System.out.println("-----------------------------");
System.out.println("Total Cost: " + shipment.calculateTotalWeightCost());
System.out.println("\nEstimated Delivery Date - On or Before: " + shipment.getEstimatedDeliveryDate());
System.out.println("Tracking Number: " + shipment.generateTrackingNumber());
System.out.println("\nThank you for using our service!");
}


	
}
