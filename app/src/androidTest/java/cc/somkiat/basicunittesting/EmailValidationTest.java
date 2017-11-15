package cc.somkiat.basicunittesting;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import cc.somkiat.basicunittesting.CustomException.RuleException;
import cc.somkiat.basicunittesting.Validator.EmailValidator;

import static junit.framework.Assert.assertTrue;

/**
 * Created by Chiib_000 on 15/11/2560.
 */
@RunWith(AndroidJUnit4.class)
public class EmailValidationTest {

    @Test(expected = RuleException.class)
    public void emailIsEmpty() throws RuleException {
        String email = "";
        EmailValidator emailValidator = new EmailValidator();
        emailValidator.isNotNullOrEmpty(email);
    }

    @Test(expected = RuleException.class)
    public void emailOnlyString() throws RuleException {
        String email = "Chiibihotmailcom";
        EmailValidator emailValidator = new EmailValidator();
        emailValidator.isAllow(email);
    }

    @Test(expected = RuleException.class)
    public void emailNonAddressSymbol() throws RuleException {
        String email = "Chiibihotmail.com";
        EmailValidator emailValidator = new EmailValidator();
        emailValidator.isAllow(email);
    }

    @Test(expected = RuleException.class)
    public void emailWithoutDomain() throws RuleException {
        String email = "Chiibi@hotmail";
        EmailValidator emailValidator = new EmailValidator();
        emailValidator.isAllow(email);
    }

    @Test
    public void emailIsAllow() throws RuleException {
        String email = "admin@hotmail.com";
        EmailValidator emailValidator = new EmailValidator();
        assertTrue(emailValidator.isAllow(email));
    }

    @Test
    public void emailWithSubDomain() throws RuleException {
        String email = "Chiibi.Chayapol_jame@it.kmitl.ac.th";
        EmailValidator emailValidator = new EmailValidator();
        assertTrue(emailValidator.isAllow(email));
    }

    @Test
    public void emailIsValidate() throws RuleException {
        String email = "Chiibi@hotmail.com";
        EmailValidator emailValidator = new EmailValidator();
        assertTrue(emailValidator.isAllow(email));
    }
}
