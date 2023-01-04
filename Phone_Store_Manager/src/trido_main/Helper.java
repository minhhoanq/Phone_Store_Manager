package trido_main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public static boolean isEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    private static final String numberOnlyPattern = "\\d+";
    public static boolean isTelNumber(String input){
        return input.length() > 8 && input.length() <= 11 && input.matches(numberOnlyPattern);
    }
    public static boolean isDigits(String input){
        return input.matches(numberOnlyPattern);
    }

    public static String clearSpace(String input){
        return input.replaceAll("\\s+","");
    }

}
