package com.example.loginapp;

import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);
        layout.setPadding(60, 60, 60, 60);

        TextView title = new TextView(this);
        title.setText("Login");
        title.setTextSize(32);
        title.setGravity(Gravity.CENTER);

        EditText etUsername = new EditText(this);
        etUsername.setHint("Username");

        EditText etPassword = new EditText(this);
        etPassword.setHint("Password");
        etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

        CheckBox showPass = new CheckBox(this);
        showPass.setText("Show password");

        Button btnLogin = new Button(this);
        btnLogin.setText("Login");

        layout.addView(title);
        layout.addView(etUsername);
        layout.addView(etPassword);
        layout.addView(showPass);
        layout.addView(btnLogin);
        setContentView(layout);

        showPass.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            } else {
                etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            }
            etPassword.setSelection(etPassword.getText().length());
        });

        btnLogin.setOnClickListener(v -> {
            String user = etUsername.getText().toString().trim();
            String pass = etPassword.getText().toString().trim();

            if (user.isEmpty()) {
                etUsername.setError("Enter username");
            } else if (pass.isEmpty()) {
                etPassword.setError("Enter password");
            } else if (user.equals("admin") && pass.equals("1234")) {
                Toast.makeText(this, "Welcome, " + user + "! Login successful", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show();
            }
        });
    }
}