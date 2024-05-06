package jacksondeserialization;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonInjectExample {

	public static void main(String args[]) throws ParseException{   
        
        String jsonString = "{\"name\":\"Nicholas\",\"email\":\"nicholas.clemens@gmail.com\"}";   
          
        // create Scanner class object  
        Scanner sc= new Scanner(System.in);  
          
        System.out.println("Enter Student Id of Nicholas: ");  
        int stdId = sc.nextInt();  
          
        // create an instance of InjectableValues and use it to add student id to the object  
        InjectableValues values = new InjectableValues.Std().addValue(int.class, stdId);   
          //Abstract class that defines API for objects that provide value to"inject" during deserialization.
        // create an instance of ObjectMapper class  
        ObjectMapper mapper = new ObjectMapper();   
        
          
        // use try-catch block to add value to the object  
        try {  
              
            // create instance of the Student class  
            Student student = mapper  
                .reader(values)   
                // this method accepts the Injectable value as a parameter that needs to be passed so that it can be added when the De-serialization happens.
                .forType(Student.class)   
                .readValue(jsonString);   
              
              
            System.out.println("\n Student Id : "+student.stdId +"\n Student Name : " + student.name +"\n Student Email : " + student.email);   
        }  
        catch (IOException e) {   
            e.printStackTrace();   
        }   
          
        // close Scanner class object  
        sc.close();  
    }  
}
