package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo04 {
	   private static String REGEX = "a*b";
	   private static String INPUT = "aabfooaabfooabfoob";
	   private static String REPLACE = "-";
	   public static void main(String[] args) {

	      Pattern p = Pattern.compile(REGEX);
	      
	      // get a matcher object
	      Matcher m = p.matcher(INPUT);
	      StringBuffer sb = new StringBuffer();
	      while(m.find()) {
	    	  System.out.println("before " + sb.toString());
	         m.appendReplacement(sb, REPLACE);
	         System.out.println("After " + sb.toString());
	      }
	     // m.appendTail(sb);
	      System.out.println(sb.toString());
	      System.out.println(m.replaceAll(REPLACE));
	   }
	}