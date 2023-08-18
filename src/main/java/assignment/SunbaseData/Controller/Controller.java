package assignment.SunbaseData.Controller;




import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import assignment.SunbaseData.Service.DeleteCustomer;
import assignment.SunbaseData.Service.FetchingCustomer;
import assignment.SunbaseData.Service.PutCustomer;
import assignment.SunbaseData.Service.TokenService;
import assignment.SunbaseData.model.Customer;



import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value="/api/v1", method = RequestMethod.GET)
public class Controller {
       String generatedToken="";
    private TokenService tokenService=new TokenService();
    private FetchingCustomer fetchCustomer=new FetchingCustomer();
    private PutCustomer putCustomer=new PutCustomer();
    private DeleteCustomer deleteCustomer=new DeleteCustomer();



//for getting the authentication token using RestTemplate
    @PostMapping(value="/auth")
    public String getToken(){
                String response= tokenService.getToken("test@sunbasedata.com","Test@123");
              try {
                  ObjectMapper mapper = new ObjectMapper();
                  JsonNode tree = mapper.readTree(response);
                  JsonNode node = tree.get("access_token");
                  generatedToken = node.textValue().toString();
              }
              catch (Exception e){
                  generatedToken=null;
              }

            

              return generatedToken;
            
        }
    
    //create customer
    @RequestMapping(value="/create",method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<String> NewCustomer(Customer customer) {

            String API_URL = "https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp";

            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization","Bearer"+" "+ generatedToken);
            headers.setContentType(MediaType.APPLICATION_JSON);

            RestTemplate restTemplate = new RestTemplate();
        
             customer = new Customer("John", "Doe", "123 Main St", "Anytown","arizone house no.1", "CA", "john@example.com", "555-1234");

            
            ObjectMapper objectMapper = new ObjectMapper();
            String requestBody;
            try {
                requestBody = objectMapper.writeValueAsString(customer);
                System.out.println("Request Body: " + requestBody);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

            HttpEntity<Customer> requestEntity = new HttpEntity<>(customer, headers);

            ResponseEntity<String> response = restTemplate.postForEntity(API_URL + "?cmd=create", requestEntity, String.class);

            // Print the response
            System.out.println("Response: " + response.getBody());

            
           
            if (response.getStatusCode() == HttpStatus.CREATED) {
                return ResponseEntity.status(HttpStatus.CREATED).body("Successfully Created");
            } else {
                return null;
            }
        }
    

 
     


     @RequestMapping(value="/update",method = RequestMethod.POST)
    public String updateCustomer(){
            ResponseEntity<String>  response=putCustomer.updatingCustomer(generatedToken);
             System.out.println("Response: " + response.getBody());   
              if (response.getStatusCode()==HttpStatusCode.valueOf(200)) {
                return response.getBody();
            } else {
                return null;
            } 
            
        }
    
    
    
    //for getting all the customers
    @GetMapping(value="/customers")
    public List<Object> getCustomers(){
    	List<Object> response=fetchCustomer.getCustomer(generatedToken);
    			return response;

    }



    //deleting a particular Customer
    @RequestMapping(value="/delete",method=RequestMethod.POST)
    public String deleteCustomer(){
         ResponseEntity<String> response=deleteCustomer.removeCustomer(generatedToken);
           System.out.println("Response: " + response.getBody());   
              if (response.getStatusCode()==HttpStatusCode.valueOf(200)) {
                return response.getBody();
            } else {
                return null;
            } 
    }
}
