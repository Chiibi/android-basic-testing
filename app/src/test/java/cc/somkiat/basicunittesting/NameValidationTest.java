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

    @Test(expected = RuleException.class)
    public void nameNotEnglish() throws RuleException {
        String name = "ภาษาไทยนะจ๊ะ";
        NameValidator nameValidator = new NameValidator();
        nameValidator.isEngLanguage(name);
    }

    @Test(expected = RuleException.class)
    public void nameHasSymbol() throws RuleException {
        String name = "(^ o^)/";
        NameValidator nameValidator = new NameValidator();
        nameValidator.isEngLanguage(name);
    }
}
