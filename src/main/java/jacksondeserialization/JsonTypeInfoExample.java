package jacksondeserialization;

import java.io.IOException;
import java.util.Scanner;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTypeInfoExample {
	  
		   public static void main(String args[]) throws IOException {  
		          
		        // create Scanner class object  
		        Scanner sc= new Scanner(System.in);       
		          
		        ShapeInfo shapeObj;  
		          
		        String name;  
		        Double radious;  
		          
		        System.out.println("Enter name of Circle:");  
		        name = sc.nextLine();  //1
		          
		        System.out.println("Enter radious of Circle:");  
		        radious = sc.nextDouble();   //1.0
		          
		        // create an instance of Shape class  
		        shapeObj = new JsonTypeInfoExample.CircleInfo(name, radious);  
		          
		        // Serialize CircleInfo  
		        String result = new ObjectMapper()  
		            .writerWithDefaultPrettyPrinter()  
		            .writeValueAsString(shapeObj);  
		        System.out.println(result);   
		          
		        // json string to de-serialize  
		        String jsonString = "{\"name\":\"squareTest\",\"length\":0.5, \"type\":\"square\"}";  
		        System.out.println("Json data to deserialize: "+jsonString);  
		          
		        // use ObjectMapper class for deserializing json  
		        SquareInfo square = new ObjectMapper().readerFor(ShapeInfo.class).readValue(jsonString);  
		        System.out.println(square.name);   
		        // close Scanner class object  
		        sc.close();  
		          
		    }  
		      
		    // create class ShapeInfo by using @JsonTypeInfo and @JsonSubTypes  
		    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME ,include = As.PROPERTY, property = "type") @JsonSubTypes({  
		        @JsonSubTypes.Type(value = SquareInfo.class, name = "square"),  
		           @JsonSubTypes.Type(value = CircleInfo.class, name = "circle")  
		            })  
		    
		  
		    static class ShapeInfo {  
		        public String name;   
		          
		        // parameterized constructor  
		        ShapeInfo(String name){  
		            this.name = name;  
		        }  
		    }  
		      
		    // create class CircleInfo that extend ShapeInfo  
		    @JsonTypeName("square")  // reference name that is Provided to each class (that denotes name refers to the class Type)
		    static class SquareInfo extends ShapeInfo {  
		        public double length;  
		          
		        // default constructor for setting default values  
		        SquareInfo(){  
		            this(null,0.0);  
		        }  
		          
		        // parameterized constructor to set user define values  
		        SquareInfo(String name, double length){  
		            super(name);  
		            this.length = length;  
		        }  
		    }  
		      
		    // create class CircleInfo that extend Shape  
		    @JsonTypeName("circle")  
		    static class CircleInfo extends ShapeInfo {  
		        public double circleRadius;    
		          
		        // default constructor for setting default values  
		        CircleInfo(){  
		            this(null,0.0);  
		        }  
		          
		        // parameterized constructor to set user define values  
		        CircleInfo(String circleName, double circleRadius) {  //1,1.0 
		            super(circleName);  //1
		            this.circleRadius = circleRadius;  
		        }  
		    }  
}