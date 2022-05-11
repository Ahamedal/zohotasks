package zkartshopping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZCartShopping {
	FileLayer file=new FileLayer();
 static Map<String,CustomerInfo> cusInfo=new HashMap<>();
 static List<ZKartInfo> zCartInfo=new ArrayList<>();
 static Map<String,List<ZKartInfo>> orderHistory=new HashMap<>();
 
 public void addCustomer(CustomerInfo customerInfo) {
	 String passWord=customerInfo.getEncryptedPwd();
	 customerInfo.setEncryptedPwd(changeEncrypt(passWord));
	  cusInfo.put(customerInfo.getEmailId(), customerInfo);
	  file.infoToFileForCus(cusInfo);
 }
 public void addZKartDetails(ZKartInfo zKartInfo) {
	 zCartInfo.add(zKartInfo);
	 file.infoToFileForZKart(zCartInfo);
 }
 public Map<String,CustomerInfo> getCusInfo(){
	 
	 cusInfo=file.read();
	 return cusInfo;
 }
 public List<ZKartInfo> getzKart(){
	 zCartInfo=file.readZkart();
	 return zCartInfo;
 }
 public boolean checkExistingEmailId(String emailId) {
	 if(cusInfo.containsKey(emailId)) {
		 return true;
	 }
	 return false;
 }
 public String changeEncrypt(String password) {
	 String lowerCase="bcdefghijklmnopqrstuvwxyza";
	 String alpha="BCDEFGHIJKLMNOPQRSTUVWXYZA";
	 String encrypt="";
	 int temp=0;
	 for(int i=0;i<password.length();i++) {
		 if(Character.isDigit(password.charAt(i))) {
			 temp=Integer.parseInt(String.valueOf(password.charAt(i)))+1;
			 if(temp==10) {
				 encrypt=encrypt+"0";
			 }
			 else {
				 encrypt=encrypt+temp;
			 }
		 }
		 else if(password.charAt(i)>='A'&&password.charAt(i)<='Z') {
		 encrypt=encrypt+alpha.charAt(password.charAt(i)-'A');
		 }
		 else {
		 encrypt=encrypt+lowerCase.charAt(password.charAt(i)-'a');
		 }
	 }
	 return encrypt;
 }

 public boolean checkPassword(String pass,String reType) {
	 if(pass.equals(reType)) {
		 return true;
	 }
	 return false;
 }
 public boolean loginCheck(String userName,String password) {
	 if(cusInfo.containsKey(userName)) {
		 CustomerInfo cus=cusInfo.get(userName);
		 String pass=cus.getEncryptedPwd();
		 String pass1=changeEncrypt(password);
		 if(pass.equals(pass1)) {
			 return true;
		 }
	 }
	 return false;
	 
 }
 public String convertDate(long time) {
	 SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
	 Date d=new Date(time);
	 return format.format(d);
 }
 public String getOrderHistory(String emailId){
	 List<ZKartInfo> order=orderHistory.get(emailId);
	 String orderHistory="";
	 boolean flag=true;
	 for(int i=0;i<order.size();i++) {
		 if(flag) {
		 orderHistory+="Invoice Number "+order.get(i).getInvoiceNumber()+"\n";
		 orderHistory+="Date "+convertDate(order.get(i).getDate())+"\n";
		 orderHistory+="Category    Brand    Model    Price\n";
		 
		 }
		 orderHistory+=order.get(i).getCategory()+"         "+order.get(i).getBrand()+"        "+order.get(i).getModel()+"        "+order.get(i).getPrice()+"\n";
		flag=false;
		 
	 }
	 return orderHistory;
 }
 public void addOrderHistory(String emailId,List<ZKartInfo> zCart) {
	 orderHistory.put(emailId, zCart);
	 file.infoToFileForZKart(zCartInfo);
	 
 }
 public int generateUniqueInvoice() {
	 return (int) (Math.random()*1000)+1;
 }

}
