package cc.somkiat.basicunittesting.Validator;

import android.util.Patterns;

import cc.somkiat.basicunittesting.CustomException.RuleException;

/**
 * Created by Chiib_000 on 15/11/2560.
 */

public class EmailValidator {
    public EmailValidator() {
    }

    public boolean validate(String email) throws RuleException{
        isNotNullOrEmpty(email);
        isAllow(email);
        return true;
    }

    public boolean isAllow(String email) throws RuleException {
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            throw new RuleException("Email pattern miss match");
        }
        return true;
    }

    public boolean isNotNullOrEmpty(String email) throws RuleException{
        if(email.isEmpty()){
            throw new RuleException("Email is Empty");
        }
        return true;
    }
}
