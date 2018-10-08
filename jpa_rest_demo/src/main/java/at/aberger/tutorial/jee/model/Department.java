package at.aberger.tutorial.jee.model;

/** A Department.
 */
public class Department {	
	private short number;
	private String name;
	private String location;
	
	public short getNumber() {
		return number;
	}
	public void setNumber(short number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
