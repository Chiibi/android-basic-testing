package cc.somkiat.basicunittesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

import cc.somkiat.basicunittesting.Model.UserProfile;

public class MainActivity extends AppCompatActivity implements UserProfile.ErrorListener{

    private EditText nameField;
    private EditText emailField;

    private DatePicker bDatePicker;

    private Button saveBtn;
    private Button revertBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.nameField = findViewById(R.id.userNameInput);
        this.emailField = findViewById(R.id.emailInput);

        this.bDatePicker = findViewById(R.id.dateOfBirthInput);

        this.saveBtn = findViewById(R.id.saveButton);
        this.revertBtn = findViewById(R.id.revertButton);

        this.saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSaveClick();
            }
        });
        this.revertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRevertClick();
            }
        });
    }

    public void onSaveClick() {
        String name = nameField.getText().toString();
        String email = emailField.getText().toString();
        Date bDate = new Date(bDatePicker.getYear(), bDatePicker.getMonth(), bDatePicker.getDayOfMonth());
        UserProfile userProfile = new UserProfile(name, email, bDate, this);
    }

    public void onRevertClick() {
        this.nameField.setText("");
        this.emailField.setText("");
    }

    @Override
    public void onError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }
}
