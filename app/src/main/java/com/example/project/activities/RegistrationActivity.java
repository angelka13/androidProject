package com.example.project.activities;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationActivity extends AppCompatActivity {
    private final int CHARACTERS_IN_PASS = 7;
    private final  String PASS_INC_REG_ERROR = "Passwords should contain" +
            " digit, special char,upper case and more than "+CHARACTERS_IN_PASS+" characters! ";
    private final static String PASS_ERROR = "Please enter password";
    private final static String PASS_INC_ERROR = "Passwords must be the same!Please enter correct password";
    private final static String LOGIN_ERROR = "Please enter login";
    private final static String LOGIN_UNAVAILABLE_ERROR = "Login unavailable, please choose another one";
    private final static String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$";

    EditText loginEditText;
    EditText passEditText;
    EditText confPasEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        loginEditText = (EditText) findViewById(R.id.login);
        passEditText = (EditText) findViewById(R.id.password);
        confPasEditText = (EditText) findViewById(R.id.confirmPassword);

        TextView loginLink = (TextView)findViewById(R.id.lnkLogin);
        loginLink.setMovementMethod(LinkMovementMethod.getInstance());
        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void registration(View view)
    {
        switch (view.getId()) {
            case R.id.createAccount:
                saveAccount();
                break;
        }
    }
    private void saveAccount() {
        final String login = loginEditText.getText().toString().trim();
        final String pass = passEditText.getText().toString();
        final String confPass = confPasEditText.getText().toString();
        if(validateUserData( login,pass, confPass)){
            //TODO dodać użytkownika
        }

    }
    private boolean checkLogin(String login){
        //TODO sprawdzi czy login dostepny i inny user nie ma takeigo samego!
        return true;
    }
    private boolean isValidPassword(final String password) {
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
    private boolean validateUserData(String login, String pass,String confPass){
        if(pass.isEmpty()){
            passEditText.setError(PASS_ERROR);
            passEditText.requestFocus();
            return false; }
        if(confPass.isEmpty()){
            confPasEditText.setError(PASS_ERROR);
            confPasEditText.requestFocus();
            return false; }
        if(login.isEmpty()){
            loginEditText.setError(LOGIN_ERROR);
            loginEditText.requestFocus();
            return false; }

        if(!checkLogin(login)){
            loginEditText.setError(LOGIN_UNAVAILABLE_ERROR);
            loginEditText.requestFocus();
            return false; }

        if(!pass.equals(confPass)){
            confPasEditText.setError(PASS_INC_ERROR);
            confPasEditText.requestFocus();
            return false;
        }
        if(!isValidPassword(pass)){
            passEditText.setError(PASS_INC_REG_ERROR);
            passEditText.requestFocus();
            return false; }
        return true;
    }
}