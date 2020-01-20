package nussbaum.compMethodologyProject.calc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class DistanceCalculatorReal implements DistanceCalculator {
	//used distance api for project because this didnt work
	
	
	@Override
	public BigDecimal calculateDistanceInMiles(String fromZip, String toZip) {
		try {
			URL url = new URL(
					"https://maps.googleapis.com/maps/api/distancematrix/json?origins=Boston,MA|Charlestown,MA&destinations=Lexington,MA|Concord,MA&departure_time=now&key=AIzaSyA4klNcIz8PQUsSreLXUTh4Affm1NOcR4o");
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			String full = "";
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				full += output;
			}

			return BigDecimal.ZERO;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}