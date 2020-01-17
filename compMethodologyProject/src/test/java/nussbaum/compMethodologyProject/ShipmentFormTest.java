package nussbaum.compMethodologyProject;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ShipmentFormTest {

	@Test
	public void testEnterShipment() 
	{
		Prompter prompter  = Mockito.mock(Prompter.class);

		Mockito.when(prompter.promptForStringNext("First name: ")).thenReturn("Joe");
		Mockito.when(prompter.promptForStringNext("Last name: ")).thenReturn("Shmoe");
		Mockito.when(prompter.promptForStringNext("Phone number: ")).thenReturn("1112223333");

		
		Mockito.when(prompter.promptForString("Street: ")).thenReturn("111 East 1st Street");
		Mockito.when(prompter.promptForStringNext("City: ")).thenReturn("Brooklyn");
		Mockito.when(prompter.promptForString("State: ")).thenReturn("New York");
		Mockito.when(prompter.promptForStringNext("Zip: ")).thenReturn("11210");
		Mockito.when(prompter.promptForStringNext("Enter A Service Type:\nStandard(5-7 Days)\nExpedited(2-5 Days)\nOvernight")).thenReturn("STANDARD");
		
		AddressForm af = new AddressForm(prompter);
		Address fromAddress = af.enterAddress();
		CustomerForm cf = new CustomerForm(prompter);
		Customer from = cf.enterCustomer();
		ShipmentForm sf = new ShipmentForm(prompter);
		Shipment shipment = sf.enterShippingMethod();	
		
		assertEquals("Joe", from.getFirstName());
		assertEquals("Shmoe", from.getLastName());
		assertEquals("(111) 222-3333", from.getPhoneNumber());
		assertEquals("111 East 1st Street", fromAddress.getStreet());
		assertEquals("STANDARD", shipment.getShippingMethod());
		assertEquals(" Street: " + "111 East 1st Street" + " City: " + "Brooklyn" + " State: " + "NEWYORK"  + " ZipCode: " + "11210", shipment.getFromAddress());
		

}

}
