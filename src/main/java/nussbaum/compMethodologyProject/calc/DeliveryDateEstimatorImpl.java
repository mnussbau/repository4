package nussbaum.compMethodologyProject.calc;

import java.time.LocalDate;

import nussbaum.compMethodologyProject.data.Shipment;

public class DeliveryDateEstimatorImpl implements DeliveryDateEstimator {

	public LocalDate getEstimatedDeliveryDate(Shipment shipment) {
		LocalDate today = LocalDate.now();
		return today.plusDays(getEstimatedDeliveryDays(shipment));
	}
	
	private int getEstimatedDeliveryDays(Shipment shipment) {
		switch(shipment.getShippingMethod()) {
		case STANDARD:
			return 7;
		case EXPEDITED:
			return 5;
		case OVERNIGHT:
			return 1;
		default:
			throw new IllegalArgumentException();
		}
	}
}
