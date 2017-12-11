package com.example.ummie.expertchat;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

/**
 * Created by UmiIrwanMaryam on 12-Dec-17.
 */




public class register extends AppCompatActivity {


    private FirebaseAuth cAuth;

    private TextInputLayout email,pass,name;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        cAuth = FirebaseAuth.getInstance();

        name = (TextInputLayout) findViewById(R.id.name);
        email = (TextInputLayout) findViewById(R.id.email1);
        pass = (TextInputLayout) findViewById(R.id.pass1);

        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String display_name = name.getEditText().getText().toString();
                String email_user = email.getEditText().getText().toString();
                String pass_user = pass.getEditText().getText().toString();


                register_user(display_name,email_user,pass_user);

            }
        });

    }

    private void register_user(String name, String email, String pass) {

        cAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(register.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //success Register
                if (task.isSuccessful())
                {
                    Intent intent = new Intent(register.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {


                    Toast.makeText(register.this, "please try again", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }


}
