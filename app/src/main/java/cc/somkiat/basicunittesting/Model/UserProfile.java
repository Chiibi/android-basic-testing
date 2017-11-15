package cc.somkiat.basicunittesting.Model;

import java.util.Date;

import cc.somkiat.basicunittesting.CustomException.RuleException;
import cc.somkiat.basicunittesting.Validator.EmailValidator;
import cc.somkiat.basicunittesting.Validator.NameValidator;

/**
 * Created by Chiib_000 on 15/11/2560.
 */

public class UserProfile {

    private String name;
    private String email;

    private Date bDate;

    private NameValidator nameValidator;
    private EmailValidator emailValidator;

    private UserProfile.ErrorListener errorListener;

    public interface ErrorListener {
        void onError(String errorMessage);
    }

    public UserProfile(String name, String email, Date bdate, ErrorListener errorListener){
        this.name = name;
        this.email = email;
        this.bDate = bdate;
        this.errorListener = errorListener;

        this.nameValidator = new NameValidator();
        this.emailValidator = new EmailValidator();

        try {
            this.nameValidator.validate(name);
        }catch (RuleException e) {
            this.errorListener.onError("Name is invalid");
        }

        try {
            this.emailValidator.validate(email);
        } catch (RuleException e) {
            this.errorListener.onError("Email is invalid");
        }
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Date getBdate() {
        return bDate;
    }
}
