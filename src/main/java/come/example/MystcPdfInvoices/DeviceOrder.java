package come.example.MystcPdfInvoices;

import java.time.LocalDate;

public class DeviceOrder {
	
	private String customerName;
    private String customerID;
    private String invoiceDate; // In next version: validate if it maps to actual date in calendar
    private String agentName;
    private String agentID;
    private String deviceName;
    private String deviceColor;
    private double deviceSize; //inch
    private int deviceMemory; //giga
    private String deviceIMEI;
    private int orderNumber;
    
    
    public DeviceOrder(String customerName, String customerID, String invoiceDate, String agentName, String agentID,
			String deviceName, String deviceColor, double deviceSize, int deviceMemory, String deviceIMEI,
			int orderNumber) {
		super();
		this.customerName = customerName;
		this.customerID = customerID;
		this.invoiceDate = invoiceDate;
		this.agentName = agentName;
		this.agentID = agentID;
		this.deviceName = deviceName;
		this.deviceColor = deviceColor;
		this.deviceSize = deviceSize;
		this.deviceMemory = deviceMemory;
		this.deviceIMEI = deviceIMEI;
		this.orderNumber = orderNumber;
		
	}
    
   
	@Override
	public String toString() {
		return "DeviceOrder [customerName=" + customerName + ", customerID=" + customerID + ", invoiceDate="
				+ invoiceDate + ", agentName=" + agentName + ", agentID=" + agentID + ", deviceName=" + deviceName
				+ ", deviceColor=" + deviceColor + ", deviceSize=" + deviceSize + ", deviceMemory=" + deviceMemory
				+ ", deviceIMEI=" + deviceIMEI + ", orderNumber=" + orderNumber + "]";
	}


	public DeviceOrder() {
		super();
	}


	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public String getAgentID() {
		return agentID;
	}
	public void setAgentID(String agentID) {
		this.agentID = agentID;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getDeviceColor() {
		return deviceColor;
	}
	public void setDeviceColor(String deviceColor) {
		this.deviceColor = deviceColor;
	}
	public double getDeviceSize() {
		return deviceSize;
	}
	public void setDeviceSize(double deviceSize) {
		this.deviceSize = deviceSize;
	}
	public int getDeviceMemory() {
		return deviceMemory;
	}
	public void setDeviceMemory(int deviceMemory) {
		this.deviceMemory = deviceMemory;
	}
	public String getDeviceIMEI() {
		return deviceIMEI;
	}
	public void setDeviceIMEI(String deviceIMEI) {
		this.deviceIMEI = deviceIMEI;
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	

}
