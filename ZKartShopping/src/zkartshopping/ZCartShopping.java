package zkartshopping;

import java.util.ArrayList;
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
		 encrypt=encrypt+alpha.charAt(password.charAt(i)-'A');
	 }
	 return encrypt;
 }
// public String encryptToPlain(String pWord) {
//	 String alpha="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//	 String encrypt="";
//	 for(int i=0;i<pWord.length();i++) {
//		 encrypt=encrypt+alpha.charAt((pWord.charAt(i)-'A')-1);
//	 }
//	 return encrypt;
// }
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
 public List<ZKartInfo> getOrderHistory(String emailId){
	 return orderHistory.get(emailId);
 }
 public void addOrderHistory(String emailId,List<ZKartInfo> zCart) {
	 orderHistory.put(emailId, zCart);
 }
 public int generateUniqueInvoice() {
	 return (int) Math.random();
 }

}
