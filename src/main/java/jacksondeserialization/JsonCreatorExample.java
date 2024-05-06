package jacksondeserialization;

import java.io.IOException;
import java.text.ParseException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonCreatorExample {
	 public static void main(String args[]) throws ParseException {  
         
	        // create instance of the ObjectSerialization class  
	        ObjectMapper obj = new ObjectMapper();  
	          
	        try {  
	              
	            String jsonString = "{\"proId\":\"001\",\"proName\":\"MX Pro 20\",\"price\":\"25k\"}";   
	            System.out.println(jsonString);  
	              
	            /*NewProduct newProd1 = obj   
	                    .readerFor(NewProduct.class)   
	                    .readValue(jsonString); */  
	            NewProduct newProd = obj.readValue(jsonString, NewProduct.class);
	           
	            System.out.println("Product Id: "+newProd.newProId +", Product Name: " + newProd.newProName+", Product Price: "+newProd.newProPrice);  
	              
	        } catch (JsonParseException e) {  
	            e.printStackTrace();  
	        } catch (JsonMappingException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }   
}
}