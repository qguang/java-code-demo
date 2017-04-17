package regexp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo01 {

	public static void main(String args[]){
		System.out.println("this is a very basci string regexp test");
		 // String to be scanned to find the pattern.
	    String line = "This order was placed for QT3000! OK?";
	    String pattern = "(.*)(\\d+)(.*)";
	    
	    // Create a Pattern object
	    Pattern r = Pattern.compile(pattern);
	    
	    // Now create matcher object.
	    Matcher m = r.matcher(line);
	    
	    if (m.find( )) {
	    	System.out.println("total pattern found " + m.groupCount());
	    	System.out.println("Found value 0: " + m.group(0) );
	    	System.out.println("Found value 1: " + m.group(1) );
	    	System.out.println("Found value 2: " + m.group(2) ); 
	    	System.out.println("Found value 3: " + m.group(3) ); 
	    	 
        }else {
	         System.out.println("NO MATCH");
	    }
	}
}
