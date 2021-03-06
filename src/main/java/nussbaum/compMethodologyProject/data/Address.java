package nussbaum.compMethodologyProject.data;

import java.util.Arrays;

public class Address {

	private final String street;
	private final String city;
	private final USState state;
	private final String zipCode;

	public Address(String street, String city, String state, String zip) {
		this.street = street;
		this.city = city;
		USState st = USState.valueOf(state);
		this.state = st;
		this.zipCode = zip;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state.toString();
	}

	public String getZipCode() {
		return zipCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address that = (Address) obj;
		Object[] thatFields = { that.street, that.city, that.state, that.zipCode };
		Object[] thisFields = { this.street, this.city, this.state, this.zipCode };
		return Arrays.equals(thatFields, thisFields);
	}

	public String toString() {

		return " Street: " + street + " City: " + city + " State: " + state + " ZipCode: " + zipCode;

	}

}
