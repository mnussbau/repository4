package nussbaum.compMethodologyProject;

import java.time.LocalDate;

public class StubLocalDate implements LocalDateInterface {
	private final LocalDate localDate;

	public StubLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}

	public LocalDate getCurrentDate() {

		return localDate;
	}

}
