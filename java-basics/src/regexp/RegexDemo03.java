package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo03 {
	private static final String REGEX = "foo";
	private static final String INPUT = "fooooooooooooooooo";
	private static Pattern pattern;
	private static Matcher matcher;
	private static String testString = "My Dog is the best dog";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		pattern = Pattern.compile(REGEX);
		matcher = pattern.matcher(INPUT);
		
		System.out.println("Current REGEX is: "+REGEX);
	    System.out.println("Current INPUT is: "+INPUT);

	    System.out.println("lookingAt(): "+matcher.lookingAt());
	    System.out.println("matches(): "+matcher.matches());

	    System.out.println(testString.replace("Dog", "XXX"));
	    System.out.println(testString.replaceFirst(".og","XXX"));
	    System.out.println(testString.replaceAll(".og","XXX"));
	    
	}

}
