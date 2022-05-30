package zkartshopping;

import java.io.Serializable;
import java.util.Date;

public class ZKartInfo implements Serializable {
private String category;
private String brand;
private String model;
private double price;
private int stock;
private int invoiceNumber;
private long date;

private int noOfOrderedItems;


public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
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
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}

public int getInvoiceNumber() {
	return invoiceNumber;
}
public void setInvoiceNumber(int invoiceNumber) {
	this.invoiceNumber = invoiceNumber;
}

public long getDate() {
	return date;
}
public void setDate(long date) {
	this.date = date;
}

public int getNoOfOrderedItems() {
	return noOfOrderedItems;
}
public void setNoOfOrderedItems(int noOfOrderedItems) {
	this.noOfOrderedItems = noOfOrderedItems;
}
@Override
public String toString() {
	Date d=new Date(date);
	return "[category=" + category + ", brand=" + brand + ", model=" + model + ", price=" + price +",Stock="+stock+"]";
}

}
