package cc.somkiat.basicunittesting;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;

import cc.somkiat.basicunittesting.Model.UserProfile;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Chiib_000 on 15/11/2560.
 */
@RunWith(AndroidJUnit4.class)
public class UserProfileTest implements UserProfile.ErrorListener{

    @Test
    public void createCorrectlyUserProfile() {

        String name = "Chiibi";
        String email = "Chiibi@hotmail.com";
        Date bDate = new Date(2000, 2, 22);

        UserProfile userProfile = new UserProfile(name, email, bDate, this);

        assertEquals(userProfile.getName(), name);
        assertEquals(userProfile.getEmail(), email);
        assertEquals(userProfile.getBdate(), bDate);
    }

    @Override
    public void onError(String errorMessage) {

    }
}
