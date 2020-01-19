package nussbaum.compMethodologyProject;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;


public class ReceiptTest 
{

	
	private Receipt receipt;
	private Item item;
	private Address addressFrom;
	private Address addressTo;
	private Customer custFrom;
	private Customer custTo;
	
	@Before
	public void setup() {
	
	addressFrom = new Address("1904 New York Ave", "Brooklyn", "NEWYORK", "11210");
	addressTo = new Address("east 27th", "Brooklyn", "NEWYORK", "11210");
	custFrom= new Customer("Joe",  "Shmoe", "1112223333", addressFrom);
	custTo = new Customer("Mary", "Jane", "1234567891", addressTo);	
	item = new Item("Gift Card", "1");

	}
	
	
	
	
	
	@Test
	public void testDisplayReceiptOvernightShipping()
	{
		Shipment shipment = new Shipment(custFrom, custTo, "OVERNIGHT");
		String trackingNum = shipment.getTrackingNumber();
		 shipment.addItem(trackingNum,  item);
		 receipt = new Receipt(shipment);
		 
		 LocalDateInterface clock = new StubLocalDate(LocalDate.of(2010,12,1));
		shipment.setlocalDate(clock);
		 
		 
		 String output = "Sender's Name: Joe Shmoe\n" + 
		 "Phone Number: (111) 222-3333\n" + 
		 "Address: Street: 1904 New York Ave City: Brooklyn State: NEWYORK ZipCode: 11210\n" + 
		 "\n" + 
		 "Recepient's Name: Mary Jane\n" + 
		 "Phone Number: (123) 456-7891\n" + 
		 "Address: Street: east 27th City: Brooklyn State: NEWYORK ZipCode: 11210\n" + 
		 "____________________________________________________________________\n" + 
		 "Items in shipment:\n" + 
		 "Gift Card: Weight Cost:1.5\n" + 
		 "--------------------------\n" + 
		 "Total Weight Cost:   $1.5\n" + 
		 "Distance Cost:       $0.0\n" + 
		 "Overnight Base Price:$15.0\n" + 
		 "--------------------------\n" + 
		 "Total Cost:          $16.5\n" + 
		 "\n" + 
		 "Estimated Delivery Date - On or Before: 2010-12-02\n" + 
		 "Tracking Number: " + trackingNum;
		
		assertEquals(output, receipt.displayReceipt());
		
	}
	
	
	
	@Test
	public void testDisplayReceiptStandardShipping()
	{
		Shipment shipment = new Shipment(custFrom, custTo, "STANDARD");
		String trackingNum = shipment.getTrackingNumber();
		 shipment.addItem(trackingNum,  item);
		 receipt = new Receipt(shipment);
		 
		 LocalDateInterface clock = new StubLocalDate(LocalDate.of(2010,12,1));
		shipment.setlocalDate(clock);
		 
		 
		 String output = "Sender's Name: Joe Shmoe\n" + 
		 "Phone Number: (111) 222-3333\n" + 
		 "Address: Street: 1904 New York Ave City: Brooklyn State: NEWYORK ZipCode: 11210\n" + 
		 "\n" + 
		 "Recepient's Name: Mary Jane\n" + 
		 "Phone Number: (123) 456-7891\n" + 
		 "Address: Street: east 27th City: Brooklyn State: NEWYORK ZipCode: 11210\n" + 
		 "____________________________________________________________________\n" + 
		 "Items in shipment:\n" + 
		 "Gift Card: Weight Cost:1.5\n" + 
		 "--------------------------\n" + 
		 "Total Weight Cost:   $1.5\n" + 
		 "Distance Cost:       $0.0\n" + 
		 "Standard Base Price: $5.0\n" + 
		 "--------------------------\n" + 
		 "Total Cost:          $6.5\n" + 
		 "\n" + 
		 "Estimated Delivery Date - On or Before: 2010-12-08\n" + 
		 "Tracking Number: " + trackingNum;
		
		assertEquals(output, receipt.displayReceipt());
	}
	
	@Test
	public void testDisplayReceiptExpeditedShipping()
	{
		
		Shipment shipment = new Shipment(custFrom, custTo, "EXPEDITED");
		String trackingNum = shipment.getTrackingNumber();
		 shipment.addItem(trackingNum,  item);
		 receipt = new Receipt(shipment);
		 
		 LocalDateInterface clock = new StubLocalDate(LocalDate.of(2010,12,1));
		shipment.setlocalDate(clock);
		 
		 
		 String output = "Sender's Name: Joe Shmoe\n" + 
		 "Phone Number: (111) 222-3333\n" + 
		 "Address: Street: 1904 New York Ave City: Brooklyn State: NEWYORK ZipCode: 11210\n" + 
		 "\n" + 
		 "Recepient's Name: Mary Jane\n" + 
		 "Phone Number: (123) 456-7891\n" + 
		 "Address: Street: east 27th City: Brooklyn State: NEWYORK ZipCode: 11210\n" + 
		 "____________________________________________________________________\n" + 
		 "Items in shipment:\n" + 
		 "Gift Card: Weight Cost:1.5\n" + 
		 "--------------------------\n" + 
		 "Total Weight Cost:   $1.5\n" + 
		 "Distance Cost:       $0.0\n" + 
		 "Expedited Base Price:$10.0\n" + 
		 "--------------------------\n" + 
		 "Total Cost:          $11.5\n" + 
		 "\n" + 
		 "Estimated Delivery Date - On or Before: 2010-12-06\n" + 
		 "Tracking Number: " + trackingNum;
		
		assertEquals(output, receipt.displayReceipt());
		
		
	}
}

