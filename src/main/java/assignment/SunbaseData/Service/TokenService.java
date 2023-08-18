package assignment.SunbaseData.Service;

import assignment.SunbaseData.model.Customer;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TokenService implements PostService{

    private String authUrl="https://qa2.sunbasedata.com/sunbase/portal/api/assignment_auth.jsp";
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public String getToken(String loginId, String password) {
        restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("login_id", loginId);
        requestBody.put("password", password);

        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                authUrl,
                HttpMethod.POST,
                requestEntity,
                String.class
        );


        String responseBody = responseEntity.getBody();
        System.out.println(responseBody);
        if (responseBody != null) {
            return responseBody;
        } else {
            throw new RuntimeException("Token retrieval failed");
        }
    }

 


    

	@Override
	public List<Object> getCustomer(String token) {
		// TODO Auto-generated method stub
		return null;
	}






	@Override
	public String createCus(String token, Customer customer) {
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
