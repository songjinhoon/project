package action;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)  
public @interface RequestMapping { 
	enum RequestMethod { GET, POST };
	String    value();
	RequestMethod  method()    default RequestMethod.GET;
}

