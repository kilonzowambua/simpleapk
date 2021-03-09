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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.example.simplesystem.R.layout.activity_register;

public class RegistrationActivity extends AppCompatActivity {
    private EditText user_name, user_email, user_password;
    private Button register;
    private FirebaseAuth mAuth;

    //our database reference object
    DatabaseReference databaseuser;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_register);
        mAuth = FirebaseAuth.getInstance();
        //getting the reference of artists node
        databaseuser = FirebaseDatabase.getInstance().getReference("user");
        user_name = (EditText) findViewById(R.id.user_name);
        user_email = (EditText) findViewById(R.id.user_email);
        user_password = (EditText) findViewById(R.id.user_password);
        register = (Button) findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //calling the method addArtist()
                //the method is defined below
                //this method is actually performing the write operation
                adduser();
            }
        });
    }

    private void adduser() {
        //getting the values to save
        String name = user_name.getText().toString();
        String email = user_email.getText().toString();
        String password = user_password.getText().toString();
        if (name.isEmpty() && email.isEmpty() && password.isEmpty()) {
            Toast.makeText(RegistrationActivity.this, "Please Enter All Fields", Toast.LENGTH_SHORT).show();
        } else {
            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our Artist
            String id = databaseuser.push().getKey();

            //creating an Artist Object
            user user = new user(id, name, email, password);

            //Saving the Artist
            databaseuser.child(id).setValue(user);


            //displaying a success toast
            Toast.makeText(this, "User added", Toast.LENGTH_LONG).show();
        }
    }
}










