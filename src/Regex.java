import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
	
	public static void main(String[] args) {
		String input = "gdhd EE 23000m hdj Tor! TE hdhd FEH TOR ! _KKWL:W*KIÄ dd Toor! ed2e Gd22 deee 3lol 23w 0d -13md";
		findTwoCapitalLetters(input);
		findTor(input);
		findVarName(input);
		findAgeWithGender(input);
	}
	
	static List<String> regexFind(String input, String regex) {
		List<String> output = new ArrayList<String>();
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		
		while(matcher.find()) {
			output.add(matcher.group());
		}
		
		return output;
	}
	
	static void regexFindOut(String input, String regex) {
		List<String> matches = regexFind(input, regex);
		System.out.printf("For the given regex '%s' found: %s%n", regex, matches);
	}
	
	static void findTwoCapitalLetters(String input) {
		regexFindOut(input, "[A-Z]{2}");
	}
	
	static void findTor(String input) {
		regexFindOut(input, "To+r!");
	}
	
	static void findVarName(String input) {
		regexFindOut(input, "(([A-Z]|[a-z])+[0-9]*)+");
	}
	
	static void findAgeWithGender(String input) {
		regexFindOut(input, "[1-9]+[0-9]*(w|m|d)");
	}
}
