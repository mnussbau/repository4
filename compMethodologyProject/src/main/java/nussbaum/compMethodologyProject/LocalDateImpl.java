package nussbaum.compMethodologyProject;
import java.time.LocalDate;

public class LocalDateImpl implements LocalDateInterface {

	public  LocalDate getCurrentDate() {
	
		return LocalDate.now();
	}

}
