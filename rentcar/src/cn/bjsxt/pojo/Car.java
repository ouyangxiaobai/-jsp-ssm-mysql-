package cn.bjsxt.pojo;

public class Car {
	private int carid;
	private String number;
	private String type;
	private String brand;
	private String color;
	private double price;
	private double rentprice;
	private double deposit;
	private String isrenting;
	private String img;
	private String description;
	public Car(int carid, String number, String type, String brand, String color, double price, double rentprice,
			double deposit, String isrenting, String img, String description) {
		super();
		this.carid = carid;
		this.number = number;
		this.type = type;
		this.brand = brand;
		this.color = color;
		this.price = price;
		this.rentprice = rentprice;
		this.deposit = deposit;
		this.isrenting = isrenting;
		this.img = img;
		this.description = description;
	}
	public Car(String number, String type, String brand, String color, double price, double rentprice,
			double deposit, String isrenting, String img, String description) {
		super();
		this.carid = carid;
		this.number = number;
		this.type = type;
		this.brand = brand;
		this.color = color;
		this.price = price;
		this.rentprice = rentprice;
		this.deposit = deposit;
		this.isrenting = isrenting;
		this.img = img;
		this.description = description;
	}
	public int getCarid() {
		return carid;
	}
	public void setCarid(int carid) {
		this.carid = carid;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getRentprice() {
		return rentprice;
	}
	public void setRentprice(double rentprice) {
		this.rentprice = rentprice;
	}
	public double getDeposit() {
		return deposit;
	}
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	public String getIsrenting() {
		return isrenting;
	}
	public void setIsrenting(String isrenting) {
		this.isrenting = isrenting;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Car [carid=" + carid + ", number=" + number + ", type=" + type + ", brand=" + brand + ", color=" + color
				+ ", price=" + price + ", rentprice=" + rentprice + ", deposit=" + deposit + ", isrenting=" + isrenting
				+ ", img=" + img + ", description=" + description + "]";
	}
	
	
}
