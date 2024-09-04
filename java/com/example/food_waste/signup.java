package com.example.food_waste;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signup extends AppCompatActivity {
    TextInputEditText user,pass,cnf_pass;
    Button reg_bt;
    TextView clickto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signup);
        user=findViewById(R.id.Username_ed);
        pass=findViewById(R.id.Password_ed);
        cnf_pass=findViewById(R.id.cnf_Password_ed);
        reg_bt=findViewById(R.id.Reg_bt);
        clickto=findViewById(R.id.Clicktolog);
        DBHelper DB;
        DB = new DBHelper(this);
        clickto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(signup.this,login.class);
                startActivity(intent);
                finish();
            }
        });
        reg_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u = user.getText().toString();
                String p = pass.getText().toString();

                Intent intent  = new Intent(signup.this , login.class);






                if (u.isEmpty() || p.isEmpty()) {
                    Toast.makeText(signup.this, "Please enter username and password", Toast.LENGTH_SHORT).show();
                }

                if ( !u.isEmpty()){
                    Boolean checkuser = DB.checkusername(u);
                    if(checkuser == false) {
                        Boolean insert = DB.insertData(u,p);
                        if(insert == true){
                            Toast.makeText(signup.this , "Registered Successful" , Toast.LENGTH_SHORT).show();
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(signup.this , "Registered Failed" , Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(signup.this , "User already Exist! " , Toast.LENGTH_SHORT).show();
                    }



                }
                else{
                    Toast.makeText(signup.this , "Password not matched " , Toast.LENGTH_SHORT).show();
                }



            }


        });
    }
}