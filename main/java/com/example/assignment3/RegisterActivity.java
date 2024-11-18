package com.example.assignment3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText firstName, password, email, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        myDb = new DatabaseHelper(this);

        firstName = findViewById(R.id.name);
        email = findViewById(R.id.username);
        password = findViewById(R.id.password);
        phone = findViewById(R.id.phone);
        Button registerUser = findViewById(R.id.registerUser);

        registerUser.setOnClickListener(v -> {
            String fname = firstName.getText().toString();
            String pwd = password.getText().toString();
            String em = email.getText().toString();
            String ph = phone.getText().toString();

            if (fname.isEmpty()  || pwd.isEmpty() || em.isEmpty() || ph.isEmpty()) {
                Toast.makeText(RegisterActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
            } else {
                boolean isInserted = myDb.insertData(fname, pwd, em, ph);
                if (isInserted) {
                    Toast.makeText(RegisterActivity.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, SignInActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(RegisterActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
