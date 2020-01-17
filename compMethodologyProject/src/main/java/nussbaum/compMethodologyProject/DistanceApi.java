
package nussbaum.compMethodologyProject;
import java.math.BigDecimal;

public class DistanceApi {

	private String to;
	private String from;

	public DistanceApi(String to, String from) {
		this.to = to;
		this.from = from;

	}

	public BigDecimal calculateDistance() {
		BigDecimal zipCodeFrom = new BigDecimal(to);
		BigDecimal zipCodeTo = new BigDecimal(from);

		BigDecimal distance = zipCodeFrom.subtract(zipCodeTo);

		return distance.abs();

	}
}
