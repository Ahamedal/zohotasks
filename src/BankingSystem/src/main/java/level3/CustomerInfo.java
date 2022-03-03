package level3;
import java.io.*;
public class CustomerInfo implements Serializable{
private int customerId;
private String name;
private String address;
private long mobileNo;
private boolean status=true;

public boolean isStatus() {
	return status;
}
public void setStatus(boolean status) {
	this.status = status;
}

public int getCustomerId() {
	return customerId;
}
public void setCustomerId(int customerId) {
	this.customerId = customerId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public long getMobileNo() {
	return mobileNo;
}
public void setMobileNo(long mobileNo) {
	this.mobileNo = mobileNo;
}
@Override
public String toString() {
	return "[customerID="+customerId+",name=" + name + ", address=" + address + ", mobileNo=" + mobileNo +",status="+status+ "]";
}



}
