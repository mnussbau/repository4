package nussbaum.compMethodologyProject;

public class Receipt {

	private final Shipment shipment;

	public Receipt(Shipment shipment) {
		this.shipment = shipment;
	}

	public String displayReceipt() {
		StringBuilder sb = new StringBuilder();
		sb.append("Sender's Name: " + shipment.getFromfirstName() + " " + shipment.getFromlastName());
		sb.append("\nPhone Number: " + shipment.getFromPhoneNumber());
		sb.append("\nAddress:" + shipment.getFromAddress());
		sb.append("\n\nRecepient's Name: " + shipment.getTofirstName() + " " + shipment.getTolastName());
		sb.append("\nPhone Number: " + shipment.getToPhoneNumber());
		sb.append("\nAddress:" + shipment.getToAddress());
		sb.append("\n____________________________________________________________________");
		sb.append("\nItems in shipment:\n");
		for (Item i : shipment.getItems()) {
			sb.append(i.getDescription() + ":" + " Weight Cost:" + i.calculateWeightCost() + "\n");
		}
		sb.append("--------------------------");

		sb.append("\nTotal Weight Cost:   $" + shipment.calculateTotalWeightCost());
		sb.append("\nDistance Cost:       $" + shipment.calculateTotalDistanceCost());
		if (shipment.getShippingMethod().equals("STANDARD")) {
			sb.append("\nStandard Base Price: $" + shipment.getStandardbaseprice());
		}

		else if (shipment.getShippingMethod().equals("EXPEDITED")) {
			sb.append("\nExpedited Base Price:$" + shipment.getExpeditedbaseprice());

		}

		else {
			sb.append("\nOvernight Base Price:$" + shipment.getOvernightbaseprice());
		}

		sb.append("\n--------------------------");
		sb.append("\nTotal Cost:          $" + shipment.getTotalShipmentCost());
		sb.append("\n\nEstimated Delivery Date - On or Before: " + shipment.getEstimatedDeliveryDate());
		sb.append("\nTracking Number: " + shipment.getTrackingNumber());

		return sb.toString();
	}

}
