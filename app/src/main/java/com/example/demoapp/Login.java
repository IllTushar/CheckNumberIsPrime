package com.example.demoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
Button login;
EditText email,password;
ProgressDialog dialog;
TextView registration;
private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = findViewById(R.id.btnLogin);
        email = findViewById(R.id.lemail);
        password = findViewById(R.id.lpassword);
        registration = findViewById(R.id.registration);
        mAuth = FirebaseAuth.getInstance();
        dialog = new ProgressDialog(this);
        dialog.setMessage("Please wait...");
        dialog.setCancelable(false);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String Email = email.getText().toString();
               String Password = password.getText().toString();
               dialog.show();
               if (Email.isEmpty()){
                   dialog.dismiss();
                   Toast.makeText(getApplicationContext(),"Enter Email!!",Toast.LENGTH_LONG).show();
                   return;
               }
               else if(Password.isEmpty()){
                   dialog.dismiss();
                   Toast.makeText(getApplicationContext(),"Enter Password!!",Toast.LENGTH_LONG).show();
                   return;
               }
               else {
                   mAuth.signInWithEmailAndPassword(Email,Password)
                           .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                               @Override
                               public void onComplete(@NonNull Task<AuthResult> task) {
                                   if (task.isSuccessful()) {
                                      dialog.dismiss();
                                      startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                   } else {
                                       dialog.dismiss();
                                       Toast.makeText(getApplicationContext(),"Login Failed!!",Toast.LENGTH_LONG).show();
                                       return;
                                   }
                               }
                           });
               }
            }
        });
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(),Registration.class));
            }
        });
    }
}