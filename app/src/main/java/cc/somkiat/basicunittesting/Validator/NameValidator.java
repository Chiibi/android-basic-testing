package cc.somkiat.basicunittesting.Validator;

import java.util.regex.Pattern;

import cc.somkiat.basicunittesting.CustomException.RuleException;

/**
 * Created by Chiib_000 on 15/11/2560.
 */

public class NameValidator {

    public NameValidator(){

    }

    public boolean validate(String name) throws RuleException{
        isNotNullOrEmpty(name);
        isEngLanguage(name);
        return true;
    }

    public boolean isEngLanguage(String name) throws RuleException {
        if (!Pattern.matches("^[a-zA-Z]+$", name)){
            throw new RuleException("Name pattern miss match");
        }
        return true;
    }

    public boolean isNotNullOrEmpty(String name) throws RuleException {
        if (name.isEmpty()){
            throw new RuleException("Name is empty");
        }
        return true;
    }
}
