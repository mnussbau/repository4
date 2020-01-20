package nussbaum.compMethodologyProject.calc;

import java.math.BigDecimal;

public interface DistanceCalculator {
	BigDecimal calculateDistanceInMiles(String fromZip, String toZip);
}
