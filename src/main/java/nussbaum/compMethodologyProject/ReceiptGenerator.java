package nussbaum.compMethodologyProject;

import nussbaum.compMethodologyProject.calc.CostCalculator;
import nussbaum.compMethodologyProject.calc.CostDetails;
import nussbaum.compMethodologyProject.calc.DeliveryDateEstimator;
import nussbaum.compMethodologyProject.data.Item;
import nussbaum.compMethodologyProject.data.Shipment;

public class ReceiptGenerator {
	private final CostCalculator costCalculator;
	private final DeliveryDateEstimator deliveryDateEstimator; 
	
	public ReceiptGenerator(CostCalculator costCalculator, DeliveryDateEstimator deliveryDateEstimator) {
		this.costCalculator = costCalculator;
		this.deliveryDateEstimator = deliveryDateEstimator;
	}

	public String displayReceipt(Shipment shipment) {
		StringBuilder sb = new StringBuilder();
		sb.append("Sender's Name: " + shipment.getFromFirstName() + " " + shipment.getFromLastName());
		sb.append("\nPhone Number: " + shipment.getFromPhoneNumber());
		sb.append("\nAddress:" + shipment.getFromAddress());
		sb.append("\n");
		sb.append("\nRecepient's Name: " + shipment.getTofirstName() + " " + shipment.getToLastName());
		sb.append("\nPhone Number: " + shipment.getToPhoneNumber());
		sb.append("\nAddress:" + shipment.getToAddress());
		sb.append("\n____________________________________________________________________");
		sb.append("\nItems in shipment:\n");
		for (Item i : shipment.getItems()) {
			sb.append(i.getDescription() + ":" + " Weight Cost:" + i.calculateWeightCost() + "\n");
		}
		sb.append("--------------------------");
		
		

		CostDetails costDetails = costCalculator.calculateShipmentCost(shipment);
		sb.append("\nTotal Weight Cost:   $" + costDetails.getWeightCost());
		sb.append("\nDistance Cost:       $" + costDetails.getDistanceCost());
		sb.append("\n" + shipment.getShippingMethod() + " Base Price: $" + costDetails.getBaseCost());
		sb.append("\n--------------------------");
		sb.append("\nTotal Cost:          $" + costDetails.getTotalCost());
		sb.append("\n\nEstimated Delivery Date - On or Before: " + deliveryDateEstimator.getEstimatedDeliveryDate(shipment));
		sb.append("\nTracking Number: " + shipment.getTrackingNumber());

		return sb.toString();
	}

}
