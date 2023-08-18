package assignment.SunbaseData.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import assignment.SunbaseData.model.Customer;


public interface PostService {


    public String getToken(String login,String password);
    public List<Object> getCustomer(String token);
    public String createCus(String token,Customer customer);
    public ResponseEntity<String> updatingCustomer(String token);
    public ResponseEntity<String> removeCustomer(String token);
}
