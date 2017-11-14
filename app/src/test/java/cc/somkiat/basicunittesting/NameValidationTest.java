package cc.somkiat.basicunittesting;

import org.junit.Test;

import cc.somkiat.basicunittesting.CustomException.RuleException;
import cc.somkiat.basicunittesting.Validator.NameValidator;

public class NameValidationTest {

    @Test(expected = RuleException.class)
    public void nameIsEmpty() throws RuleException {
        String name = "";
        NameValidator nameValidator = new NameValidator();
        nameValidator.isNotNullOrEmpty(name);
    }
}