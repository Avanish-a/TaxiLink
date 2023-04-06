package com.example.taxilink.LoginController;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.taxilink.R;
import com.example.taxilink.TaxiSessionController.HomePage;
import com.google.android.material.button.MaterialButton;

public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        TextView email = (TextView) findViewById(R.id.emailField);
        TextView password = (TextView) findViewById(R.id.passwordField);

        MaterialButton loginBtn = (MaterialButton) findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().equals("admin") &&
                        password.getText().toString().equals("password")) {
                    startActivity(new Intent(v.getContext(), HomePage.class));
                }
                else {
                    Toast.makeText(LoginPage.this, "Incorrect email or password." +
                                    " Please try again.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
