package com.example.demoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registration extends AppCompatActivity {
EditText name,email,password,confirmPassword;
Button register;
private FirebaseAuth mAuth;
ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        name = findViewById(R.id.name);
        email= findViewById(R.id.email);
        password = findViewById(R.id.password);
        register = findViewById(R.id.btnRegistration);
        confirmPassword= findViewById(R.id.conpassword);
        mAuth = FirebaseAuth.getInstance();
        dialog = new ProgressDialog(this);
        dialog.setMessage("Please wait..");
        dialog.setCancelable(false);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String Name = name.getText().toString();
              String Email =email.getText().toString();
              String Password = password.getText().toString();
              String ConfirmPassword = confirmPassword.getText().toString();
                dialog.show();
              if (Name.isEmpty()){
                  Toast.makeText(getApplicationContext(),"Enter Name!!",Toast.LENGTH_LONG).show();
                  dialog.dismiss();
                  return;
              }
              else if (Email.isEmpty()){
                  Toast.makeText(getApplicationContext(),"Enter Email!!",Toast.LENGTH_LONG).show();
                 dialog.dismiss();
                  return;
              }
              else if(Password.isEmpty()){
                  Toast.makeText(getApplicationContext(),"Enter Password!!",Toast.LENGTH_LONG).show();
                dialog.dismiss();
                  return;
              }
              else if(ConfirmPassword.isEmpty()){
                  Toast.makeText(getApplicationContext(),"Enter ConfirmPassword!!",Toast.LENGTH_LONG).show();
                dialog.dismiss();
                return;
              }
              else if(Password.equals(ConfirmPassword)){
                  mAuth.createUserWithEmailAndPassword(Email,ConfirmPassword)
                          .addOnCompleteListener(Registration.this, new OnCompleteListener<AuthResult>() {
                              @Override
                              public void onComplete(@NonNull Task<AuthResult> task) {
                                  if (task.isSuccessful()) {
                                      // Sign in success, update UI with the signed-in user's information
                                     startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                     dialog.dismiss();
                                  } else {
                                      dialog.dismiss();
                                      // If sign in fails, display a message to the user.
                                     Toast.makeText(getApplicationContext(),"Registration Failed!!",Toast.LENGTH_LONG).show();
                                     return;
                                  }
                              }
                          });
              }

            }
        });
    }
}