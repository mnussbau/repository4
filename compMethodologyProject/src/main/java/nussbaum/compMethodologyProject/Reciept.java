package nussbaum.compMethodologyProject;

import java.util.ArrayList;
import java.util.List;

public class Reciept {
	private final Customer to;
	private final Customer from;
	private final Shipment shipment;
	private List<Item> items;
	public Reciept(Customer to, Customer from, Shipment shipment) {
		
		this.to = to;
		this.from = from;
		this.shipment = shipment;
		List<Item> items = new ArrayList<Item>();
		
	}
	
	
	public String displayReceipt()
	{
	StringBuilder sb = new StringBuilder();
	sb.append("Sender's Address:" + from.getAddress());
	sb.append("\nRecepient's Address:" + to.getAddress());
	sb.append("\n_________________________________________________________________________________________________");
	sb.append("\nItems in shipment:\n");
	for(Item i: items)
	{
		sb.append(i.getDescription() + " Cost:" + i.calculateWeightCost() + "\n");
	}
	sb.append("-----------------------------");
	sb.append("\nTotal Cost: " + shipment.calculateTotalWeightCost());
	sb.append("\nEstimated Delivery Date - On or Before: " + shipment.getEstimatedDeliveryDate());
	sb.append("\nTracking Number: " + shipment.generateTrackingNumber());
	sb.append("\n\nThank you for using our service!");


	return sb.toString();
	}

}
