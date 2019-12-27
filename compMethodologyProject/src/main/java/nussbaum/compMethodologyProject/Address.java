package nussbaum.compMethodologyProject;

import java.util.Formatter;

public class Address 
{
private String name;
private String street;
private String city;
private USState state;
private String zipCode;

public Address(String name, String street, String city, String state, String zip)  {

this.name=name;
this.street = street;
this.city = city;
USState st = USState.valueOf(state);
this.state=st;
this.zipCode = zip;

}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Address(Address a) throws MissingDataException {
this(a.getName(),a.getStreet(), a.getCity(), a.getState(), a.getZipCode());
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
Address other = (Address) obj;
if (state != other.state)
return false;
if (city == null) {
if (other.city != null)
return false;
} else if (!city.equals(other.city))
return false;
if (street == null) {
if (other.street != null)
return false;
} else if (!street.equals(other.street))
return false;
if (zipCode == null) {
if (other.zipCode != null)
return false;
} else if (!zipCode.equals(other.zipCode))
return false;
return true;
}

public int compareTo(Address a) {
int i = this.street.compareTo(a.street);

if (i == 0) {
return this.zipCode.compareTo(a.zipCode);
}
return i;
}

public Formatter format() {
Formatter formatter = new Formatter();
    formatter.format(" Name: ", name + " Street: " + street + " City: " + city + " State: " + state.toString()  + " ZipCode: " + zipCode );
    return formatter;

}



}
