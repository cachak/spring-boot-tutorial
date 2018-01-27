package id.web.sahir.framework.validation.constraints;


import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.LengthRule;
import org.passay.PasswordValidator;
import org.passay.CharacterSequence;
import org.passay.EnglishSequenceData;
import org.passay.WhitespaceRule;
import org.passay.RuleResult;
import org.passay.PasswordData;



public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public void initialize(final ValidPassword arg0) {

    }

    @Override
    public boolean isValid(final String password, final ConstraintValidatorContext context) {
        // @formatter:off
        final PasswordValidator validator = new PasswordValidator(Arrays.asList(
                new LengthRule(8, 30),
                new CharacterRule(EnglishCharacterData.UpperCase, 1),
                new CharacterRule(EnglishCharacterData.LowerCase, 1),
                new CharacterRule(EnglishCharacterData.Digit, 1),
                new CharacterRule(EnglishCharacterData.Special, 1),
                //new CharacterRule(EnglishCharacterData. 1),
                //new CharacterSequence(EnglishSequenceData.Alphabetical),
                //new CharacterSequence(EnglishSequenceData.Numerical),
                //new CharacterSequence(EnglishSequenceData.USQwerty),
                //new NumericalSequenceRule(3,false),
                //new AlphabeticalSequenceRule(3,false),
                //new QwertySequenceRule(3,false),
                new WhitespaceRule()));
        final RuleResult result = validator.validate(new PasswordData(password));
        if (result.isValid()) {
            return true;
        }
        String message = "";
        for (String msg:validator.getMessages(result)) {
            if (!message.isEmpty()) {
                message += ",";
            }
            message += msg;
        }
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
        //context.buildConstraintViolationWithTemplate(Joiner.on(",").join(validator.getMessages(result))).addConstraintViolation();
        return false;
    }
}
