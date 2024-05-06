package jacksondeserialization;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NewProduct {
	   public String newProId;      
	    public String newProName;      
	    public String newProPrice;  
	      
	    //Getter and Setters  
	    public String getProId() {    
	        return newProId;    
	    }    
	      
	    @JsonCreator  
	    public void setProId(@JsonProperty("proId") String newProId) {    
	        this.newProId = newProId;    
	    }    
	    public String getName() {    
	        return newProName;    
	    }    
	    @JsonCreator  
	    public void setProName(@JsonProperty("proName") String newProName) {    
	        this.newProName = newProName;    
	    }    
	    public String getPrice() {    
	        return newProPrice;    
	    }    
	    @JsonCreator  
	    public void setPrice(@JsonProperty("price") String newProPrice) {    
	        this.newProPrice = newProPrice;    
	    }  
}
