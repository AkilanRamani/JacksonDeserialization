package jacksondeserialization;

import java.io.IOException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonEnumDefaultValueExample {

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();  
        
        // use enable method of the class for enabling DeserializationFeature  
        mapper.enable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE);  
          
        // json string for enum  
        String jsonString = "\"abc\"";   
          
        // use try-catch block for deserializing an unknown enum  
        try {  
              
            LETTERS value = mapper.readValue(jsonString, LETTERS.class);   
            System.out.println(value);   
        } catch (IOException e) {   
            e.printStackTrace();   
        }     
    }       

	}


