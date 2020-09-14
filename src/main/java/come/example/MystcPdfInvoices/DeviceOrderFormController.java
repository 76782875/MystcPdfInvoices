package come.example.MystcPdfInvoices;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.lowagie.text.DocumentException;

@Controller
public class DeviceOrderFormController {
	
	@Autowired
	private DeviceOrderService deviceOrderService;
	
	@GetMapping("/")
	public String homePage() {
		return "index";
	}
	
	@GetMapping("/deviceOrder")
	public String deviceOrderForm(Model model) {
		model.addAttribute("deviceOrder", new DeviceOrder());
		return "deviceOrder";
	}
	
	@PostMapping("/deviceOrder")
	public String deviceOrderFormSubmit(@ModelAttribute DeviceOrder deviceOrder, Model model) throws DocumentException, IOException {
		
		model.addAttribute("deviceOrder", deviceOrder);
		
		// Create pdf invoice for the model
	    deviceOrderService.createPdf(deviceOrder);
	    	
		return "resultInvoice";
	}

}
