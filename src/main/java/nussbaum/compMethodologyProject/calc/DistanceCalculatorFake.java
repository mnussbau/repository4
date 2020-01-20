
package nussbaum.compMethodologyProject.calc;
import java.math.BigDecimal;

public class DistanceCalculatorFake implements DistanceCalculator {

	@Override
	public BigDecimal calculateDistanceInMiles(String fromZip, String toZip) {
		BigDecimal zipCodeFrom = new BigDecimal(fromZip);
		BigDecimal zipCodeTo = new BigDecimal(toZip);

		BigDecimal distance = zipCodeFrom.subtract(zipCodeTo);

		return distance.abs();

	}
}
