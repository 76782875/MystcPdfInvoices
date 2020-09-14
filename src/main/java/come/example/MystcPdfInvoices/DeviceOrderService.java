package come.example.MystcPdfInvoices;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;


@Service
public class DeviceOrderService {
	
	@Autowired
	private TemplateEngine templateEngine;
	
	public void createPdf(DeviceOrder doo) throws DocumentException, IOException {
		
		Context context = new Context();
		
		context.setVariable("CustomerName", doo.getCustomerName());
		context.setVariable("CustomerID", doo.getCustomerID());
		context.setVariable("InvoiceDate", doo.getInvoiceDate());
		context.setVariable("AgentName", doo.getAgentName());
		context.setVariable("AgentID", doo.getAgentID());
		context.setVariable("DeviceName", doo.getDeviceName());
		context.setVariable("DeviceColor", doo.getDeviceColor());
		context.setVariable("DeviceSize", doo.getDeviceSize());
		context.setVariable("DeviceMemory", doo.getDeviceMemory());
		context.setVariable("DeviceIMEI", doo.getDeviceIMEI());
		context.setVariable("OrderNumber", doo.getOrderNumber());
		
		
		String processHtml = templateEngine.process("generatedInvoice",context);
		
		OutputStream outputStream = new FileOutputStream("generatedInvoice.pdf");
		ITextRenderer renderer = new ITextRenderer();
		renderer.setDocumentFromString(processHtml);
		renderer.layout();
		renderer.createPDF(outputStream,false);
		renderer.finishPDF();
		outputStream.close();
	}
}
