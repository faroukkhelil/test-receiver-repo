package hello;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
	public class ReceiverController {

	    @RequestMapping("/")
	    public String index() {
	        return "Greetings from Spring Boot!  \n";
	    }
	    
	    @RequestMapping(path="/customers", method= RequestMethod.GET)
	    public long getCustomer(@RequestBody testArg customer){
			return customer.getCustomerId();
	    }
		
	    @RequestMapping(path="/customers", method= RequestMethod.POST)
	    public long postCustomer(@RequestBody testArg customer){
			return customer.getCustomerId();
	    }

	}


