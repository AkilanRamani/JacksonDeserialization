package jacksondeserialization;

import java.io.IOException;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonAutoDetectExample {

	public static void main(String[] args) {
		
	          
	        // create an instance of ObjectMapper class  
	        ObjectMapper mapper = new ObjectMapper();  
	          
	        // create Scanner class object  
	        Scanner sc= new Scanner(System.in);       
	          
	        // using try-catch for serializing Product  
	        try {  
	              
	            Product12 product;  
	              
	            String proId, proName, proPrice, proExpiry;  
	              
	            System.out.println("Enter Product Id:");  
	            proId = sc.nextLine();  
	              
	            System.out.println("Enter Product Name");  
	            proName = sc.nextLine();  
	              
	            System.out.println("Enter Product Price");  
	            proPrice = sc.nextLine();  
	              
	            System.out.println("Enter Product Expiry");  
	            proExpiry = sc.nextLine();  
	              
	            // set values to Student object by using constructor  
	            product = new Product12(proId, proName, proPrice, proExpiry);     
	              
	            // serialize Product using mapper  
	            String jsonString = mapper  
	                .writerWithDefaultPrettyPrinter()  
	                .writeValueAsString(product);  
	            System.out.println(jsonString);  
	        }  
	        catch (IOException e) {   
	            e.printStackTrace();  
	        }  
	          
	        //close Scanner class object  
	        sc.close();  
	          
	    }  

	}


