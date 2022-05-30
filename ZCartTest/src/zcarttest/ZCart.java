package zcarttest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZCart {

	Map<String,Customer> customerInfo=new HashMap<>();
	Map<Integer,Product> productInfo=new HashMap<>();
	Map<String,List<String>> changePassword=new HashMap<>();
	
	int productId=0;
	public int generateProductId() {
		return ++productId;
	}
	public void addCustomer(Customer cus) {
		customerInfo.put(cus.getEmailId(), cus);
	}
	public void addZKart(Product pro) {
		productInfo.put(pro.getProductId(), pro);
	}
	public boolean adminLoginCheck(String emailId,String pass) {
		List<String> lis=changePassword.get(emailId);
		if(pass.equals(lis.get(lis.size()-1))) {
			return true;
		}
		return false;
	}
	public boolean loginCheck(String emailId,String pass) {
		if(!customerInfo.containsKey(emailId)) {
			return false;
		}
		String encrypt=encryptPass(pass);
		Customer cus=customerInfo.get(emailId);
		if(!encrypt.equals(cus.getEncryptedPassword())) {
			return false;
		}
		return true;
	}
	public Map<Integer,Product> getZKart(){
		return productInfo;
	}
	public Product getProduct(int productId) {
		return productInfo.get(productId);
	}
	public boolean checkPasswordCritteria(String pass) {
		
		if(pass==null||pass.length()<=5) {
			return false;
		}
		int count1=0;
		int count2=0;
		int count3=0;
		for(int i=0;i<pass.length();i++) {
			if(pass.charAt(i)>='A'&&pass.charAt(i)<='Z') {
				count1++;
			}
			else if(pass.charAt(i)>='a'&&pass.charAt(i)<='z') {
				count2++;
				
			}
			else if(Character.isDigit(pass.charAt(i))){
				count3++;
			}
		}
	if(count1>1&&count2>1&&count3>1) {
		return true;
	}
		return false;
	}
	public boolean checkPassword(String pas1,String pas2) {
		if(pas1.equals(pas2)) {
			return true;
		}
		return false;
	}
	public boolean checkLast3Password(String emailId,String pass) {
		List<String> lis=changePassword.get(emailId);
		if(lis.contains(pass)) {
			return true;
		}
		return false;
	}
	public void addPassword(String emailId,String pass) {
		List<String> passwords=changePassword.get(emailId);
		if(passwords==null) {
			passwords=new ArrayList<>();
			changePassword.put(emailId, passwords);
		}
		if(passwords.size()>2) {
			passwords.remove(0);
		}
		passwords.add(pass);
	}
	public String encryptPass(String pass) {
		String ans="";
		for(int i=0;i<pass.length();i++) {
			if(pass.charAt(i)=='z') {
				ans+="a";
			}
			else if(pass.charAt(i)=='Z') {
				ans+="A";
			}
			else if(pass.charAt(i)=='9') {
				ans+="0";
			}
			else {
				ans+=(char)(pass.charAt(i)+1);
			}
		}
		return ans;
	}
	public boolean existCustomer(String emailId) {
		if(customerInfo.containsKey(emailId)) {
			return true;
		}
		return false;
	}
	public void checkOutCard(List<Integer> produts,List<Integer> noOfOrderedItems) {
		for(int i=0;i<produts.size();i++) {
			Product produt=productInfo.get(produts.get(i));
			if(produt.getStockOfProduct()>=noOfOrderedItems.get(i)) {
				produt.setStockOfProduct(produt.getStockOfProduct()-noOfOrderedItems.get(i));
				
			}
			else if(produt.getStockOfProduct()>0) {
				
			    noOfOrderedItems.add(i,produt.getStockOfProduct() );
			    produt.setStockOfProduct(0);
			}
			else {
				produts.remove(i);
				noOfOrderedItems.remove(i);
			}
		}
		
	}
	private int invoiceNumber=1000;
	public void addOrderHistory(String emailId,List<Integer> produts,List<Integer> noOfOrderedItem) {
		Customer cus=customerInfo.get(emailId);
		Map<Integer,OrderHistory> orders=cus.getOrders();
		OrderHistory obj=new OrderHistory();
		obj.setInvoiceNumber(invoiceNumber);
		obj.setDate(System.currentTimeMillis());
		Map<Integer,Integer> map=obj.getSellProduct();
		for(int i=0;i<produts.size();i++) {
			map.put(produts.get(i),noOfOrderedItem.get(i));
		}
		orders.put(obj.getInvoiceNumber(), obj);
	}

	public int generateInvoice() {
		return ++invoiceNumber;
	}
	public List<Product> getLessNoOfStock(){
		List<Product> lessStock=new ArrayList<>();
		for(Integer key:productInfo.keySet()) {
			Product pro=productInfo.get(key);
			if(pro.getStockOfProduct()<10) {
				lessStock.add(pro);
			}
		}
		return lessStock;
	}
	public void reOrder(List<Product> lis,int reOr) {
		for(int i=0;i<lis.size();i++) {
			Product pro=lis.get(i);
			pro.setStockOfProduct(reOr);
		}
	}
	public String convertDate(long tim) {
		SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");
		Date dateObj=new Date(tim);
		return formatter.format(dateObj);
	}
	
	public String getOrderHistory(String emailId) {
		Customer cus=customerInfo.get(emailId);
		String ans="";
		Map<Integer,OrderHistory> map=cus.getOrders();
		for(Integer key:map.keySet()) {
			OrderHistory orderHistory=map.get(key);
			ans+="Invoice Number-"+orderHistory.getInvoiceNumber()+"\n";
			ans+="Date "+convertDate(orderHistory.getDate())+"\n";
			ans+="Category  Brand  Model  Price  Noofordereditems\n";
			int total=0;
			Map<Integer,Integer> map1=orderHistory.getSellProduct();
			for(Integer key3:map1.keySet()) {
                 Product pro=productInfo.get(key3);
                 ans+=pro.getCategoryName()+" "+pro.getBrandName()+" "+pro.getModelName()+" "+pro.getPriceOfProduct()+" "+map1.get(key3)+"\n";
                 total+=pro.getPriceOfProduct()*map1.get(key3);
			}
			ans+="total "+total;
		}
		return ans;
	}
	public String getAlphaNumbericCode() {
		String alpha="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String number="0123456789";
		String ans="";
		for(int i=0;i<3;i++) {
			int ind=(int) (alpha.length()*Math.random());
			ans+=alpha.charAt(ind);
		}
		for(int i=0;i<3;i++) {
			int ind=(int) (number.length()*Math.random());
			ans+=number.charAt(ind);
		}
		return ans;
	}
	public int randomGenerated() {
		int min=20;
	    int max=30;
	    int rang=max-min+1;
	    int random=(int) (Math.random()*rang)+min;
	    return random;
	}
	public void addCoupen(String emailId,String coupenCode) {
		Customer cus=customerInfo.get(emailId);
		Map<String,Coupen> map=cus.getCoupen();
		Coupen coupen=map.get(coupenCode);
		if(coupen==null) {
			coupen=new Coupen();
			map.put(coupenCode,coupen);
		}
		coupen.setCoupenCode(coupenCode);
		coupen.setNextTransaction(0);
		
	}
	
	public boolean validCoupenCode(String coupenCode,String emailId) {
		Customer cus=customerInfo.get(emailId);
		Map<String,Coupen> map=cus.getCoupen();
		Coupen coupen=map.get(coupenCode);
		if(!map.containsKey(coupenCode)||!coupen.isValid()){
			return false;
		}
		coupen.setNextTransaction(coupen.getNextTransaction()+1);
		if(coupen.getNextTransaction()>2) {
			coupen.setValid(false);
		}
		return true;
		
	}
	public boolean addPurchase(String emailId) {
		Customer cus=customerInfo.get(emailId);
		cus.setPurchaseNo(cus.getPurchaseNo()+1);
		if(cus.getPurchaseNo()==3) {
			return true;
		}
		return false;
		
	}
	public List<Product> getHighestStock() {
		int max=Integer.MIN_VALUE;
		List<Product> lis=new ArrayList<>();
		for(Integer key:productInfo.keySet()) {
			Product pro=productInfo.get(key);
			if(max<pro.getStockOfProduct()) {
				max=pro.getStockOfProduct();
				lis.clear();
				lis.add(pro);
				
			}
			else if(max==pro.getStockOfProduct()) {
				lis.add(pro);
			}
			
		}
		return lis;
	}
}
