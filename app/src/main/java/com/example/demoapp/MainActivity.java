package com.example.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText number1,number2,number3,number4;
Button Save;
TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        number3 = findViewById(R.id.number3);
        number4= findViewById(R.id.number4);
        Save = findViewById(R.id.btnSave);
         result = findViewById(R.id.result);
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Num1 = number1.getText().toString();
                String Num2 = number2.getText().toString();
                String Num3 = number3.getText().toString();
                String Num4 = number4.getText().toString();

                if(Num1.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Enter Num1", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(Num2.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Enter Num2", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(Num3.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Enter Num3", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(Num4.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Enter Num4", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    long num1 = Long.parseLong(Num1);
                    long num2 = Long.parseLong(Num2);
                    long num3 = Long.parseLong(Num3);
                    long num4 = Long.parseLong(Num4);
                    if(checkPrime(num1)==false && checkPrime(num2)==false && checkPrime(num3)==false && checkPrime(num4)==false){
                        result.setText(num1+" "+num2+" "+num3+" "+num4+"\nPrime Number");
                    }
                    else if(checkPrime(num1)!=false && checkPrime(num2)==false && checkPrime(num3)==false && checkPrime(num4)==false){
                        result.setText(num2+" "+num3+" "+num4+"\nPrime Number");
                    }
                    else if(checkPrime(num1)==false && checkPrime(num2)!=false && checkPrime(num3)==false && checkPrime(num4)==false){
                        result.setText(num1+" "+" "+num3+" "+num4+"\nPrime Number");
                    }
                    else if(checkPrime(num1)==false && checkPrime(num2)==false && checkPrime(num3)!=false && checkPrime(num4)==false){
                        result.setText(num1+" "+num2+" "+" "+num4+"\nPrime Number");

                    }
                    else if(checkPrime(num1)==false && checkPrime(num2)==false && checkPrime(num3)==false && checkPrime(num4)!=false){
                        result.setText(num1+" "+num2+" "+" "+num3+"\nPrime Number");
                    }
                    else if(checkPrime(num1)!=false && checkPrime(num2)==false && checkPrime(num3)==false && checkPrime(num4)!=false){
                        result.setText(num2+" "+" "+num3+"\nPrime Number");
                    }
                    else if(checkPrime(num1)==false && checkPrime(num2)!=false && checkPrime(num3)!=false && checkPrime(num4)==false){
                        result.setText(num1+" "+" "+num4+"\nPrime Number");
                    }
                    else if(checkPrime(num1)!=false && checkPrime(num2)!=false && checkPrime(num3)==false && checkPrime(num4)==false){
                        result.setText(num3+" "+" "+num4+"\nPrime Number");
                    }
                    else if(checkPrime(num1)==false && checkPrime(num2)==false && checkPrime(num3)!=false && checkPrime(num4)!=false){
                        result.setText(num1+" "+" "+num2+"\nPrime Number");
                    }
                    else if(checkPrime(num1)!=false && checkPrime(num2)!=false && checkPrime(num3)!=false && checkPrime(num4)==false){
                        result.setText(num4+"\nPrime Number");
                    }
                    else if(checkPrime(num1)==false && checkPrime(num2)!=false && checkPrime(num3)!=false && checkPrime(num4)!=false){
                        result.setText(num1+"\nPrime Number");
                    }

                    else if(checkPrime(num1)!=false && checkPrime(num2)==false && checkPrime(num3)!=false && checkPrime(num4)!=false){
                           result.setText(num2+"\nPrime Number");
                    }

                    else if(checkPrime(num1)!=false && checkPrime(num2)!=false && checkPrime(num3)==false && checkPrime(num4)!=false){
                        result.setText(num3+"\nPrime Number");
                    }
                    else{
                        result.setText("\nNot Prime Number");

                    }
                }
            }
        });
    }
    public boolean checkPrime(long num1){
     TextView   result = findViewById(R.id.result);
      boolean f =false;
        if(num1==1|| num1==0){
            result.setText(num1+"\nNot Prime Number");
            f=true;
        }
         else if(num1==2){
            result.setText(num1+"\nPrime Number");
        }
        else{
            for (int i = 2; i <num1 ; i++) {
                long r = num1%i;
                if (r==0){
                    result.setText(num1+"\nNot Prime Number");
                    f=true;
                    break;
                }
                else if(f==false){
                    result.setText(num1+"\nPrime Number");
                }
            }
        }
        return f;
    }
}