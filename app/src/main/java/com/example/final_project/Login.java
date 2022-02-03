package com.example.final_project;



import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Login extends AppCompatActivity {
    Button signupbtn, signinbtn;

    TextView username_var, password_var, register_here;

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = firebaseDatabase.getReference("Tahira/Authentication");

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
                //checking UserPAss
//                Intent intent = new Intent(getApplicationContext(), Dashboard.class);
//                startActivity(intent);

                getSupportActionBar().setTitle("User Dashboard");
                checkUser (username_var.getText().toString(), password_var.getText().toString());




//                appState.setState(x);
            }
        });

        register_here.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUp.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void checkUser(String inputtedID, String InputtedPass) {
        Log.d("myUserName", inputtedID);
        Log.d("myUserPass", InputtedPass);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChild(inputtedID)) {


                    Log.d("myUserNameDbCheck", "true");
                    checkPass(inputtedID, InputtedPass); //checkpass
                } else {
                    Log.d("myUserNameDbCheck", "false");

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("blabla1", "onCancelled", databaseError.toException());
            }
        });
    }

    private void checkPass(String inputtedID, String InputtedPass) {
        DatabaseReference child = databaseReference.child(inputtedID);
        DatabaseReference child_pass = child.child("password");

        child_pass.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                if (dataSnapshot.getValue(String.class).equals(InputtedPass)) {

                    Log.d("myUserPassDbCheck", "true");
                    getUserDataForEdit(inputtedID);
                } else {
                    Log.d("myUserPassDbCheck", "false");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("onCancelled", "onCancelled", databaseError.toException());
            }
        });

    }


    private void getUserDataForEdit(String inputtedID) {
        DatabaseReference user = databaseReference.child(inputtedID);

        user.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Object object = dataSnapshot.getValue(Object.class);
                String userDetails = new Gson().toJson(object);



                Intent intent = new Intent(Login.this, Dashboard.class);
                intent.putExtra("UserDetails", userDetails);
                intent.putExtra("UserDetailsNDbNAme", inputtedID);

                startActivity(intent);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("onCancelled", "onCancelled", databaseError.toException());
            }
        });

    }





}