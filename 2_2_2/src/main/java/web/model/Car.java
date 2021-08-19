package web.model;

public class Car {

	private String brand;
	private String model;
	private short yearOfIssue;

	public Car(String brand, String model, short yearOfIssue) {
		this.brand = brand;
		this.model = model;
		this.yearOfIssue = yearOfIssue;
	}


	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public short getYearOfIssue() {
		return yearOfIssue;
	}

	public void setYearOfIssue(short yearOfIssue) {
		this.yearOfIssue = yearOfIssue;
	}
}
