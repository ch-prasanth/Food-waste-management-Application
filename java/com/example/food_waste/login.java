package com.example.food_waste;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {
    TextInputEditText user,pass;
    Button login_bt;
    ImageView fb,twi,goog;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user=findViewById(R.id.Username_ed);
        pass=findViewById(R.id.Password_ed);
        login_bt=findViewById(R.id.Login_bt);
        fb=(ImageView) findViewById(R.id.fb);
        twi=(ImageView) findViewById(R.id.twi);
        goog=(ImageView) findViewById(R.id.goog);
        DBHelper DB;
        DB = new DBHelper(this);
        login_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String us = user.getText().toString();
                String pas = pass.getText().toString();




                if (us.equals("") || pass.equals("")){
                    Toast.makeText(login.this ,  "Fields must not be empty" , Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkuserpass = DB.checkusernamePassword(us , pas);
                    if(checkuserpass == true){
                        Toast.makeText(login.this , "Login Successful" , Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(login.this , home.class);
                        startActivity(intent1);
                    }
                    else{
                        Toast.makeText(login.this , "Invaild Credentials" , Toast.LENGTH_SHORT).show();
                    }

                }


            }


        });
    }

}