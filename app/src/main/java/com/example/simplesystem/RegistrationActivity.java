package com.example.simplesystem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

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

import static com.example.simplesystem.R.layout.activity_register;

public class RegistrationActivity<Botton> extends AppCompatActivity {
    private EditText user_name, user_email ,user_password;
    private Button register;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_register);
        declarevarables();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()){
                    //upload to db
                    
                }

            }
        });
    }
   private void declarevarables(){
        user_name = (EditText)findViewById(R.id.user_name);
        user_email = (EditText)findViewById(R.id.user_email);
        user_password = (EditText)findViewById(R.id.user_password);
        register = (Button)findViewById(R.id.register);
    }
    private  Boolean validate()
    {
        Boolean results = false;
        String name = user_name.getText().toString();
        String email = user_email.getText().toString();
        String password = user_email.getText().toString();
        if(name.isEmpty() && email.isEmpty() && password.isEmpty()) {
            Toast.makeText(this, "Please Enter All Fields", Toast.LENGTH_SHORT).show();
               }
        else
               {
      results = true;
               }
        return results;
    }


}
