package come.example.MystcPdfInvoices;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.lowagie.text.DocumentException;

@SpringBootTest
class MystcPdfInvoicesApplicationTests {
	
	private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

	@Test
	void contextLoads() {
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void deviceOrderEmptyForm() {
		String customerName ="";
	    String customerID ="";
	    String invoiceDate ="";
	    String agentName ="";
	    String agentID ="";
	    String deviceName ="";
	    String deviceColor ="";
	    double deviceSize = 0;
	    int deviceMemory = 0;
	    String deviceIMEI ="";
	    int orderNumber = 0;
	    DeviceOrder dooAc = new DeviceOrder(customerName,customerID,invoiceDate,agentName,agentID,deviceName,deviceColor,deviceSize,deviceMemory,deviceIMEI,orderNumber); // actual
	    DeviceOrder dooEx = new DeviceOrder("Ahmed","1234567890","10/10/2020","Ali","1234567890","iPhone","Black",3.5,60,"123456789012345",25589); // expected
	    
	    assertEquals(dooEx,dooAc);
	    
	    // Solution: Added "required" field in form
	
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void deviceOrderFormInputIsString() {
		String customerName ="123"; // element to test here
	    String customerID ="1234567890";
	    String invoiceDate ="10/10/2020";
	    String agentName ="123"; // element to test here
	    String agentID ="1234567890";
	    String deviceName ="123"; // element to test here
	    String deviceColor ="123"; // element to test here
	    double deviceSize = 3.8;
	    int deviceMemory = 60;
	    String deviceIMEI ="123456789012345";
	    int orderNumber = 1248;
	    DeviceOrder dooAc = new DeviceOrder(customerName,customerID,invoiceDate,agentName,agentID,deviceName,deviceColor,deviceSize,deviceMemory,deviceIMEI,orderNumber); // actual
	    DeviceOrder dooEx = new DeviceOrder("Ahmed","1234567890","10/10/2020","Ali","1234567890","iPhone","Black",3.5,60,"123456789012345",25589); // expected
	    
	    // the boolean SHOULD return false
	    
	    // actual
	    Boolean customerNameAc = isNumeric(dooAc.getCustomerName()); // true, it should be false
	    Boolean agentNameAc = isNumeric(dooAc.getAgentName()); // true, it should be false
	    Boolean deviceNameAc = isNumeric(dooAc.getDeviceName()); // true, it should be false
	    Boolean deviceColorAc = isNumeric(dooAc.getDeviceColor()); // true, it should be false
	    
	    // expected
	    Boolean customerNameEx = isNumeric(dooEx.getCustomerName()); // false, which is what we want
	    Boolean agentNameEx = isNumeric(dooEx.getAgentName()); // false, which is what we want
	    Boolean deviceNameEx = isNumeric(dooEx.getDeviceName()); // false, which is what we want
	    Boolean deviceColorEx = isNumeric(dooEx.getDeviceColor()); // false, which is what we want
	    
	    // create arraylist to test all in one assert
	    
	    ArrayList<Boolean> dooExArr = new ArrayList<Boolean>();
	    dooExArr.add(customerNameEx);
	    dooExArr.add(agentNameEx);
	    dooExArr.add(deviceNameEx);
	    dooExArr.add(deviceColorEx);
	    
	    ArrayList<Boolean> dooAcArr = new ArrayList<Boolean>();
	    dooAcArr.add(customerNameAc);
	    dooAcArr.add(agentNameAc);
	    dooAcArr.add(deviceNameAc);
	    dooAcArr.add(deviceColorAc);
	    
	    assertEquals(dooExArr,dooAcArr);
	    
	    // Solution: Added javascript isNaN
	   
		
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void deviceOrderFormInputIsNumber() { // for the double and int values: Added restrictions in the form fields
		
		String customerName ="Ahmed";
	    String customerID ="abc"; // element to test here
	    String invoiceDate ="10/10/2020";
	    String agentName ="Ali";
	    String agentID ="abc"; // element to test here
	    String deviceName ="iPhone";
	    String deviceColor ="Black";
	    double deviceSize = 0;
	    int deviceMemory = 0;
	    String deviceIMEI ="abc"; // element to test here
	    int orderNumber = 0;
	    DeviceOrder dooAc = new DeviceOrder(customerName,customerID,invoiceDate,agentName,agentID,deviceName,deviceColor,deviceSize,deviceMemory,deviceIMEI,orderNumber); // actual
	    DeviceOrder dooEx = new DeviceOrder("Ahmed","1234567890","10/10/2020","Ali","1234567890","iPhone","Black",3.5,60,"123456789012345",25589); // expected
	    
        // the boolean SHOULD return true
	    
	    // actual
	    Boolean customerIDAc = isNumeric(dooAc.getCustomerID()); // false, it should be true
	    Boolean agentIDAc = isNumeric(dooAc.getAgentID()); // false, it should be true
	    Boolean deviceIMEIAc = isNumeric(dooAc.getDeviceIMEI()); // false, it should be true
	   
	    
	    // expected
	    Boolean customerIDEx = isNumeric(dooEx.getCustomerID()); // true, which is what we want
	    Boolean agentIDAcEx = isNumeric(dooEx.getAgentID()); // true, which is what we want
	    Boolean deviceIMEIEx = isNumeric(dooEx.getDeviceIMEI()); // true, which is what we want
	    
	    
	    // create arraylist to test all in one assert
	    
	    ArrayList<Boolean> dooExArr = new ArrayList<Boolean>();
	    dooExArr.add(customerIDEx);
	    dooExArr.add(agentIDAcEx);
	    dooExArr.add(deviceIMEIEx);
	    
	    
	    ArrayList<Boolean> dooAcArr = new ArrayList<Boolean>();
	    dooAcArr.add(customerIDAc);
	    dooAcArr.add(agentIDAc);
	    dooAcArr.add(deviceIMEIAc);
	    
	    assertEquals(dooExArr,dooAcArr);
	    
	    // Solution: Added javascript isNaN in checkInput()
		
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void deviceOrderFormInputIs10Digits() {
		
		String customerName ="Ahmed";
	    String customerID ="123456789012"; // element to test here
	    String invoiceDate ="10/10/2020";
	    String agentName ="Ali";
	    String agentID ="123456789012"; // element to test here
	    String deviceName ="iPhone";
	    String deviceColor ="Black";
	    double deviceSize = 0;
	    int deviceMemory = 0;
	    String deviceIMEI ="123456789012345";
	    int orderNumber = 0;
	    DeviceOrder dooAc = new DeviceOrder(customerName,customerID,invoiceDate,agentName,agentID,deviceName,deviceColor,deviceSize,deviceMemory,deviceIMEI,orderNumber); // actual
	    DeviceOrder dooEx = new DeviceOrder("Ahmed","1234567890","10/10/2020","Ali","1234567890","iPhone","Black",3.5,60,"123456789012345",25589); // expected
	    
        // the boolean SHOULD return true, since the ID national number is of 10 digits
	    
	    // actual
	    Boolean customerIDAc = is10Digits( Long.parseLong(dooAc.getCustomerID()) );
	    Boolean agentIDAc = is10Digits( Long.parseLong(dooAc.getAgentID()) );
	    
	    // expected
	    Boolean customerIDEx = is10Digits( Long.parseLong(dooEx.getCustomerID()) );
	    Boolean agentIDEx = is10Digits( Long.parseLong(dooEx.getAgentID()) );
	    
	    
	    // create arraylist to test all in one assert
	    ArrayList<Boolean> dooExArr = new ArrayList<Boolean>();
	    dooExArr.add(customerIDEx);
	    dooExArr.add(agentIDEx);
	    
	    
	    ArrayList<Boolean> dooAcArr = new ArrayList<Boolean>();
	    dooAcArr.add(customerIDAc);
	    dooAcArr.add(agentIDAc);
	    
	    
	    assertEquals(dooExArr,dooAcArr);
	    
	    // Solution: Added restrictions in form fields
		
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void deviceOrderFormInputIs15Digits() {
		
		String customerName ="Ahmed";
	    String customerID ="123456789012";
	    String invoiceDate ="10/10/2020";
	    String agentName ="Ali";
	    String agentID ="123456789012";
	    String deviceName ="iPhone";
	    String deviceColor ="Black";
	    double deviceSize = 0;
	    int deviceMemory = 0;
	    String deviceIMEI ="123456789012345666"; // element to test here
	    int orderNumber = 0;
	    DeviceOrder dooAc = new DeviceOrder(customerName,customerID,invoiceDate,agentName,agentID,deviceName,deviceColor,deviceSize,deviceMemory,deviceIMEI,orderNumber); // actual
	    DeviceOrder dooEx = new DeviceOrder("Ahmed","1234567890","10/10/2020","Ali","1234567890","iPhone","Black",3.5,60,"123456789012345",25589); // expected
	    
        // the boolean SHOULD return true, since the device IMEI number is of 15 digits
	    
	    // actual
	    Boolean deviceIMEIAc = is15Digits( Long.parseLong(dooAc.getDeviceIMEI()) );
	   
	    // expected
	    Boolean deviceIMEIEx = is15Digits( Long.parseLong(dooEx.getDeviceIMEI()) );
	    
	    assertEquals(deviceIMEIEx,deviceIMEIAc);
	    
	    // Solution: Added restrictions in form fields
		
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void deviceOrderFormInputIsValidDate() {
		
		String customerName ="Ahmed";
	    String customerID ="123456789012";
	    String invoiceDate ="10102020"; // element to test here
	    String agentName ="Ali";
	    String agentID ="123456789012";
	    String deviceName ="iPhone";
	    String deviceColor ="Black";
	    double deviceSize = 0;
	    int deviceMemory = 0;
	    String deviceIMEI ="123456789012345";
	    int orderNumber = 0;
	    DeviceOrder dooAc = new DeviceOrder(customerName,customerID,invoiceDate,agentName,agentID,deviceName,deviceColor,deviceSize,deviceMemory,deviceIMEI,orderNumber); // actual
	    DeviceOrder dooEx = new DeviceOrder("Ahmed","1234567890","10/10/2020","Ali","1234567890","iPhone","Black",3.5,60,"123456789012345",25589); // expected
	    
        // the boolean SHOULD return true, since date format is DD/MM/YYYY
	    
	    // actual
	    Boolean invoiceDateAc = isValidDate(dooAc.getInvoiceDate());
	   
	    // expected
	    Boolean invoiceDateEx = isValidDate(dooEx.getInvoiceDate());
	    
	    assertEquals(invoiceDateEx,invoiceDateAc);
	    
	    // Solution: Added format restrictions in form fields
		
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false; 
	    }
	    return pattern.matcher(strNum).matches();
	}
	
	
	public Boolean is10Digits(long id) {
		int length = 0;
		long temp = 1;
		while (temp <= id) {
		    length++;
		    temp *= 10;
		}
		
		if (length == 10) { return true; }
		else { return false; }
	}
	
	public Boolean is15Digits(long imei) {
		int length = 0;
		long temp = 1;
		while (temp <= imei) {
		    length++;
		    temp *= 10;
		}
		
		if (length == 15) { return true; }
		else { return false; }
	}
	
	public Boolean isValidDate(String date) { 
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(date.trim());
		} catch (ParseException pe) {
			return false;
		}
		return true;
	}
	

}
