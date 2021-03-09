package com.example.simplesystem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.simplesystem.data.LoginRepository;
import com.example.simplesystem.data.Result;
import com.example.simplesystem.data.model.LoggedInUser;
import com.example.simplesystem.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static com.example.simplesystem.R.layout.activity_register;

public class RegistrationActivity extends AppCompatActivity {
    private EditText user_name, user_email ,user_password;
    private Button register;
    private FirebaseAuth mAuth;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_register);
        mAuth = FirebaseAuth.getInstance();
        user_name = (EditText) findViewById(R.id.user_name);
        user_email = (EditText) findViewById(R.id.user_email);
        user_password = (EditText) findViewById(R.id.user_password);
        register = (Button) findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = user_name.getText().toString();
                String email = user_email.getText().toString();
                String password = user_password.getText().toString();
                if (name.isEmpty() && email.isEmpty() && password.isEmpty()) {
                    Toast.makeText(RegistrationActivity.this, "Please Enter All Fields", Toast.LENGTH_SHORT).show();
                } else {
mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(RegistrationActivity.this, new OnCompleteListener<AuthResult>() {
    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
    if(!task.isSuccessful()){
        Toast.makeText(RegistrationActivity.this, "Reagistration failed!", Toast.LENGTH_SHORT).show();

    }else
        {
startActivity(new Intent(RegistrationActivity.this,homeActivity.class));
    }
    }
    });
                }
            }

        });

    }
}




