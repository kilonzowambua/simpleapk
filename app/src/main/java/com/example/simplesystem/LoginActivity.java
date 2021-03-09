package com.example.simplesystem;

import android.os.Bundle;
import android.content.Intent;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        register = (TextView) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {

                                        @Override
                                        public void onClick(View view) {
                                            openRegistrationActivity();
                                        }
                                    }
        );
    }
        public void openRegistrationActivity() {
            Intent intent = new Intent(this, RegistrationActivity.class);
            startActivity(intent);
        }
    }




