package nussbaum.compMethodologyProject;

public class Customer 
{
private String firstName;
private String lastName;
private String phoneNumber;
private Address address;

public Customer(String fName, String lName, String phoneNum, Address address)
{
	this.firstName = fName;
	this.lastName=lName;
	this.phoneNumber =phoneNum.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
	this.address=address;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getPhoneNumber() {
	return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}

public Address getAddress() {
	return address;
}

public void setAddress(Address address) {
	this.address = address;
}

@Override
public String toString() {
	return "Name: " + firstName + lastName + " Phone Number:" + phoneNumber + " Address: " + address;
}




}

