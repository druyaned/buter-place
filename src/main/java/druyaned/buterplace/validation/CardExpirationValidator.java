package druyaned.buterplace.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CardExpirationValidator
        implements ConstraintValidator<CardExpirationConstraint, String>
{
    
    private static final Pattern CARD_EXPIRATION_PATTERN =
            Pattern.compile("(0[1-9]|1[0-2])/([2-9][0-9])");
    
    @Override public boolean isValid(String cardExpiration, ConstraintValidatorContext cvc) {
        Matcher matcher = CARD_EXPIRATION_PATTERN.matcher(cardExpiration);
        if (!matcher.matches()) {
            return false;
        }
        String monthPart = matcher.group(1);
        int month = (monthPart.charAt(0) - '0') * 10 + monthPart.charAt(1) - '0';
        String yearPart = matcher.group(2);
        int year = 2000 + (yearPart.charAt(0) - '0') * 10 + yearPart.charAt(1) - '0';
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        int currentMonth = currentDate.getMonthValue();
        if (year < currentYear) {
            return false;
        } else if (year == currentYear && month < currentMonth) {
            return false;
        }
        return true;
    }
    
}
