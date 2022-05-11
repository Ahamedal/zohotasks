package zkartshopping;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileLayer {
 
	String cus="zusers_db.txt";
	String zKart="z-cart_db.txt";
	File cusFile=new File(cus);
	File zKartFile=new File(zKart);
	public void infoToFileForCus(Map<String,CustomerInfo> cusInfo)  {
		try(FileOutputStream writer=new FileOutputStream(cusFile,false);ObjectOutputStream objWrite= new ObjectOutputStream(writer)){
			objWrite.writeObject(cusInfo);
		}
		
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public Map<String,CustomerInfo> read(){
		Map<String,CustomerInfo> cusDetails=new HashMap<>();
		try(FileInputStream reader=new FileInputStream(cusFile);ObjectInputStream objRead= new ObjectInputStream(reader)){
			cusDetails=(Map<String, CustomerInfo>) objRead.readObject();
		}
		
		catch(IOException|ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return cusDetails;
	}
	public void infoToFileForZKart(List<ZKartInfo> zKartInfo)  {
		try(FileOutputStream writer=new FileOutputStream(zKartFile);ObjectOutputStream objWrite= new ObjectOutputStream(writer)){
			objWrite.writeObject(zKartInfo);
			objWrite.writeObject(ZCartShopping.orderHistory);
		}
		
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public List<ZKartInfo> readZkart(){
		List<ZKartInfo> zDetails=new ArrayList<>();
		try(FileInputStream reader=new FileInputStream(zKartFile);ObjectInputStream objRead= new ObjectInputStream(reader)){
			zDetails=(List<ZKartInfo>) objRead.readObject();
			ZCartShopping.orderHistory=(Map<String, List<ZKartInfo>>) objRead.readObject();
		}
		
		catch(IOException|ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return zDetails;
	}
}
