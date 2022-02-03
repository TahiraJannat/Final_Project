package com.example.final_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    EditText mFullName, mEmail, mPassword, mDateOfBirth,mLocation,mPhoneNumber;
    Button mSignUp;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        getSupportActionBar().setTitle("Sign Up");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mFullName = findViewById(R.id.fullName);
        mEmail = findViewById(R.id.emailAddress);
        mPassword = findViewById(R.id.regPassword);
        mDateOfBirth = findViewById(R.id.dateOfBirth);
        mSignUp = findViewById(R.id.signUpButton);
        mLocation = findViewById(R.id.location);
        mPhoneNumber = findViewById(R.id.phone_number);


    }

//    public void signinbuttonclick(View view) {
//        Intent intent = new Intent(getApplicationContext(), Login.class);
//        startActivity(intent);
//    }

    public void signupbuttonclick(View view) {
        String fullname = mFullName.getText().toString();
        String email = mEmail.getText().toString();
        String password = mPassword.getText().toString();
        String dateofbirth = mDateOfBirth.getText().toString();
        String location = mLocation.getText().toString();
        String phonenumber = mLocation.getText().toString();

        if (!fullname.isEmpty()) {
            mFullName.setError(null);

            if (!email.isEmpty()) {
                mEmail.setError(null);

                if (!dateofbirth.isEmpty()) {
                    mDateOfBirth.setError(null);

                    if (!location.isEmpty()){
                        mLocation.setError(null);
                        if (!phonenumber.isEmpty()){
                            mPassword.setError(null);
                            if (!password.isEmpty()) {
                                mPassword.setError(null);
                                if (email.matches("[a-zA-Z0-9]{1,}[@]{1}[a-z]{5,}[.]{1}+[a-z]{3}")){

                                    firebaseDatabase = FirebaseDatabase.getInstance();
                                    reference = firebaseDatabase.getReference("Tahira/Authentication");

                                    String fullname_s = mFullName.getText().toString().trim();
                                    String email_s = mEmail.getText().toString().trim();
                                    String password_s = mPassword.getText().toString().trim();
                                    String dateofbirth_s = mDateOfBirth.getText().toString().trim();
                                    String location_s = mLocation.getText().toString().trim();
                                    String phonenumber_s = mPhoneNumber.getText().toString().trim();

                                    DataStorage dataStorage = new DataStorage(fullname_s,email_s,dateofbirth_s,password_s,location_s,phonenumber_s);
                                    reference.child(fullname_s).setValue(dataStorage);
                                    Toast.makeText(getApplicationContext(),"register succesfully",Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(getApplicationContext(),Dashboard.class);
                                    Intent intent2 = new Intent(getApplicationContext(),Login.class);
//                            Intent intent = new Intent(SignUp.this,UserDetails.class);
//                            intent.putExtra("UserPass",password_s);
                                    startActivity(intent);
                                    startActivity(intent2);
//                                finish();

                                }else{
                                    mEmail.setError("Invalid email");
                                }

                            } else {
                                mPassword.setError("Please Enter The Birth");

                            }
                        }else{
                            mPhoneNumber.setError("Enter Phone Number");
                        }

                    }else{
                        mLocation.setError("Enter Location");
                    }
                } else {
                    mDateOfBirth.setError("Please Enter The Password");

                }
            } else {
                mEmail.setError("Please Enter The Email");

            }

        } else {
            mFullName.setError("Please Enter Fullname");

        }

    }


    ////backbutton
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}