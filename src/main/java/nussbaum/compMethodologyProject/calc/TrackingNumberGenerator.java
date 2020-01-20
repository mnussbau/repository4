package nussbaum.compMethodologyProject.calc;

import java.util.Random;

public class TrackingNumberGenerator {
	private static final Random random = new Random();
	private static final int TRACKING_NUMBER_LENGTH = 13;
	private static final String NUMBERS = "0123456789" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static String generateTrackingNumber() {

		StringBuilder sb = new StringBuilder(TRACKING_NUMBER_LENGTH);
		for (int i = 0; i < TRACKING_NUMBER_LENGTH; i++) {
			int index = random.nextInt(NUMBERS.length());
			sb.append(NUMBERS.charAt(index));
		}

		return sb.toString();

	}

}
