package carshowroommanagement;

public class Car {
 
	private int carNumber;
	private String carModel;
	private String branch;
	private String City;
	
	public int getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(int carNumber) {
		this.carNumber = carNumber;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	
	@Override
	public String toString() {
		return "Car [carNumber=" + carNumber + ", carModel=" + carModel + ", branch=" + branch + ", City=" + City
				+  "]";
	}
	
	
}
