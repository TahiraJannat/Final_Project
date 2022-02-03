package com.example.final_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login2 extends AppCompatActivity {
    Button signupbtn, signinbtn;

    TextView username_var, password_var, register_here;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signinbtn = findViewById(R.id.signInButton);
        signupbtn = findViewById(R.id.signUpButton);
        register_here = findViewById(R.id.registerHere);

        username_var = findViewById(R.id.userName);
        password_var = findViewById(R.id.loginPassword);

        signinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = username_var.getText().toString();
                String password = password_var.getText().toString();

                if (!username.isEmpty()) {
                    username_var.setError(null);
                    if (!password.isEmpty()) {
                        password_var.setError(null);

                        final String username_data = username_var.getText().toString();
                        final String password_data = password_var.getText().toString();

                        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                        DatabaseReference databaseReference = firebaseDatabase.getReference("Tahira");

                        Query check_username = databaseReference.orderByChild("fullname").equalTo(username_data);

                        check_username.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {

                                if (snapshot.exists()) {

                                    username_var.setError(null);
                                    String check_password = snapshot.child(username_data).child(password).getValue(String.class);
                                    if (check_password.equals(password_data)) {
                                        password_var.setError(null);
                                        Toast.makeText(getApplicationContext(), "Logged in succesfully", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), Dashboard.class);
                                        startActivity(intent);
//                                        finish();
                                    } else {
                                        password_var.setError("Wrong Password");
                                    }

                                } else {
                                    username_var.setError("User does not exist");
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });


                    } else {
                        password_var.setError("Please Enter The Password");
                    }
                } else {
                    username_var.setError("Please Enter your username");
                }

            }
        });


        register_here.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUp.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Hello Papon", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}