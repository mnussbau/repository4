package nussbaum.compMethodologyProject.calc;

import java.time.LocalDate;

import nussbaum.compMethodologyProject.data.Shipment;

public interface DeliveryDateEstimator {
	LocalDate getEstimatedDeliveryDate(Shipment shipment);
}
