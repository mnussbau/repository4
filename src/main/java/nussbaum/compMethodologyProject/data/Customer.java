package nussbaum.compMethodologyProject.data;

public class Customer {
	private final String firstName;
	private final String lastName;
	private final String phoneNumber;
	private final Address address;

	public Customer(String fName, String lName, String phoneNum, Address address) {
		this.firstName = fName;
		this.lastName = lName;
		this.phoneNumber = phoneNum.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "Name: " + firstName + lastName + " Phone Number:" + phoneNumber + " Address: " + address;
	}

}
