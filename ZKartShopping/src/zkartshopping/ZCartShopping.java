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
 static Map<String,List<String>> changePassword=new HashMap<>();
 static List<ZKartInfo> zCartInfo=new ArrayList<>();
 static Map<String,Map<Integer,List<ZKartInfo>>> orderHistory=new HashMap<>();
 static int invoiceNumber=1000;
 static int discountNo=100;
 
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

 public List<ZKartInfo> getLessNoOfStack(){
	 List<ZKartInfo> lis=new ArrayList<>();
	 for(int i=0;i<zCartInfo.size();i++) {
		 if(zCartInfo.get(i).getStock()<10) {
			 lis.add(zCartInfo.get(i));
		 }
	 }
	 return lis;
 }
 public void shopping(List<ZKartInfo> order,List<Integer> noOfNeeds) 
 {
	 for(int i=0;i<order.size();i++) 
	 {
		 if(order.get(i).getStock()>=noOfNeeds.get(i)) 
		 {
			 order.get(i).setStock(order.get(i).getStock()-noOfNeeds.get(i));
			 order.get(i).setDate(System.currentTimeMillis());
			 order.get(i).setInvoiceNumber(invoiceNumber);
			 order.get(i).setNoOfOrderedItems(noOfNeeds.get(i));
		 }
		 else if(order.get(i).getStock()>0)
		 {
			 order.get(i).setNoOfOrderedItems(order.get(i).getStock());
			 noOfNeeds.add(i,order.get(i).getStock());
			 order.get(i).setDate(System.currentTimeMillis());
			 order.get(i).setStock(0); 
			
		 }
		 else 
		 {
			 order.remove(i);
		 }
	 }
 }
 public void reOrder(ZKartInfo zKart,int reOrder) {
	 zKart.setStock(zKart.getStock()+reOrder);
	 file.infoToFileForZKart(zCartInfo);

 }
 public String changeEncrypt(String password) {
	 String lowerCase="bcdefghijklmnopqrstuvwxyza";
	 String alpha="BCDEFGHIJKLMNOPQRSTUVWXYZA";
	 String encrypt="";
	 int temp=0;
	 for(int i=0;i<password.length();i++) 
	 {
		 if(Character.isDigit(password.charAt(i))) 
		 {
			 temp=Integer.parseInt(String.valueOf(password.charAt(i)))+1;
			 if(temp==10) 
			 {
				 encrypt=encrypt+"0";
			 }
			 else 
			 {
				 encrypt=encrypt+temp;
			 }
		 }
		 else if(password.charAt(i)>='A'&&password.charAt(i)<='Z')
		 {
		 encrypt=encrypt+alpha.charAt(password.charAt(i)-'A');
		 }
		 else 
		 {
		 encrypt=encrypt+lowerCase.charAt(password.charAt(i)-'a');
		 }
	 }
	 return encrypt;
 }
 public boolean isCheckPass(String pass,String emailId) {
	 int count1=0;
	 int count2=0;
	 int count3=0;
	 for(int i=0;i<pass.length();i++) 
	 {
		 if(pass.charAt(i)>='A'&&pass.charAt(i)<='Z') {
			 count1++;
		 }
		 else if(pass.charAt(i)>='a'&&pass.charAt(i)<='z') {
			 count2++;
		 }
		 else if(Character.isDigit(pass.charAt(i))) {
			 count3++;
		 }
	 }
	 if(count1>=2&&count2>=2&&count3>=2) {
		
		 return true;
	 }
	 return false;
 }
 public void addPassword(String emailId,String password) {
	 List<String> lis=changePassword.get(emailId);
	 if(lis==null) {
		 lis=new ArrayList<>();
		 changePassword.put(emailId, lis);
		 
	 }
	 if(lis.size()>2) {
		 lis.remove(0);
		 
	 }
	 lis.add(password);
	 
 }
 public boolean checkPassword(String pass,String reType) {
	 if(pass.equals(reType)) {
		 return true;
	 }
	 return false;
 }
 public boolean loginCheck(String userName,String passwor) {
	
	 if(cusInfo.containsKey(userName)) {
		 CustomerInfo cus=cusInfo.get(userName);
		 String pass=cus.getEncryptedPwd();
		 String pass1=changeEncrypt(passwor);
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
	Map<Integer, List<ZKartInfo>> order1=orderHistory.get(emailId);
	 String orderHistory="";
	 
	for(Integer j:order1.keySet()) {
		List<ZKartInfo> order=order1.get(j);
		double total=0;
		 orderHistory+="Invoice Number "+order.get(0).getInvoiceNumber()+"\n";
		 orderHistory+="Date "+convertDate(order.get(0).getDate())+"\n";
		 orderHistory+="Category    Brand    Model    Price NumberOfOrder \n";
	 for(int i=0;i<order.size();i++) {
		total=total+order.get(i).getPrice()*order.get(i).getNoOfOrderedItems();
       orderHistory+=order.get(i).getCategory()+"  "+order.get(i).getBrand()+" "+order.get(i).getModel()+" "+order.get(i).getPrice()+" "+order.get(i).getNoOfOrderedItems()+"\n";
		
	   }
	orderHistory+="Total "+total;
	}
	
	 return orderHistory;
 }
 public void addOrderHistory(String emailId,List<ZKartInfo> zCart,int invoice) {
	 Map<Integer,List<ZKartInfo>> map=orderHistory.get(emailId);
	 if(map==null) {
		 map=new HashMap<>();
		 orderHistory.put(emailId, map);
	 }
	 map.put(invoice, zCart);
	// orderHistory.put(emailId, zCart);
	 file.infoToFileForZKart(zCartInfo);
	 
 }
 public String generateDiscountNo() {
	 ++discountNo;
	 return "abc"+discountNo;
 }
 public int generateUniqueInvoice() {
	 return ++invoiceNumber;
 }
 public void addPurchase(String emailId) {
	 CustomerInfo customerInfo=cusInfo.get(emailId);
	 customerInfo.setPurchaseNo(customerInfo.getPurchaseNo()+1);
 }
 public boolean adminChangePassword(String password,String emailId) {
	 List<String> lis=changePassword.get(emailId);
	 if(lis.contains(password)) {
		 return false;
	 }
	 addPassword(emailId,password);
	 return true;
 }
 public ZKartInfo highestStock() {
	 ZKartInfo zcart=null;
	 int max=0;
	 for(int i=0;i<zCartInfo.size();i++) {
		if(zCartInfo.get(i).getStock()>max) {
			max=zCartInfo.get(i).getStock();
			zcart=zCartInfo.get(i);
		}
	 }
	return zcart;
 }
 public boolean changePassword(String password,String emailId) {
	 List<String> lis=changePassword.get(emailId);
	 CustomerInfo customerInfo=cusInfo.get(emailId);
	 if(lis.contains(password)) {
		 return false;
	 }
	 addPassword(emailId,password);
	 customerInfo.setEncryptedPwd(password);
	 addCustomer(customerInfo);
	 return true;
 }
 public int getPurchases(String emailId) {
	 return cusInfo.get(emailId).getPurchaseNo();
 }
 public int getNextPurchases(String emailId) {
	 return cusInfo.get(emailId).getNextTransaction();
 }
 public boolean checkCorrectCode(String email,String code) {
	 if(cusInfo.get(email).getDiscountNo().equals(code)) {
		 return true;
	 }
	 return false;
 }
 public int randomGenerator() {
	 int min=20;
	 int max=30;
	 int rand=(int) (Math.random()*(max-min+1))+min;
	 return rand;
 }
 public void setNextTransaction(String emailId,String dis) {
	 cusInfo.get(emailId).setNextTransaction(0);
	 cusInfo.get(emailId).setDiscountNo(dis);
 }
 public boolean adminLoginCheck(String emailId,String password) {
	
	 if(changePassword.containsKey(emailId)) {
		List<String> lis=changePassword.get(emailId) ;
		String pas=lis.get(lis.size()-1);
		if(password.equals(pas)) {
			return true;
			
		}
	 }
	 return false;
 }
 
}
