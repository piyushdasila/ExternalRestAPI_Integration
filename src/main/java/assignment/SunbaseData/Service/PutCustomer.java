package assignment.SunbaseData.Service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import assignment.SunbaseData.model.Customer;

@Service
public class PutCustomer implements PostService{

    private String putUrl="https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp";
	
	@Autowired
	private RestTemplate restTemplate;



    public ResponseEntity<String>  updatingCustomer(String token){

        restTemplate=new RestTemplate();
		
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		String cmd="update";
		
		 putUrl=putUrl+"?cmd="+cmd+"&uuid="+"testb65832472cd54486b1315f42a941dc18";
		 
		 headers.setBearerAuth(token);
		 Customer customer=new Customer("John", "Doe", "123 Main St", "Anytown","arizone house no.1", "CA", "john@example.com", "555-1234");
		 

		  HttpEntity<Customer> et2=new HttpEntity<>(customer,headers);
		  ResponseEntity<String> response = restTemplate.exchange(putUrl, HttpMethod.POST,et2, String.class);

	        
	       
	        if (response != null) {
	            return response;
	        } else {
	            throw new RuntimeException("Updating cutomer has failed");
	        }
   

    }

    @Override
    public String getToken(String login, String password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getToken'");
    }

    @Override
    public List<Object> getCustomer(String token) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCustomer'");
    }

    @Override
    public String createCus(String token, Customer customer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createCus'");
    }

    @Override
    public ResponseEntity<String> removeCustomer(String token) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeCustomer'");
    }



}
