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
public class CreateCustomer implements PostService {
   
	String createUrl="https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp";
	
	 @Autowired
		private RestTemplate restTemplate;


	
	
	public String createCus(String token,Customer customer) {
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		 headers.setBearerAuth(token);
		System.out.println(token);
		 restTemplate=new RestTemplate();
		 String cmd="create";
		
		 createUrl=createUrl+"?cmd="+cmd;
		
	        
	        HttpEntity<Customer> entity = new HttpEntity<>(customer, headers);
	        
	        ResponseEntity<String> response = restTemplate.exchange(createUrl, HttpMethod.POST, entity,String.class);	        
	       
	        
            return response.getBody();

      
		
	}
	
	
	
	
	
	@Override
	public String getToken(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> getCustomer(String token) {
		// TODO Auto-generated method stub
		return null;
	}
    @Override
	public ResponseEntity<String>  updatingCustomer(String token) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'updatingCustomer'");
	}





	@Override
	public ResponseEntity<String> removeCustomer(String token) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'removeCustomer'");
	}






}
