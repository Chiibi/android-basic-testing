package cc.somkiat.basicunittesting;

import org.junit.Test;

import cc.somkiat.basicunittesting.CustomException.RuleException;
import cc.somkiat.basicunittesting.Validator.NameValidator;

import static junit.framework.Assert.assertTrue;

public class NameValidationTest {

    @Test(expected = RuleException.class)
    public void nameIsEmpty() throws RuleException {
        String name = "";
        NameValidator nameValidator = new NameValidator();
        nameValidator.isNotNullOrEmpty(name);
    }

    @Test
    public void nameNotEmpty() throws RuleException {
        String name = "Ohayo";
        NameValidator nameValidator = new NameValidator();
        assertTrue(nameValidator.isNotNullOrEmpty(name));
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

    @Test(expected = RuleException.class)
    public void nameHasNumber() throws RuleException {
        String name = "Suthep2540";
        NameValidator nameValidator = new NameValidator();
        nameValidator.isEngLanguage(name);
    }


}
