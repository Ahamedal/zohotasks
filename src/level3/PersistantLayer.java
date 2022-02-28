package level3;

import java.util.*;

import com.logiclayer.*;

public interface PersistantLayer {
	
	public int addMap(CustomerInfo value)throws CustomException;
	public CustomerInfo getMap(int key)throws CustomException;
	public int addMultipleAccount(AccountInfo value) throws CustomException;
	public AccountInfo getForAccountId(int customerId,int accountId)throws CustomException;
	public void depositMoney(int cusID,int accID,long deposit)throws CustomException;
	public void withDrawMoney(int cusID,int accID,long withDraw)throws CustomException;
	public void setCustomerStatus(int cusId,int status)throws CustomException;
	public void setAccountStatus(int cusId,int accId,int status)throws CustomException;
	public Map<Integer,CustomerInfo> fileToMap()throws CustomException;
	public Map<Integer,Map<Integer,AccountInfo>> fileToMap1()throws CustomException;
}
