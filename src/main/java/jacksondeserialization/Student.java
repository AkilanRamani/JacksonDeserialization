package jacksondeserialization;

import com.fasterxml.jackson.annotation.JacksonInject;

public class Student {
	public String name;   
    
    public String email;  
      
    @JacksonInject   
    public int stdId;    
}
