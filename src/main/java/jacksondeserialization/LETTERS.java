package jacksondeserialization;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

public enum LETTERS {

	  A, B, @JsonEnumDefaultValue UNKNOWN 
	  //Marker annotation that can be used to define a default valueused when trying to deserialize unknown Enum values. 

}
