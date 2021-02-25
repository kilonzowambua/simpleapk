package com.example.simplesystem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import android.os.Bundle;
import android.util.Patterns;
import android.widget.EditText;

import com.example.simplesystem.data.LoginRepository;
import com.example.simplesystem.data.Result;
import com.example.simplesystem.data.model.LoggedInUser;
import com.example.simplesystem.R;

import static com.example.simplesystem.R.layout.activity_register;

public class RegistrationActivity extends AppCompatActivity {
    private EditText
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_register);
    }
}
