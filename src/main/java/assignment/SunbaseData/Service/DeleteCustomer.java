package assignment.SunbaseData.Service;

import java.net.http.HttpHeaders;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import assignment.SunbaseData.model.Customer;


@Service
public class DeleteCustomer implements PostService  {
    

        private String deleteUrl="https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp";

    @Autowired
    private RestTemplate restTemplate;




    public ResponseEntity<String> removeCustomer(String token){
        restTemplate=new RestTemplate();
		
	
        org.springframework.http.HttpHeaders headers=new org.springframework.http.HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		String cmd="delete";
		
		 deleteUrl=deleteUrl+"?cmd="+cmd+"&uuid="+"testb65832472cd54486b1315f42a941dc18";
		headers.setBearerAuth(token);

        HttpEntity<String> et2=new HttpEntity<>(headers);

        ResponseEntity<String> response=restTemplate.exchange(deleteUrl, HttpMethod.POST,et2, String.class);

        if (response != null) {
            return response;
        } else {
            throw new RuntimeException("Deleting cutomer has failed");
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
    public ResponseEntity<String> updatingCustomer(String token) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatingCustomer'");
    }
}
