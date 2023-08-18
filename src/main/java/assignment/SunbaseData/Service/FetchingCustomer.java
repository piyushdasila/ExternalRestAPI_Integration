package assignment.SunbaseData.Service;

import java.util.Arrays;
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
public class FetchingCustomer implements PostService{
	
	private String getUrl="https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp";
	
	@Autowired
	private RestTemplate restTemplate;

	


	@Override
	public List<Object> getCustomer(String token) {
		
		restTemplate=new RestTemplate();
		
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		String cmd="get_customer_list";
		
		 getUrl=getUrl+"?cmd="+cmd;
		 
		 headers.setBearerAuth(token);
		 
		  HttpEntity<Object[]> et2=new HttpEntity<>(headers);
	        ResponseEntity<Object[]> responseEntity2 = restTemplate.exchange(
	                getUrl,
	                HttpMethod.GET,
	                et2,
	                Object[].class
	        );
	        
	        Object[] response=responseEntity2.getBody();
	        if (response != null) {
	            return Arrays.asList(response);
	        } else {
	            throw new RuntimeException("Fetching cutomer has failed");
	        }
	  }
	@Override
	public String getToken(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String createCus(String token,Customer customer) {
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
	
	
	


