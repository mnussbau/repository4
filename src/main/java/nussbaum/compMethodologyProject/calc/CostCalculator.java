package nussbaum.compMethodologyProject.calc;

import java.math.BigDecimal;
import java.util.List;

import nussbaum.compMethodologyProject.data.Address;
import nussbaum.compMethodologyProject.data.Item;
import nussbaum.compMethodologyProject.data.Shipment;

public class CostCalculator {
	private static final BigDecimal COST_PER_MILE = new BigDecimal("2.5");
	
	private final DistanceCalculator distanceCalculator;
	
	public CostCalculator(DistanceCalculator distanceCalculator) {
		this.distanceCalculator = distanceCalculator;
	}

	public CostDetails calculateShipmentCost(Shipment shipment) {
		BigDecimal baseCost = shipment.getShippingMethod().getBasePrice();
		BigDecimal distanceCost = calculateTotalDistanceCost(shipment.getFromAddress(), shipment.getToAddress());
		BigDecimal weightCost = calculateTotalWeightCost(shipment.getItems());
		BigDecimal totalCost = baseCost.add(distanceCost).add(weightCost);
		
		return new CostDetails(baseCost, distanceCost, weightCost, totalCost);
	}

	private BigDecimal calculateTotalWeightCost(List<Item> items) {
		BigDecimal sum = BigDecimal.ZERO;
		for (Item i : items) {
			sum = sum.add(i.calculateWeightCost());
		}

		return sum;
	}

	private BigDecimal calculateTotalDistanceCost(Address fromAddress, Address toAddress) {
		BigDecimal distance = distanceCalculator.calculateDistanceInMiles(fromAddress.getZipCode(), toAddress.getZipCode());
		return distance.multiply(COST_PER_MILE);
	}

}
