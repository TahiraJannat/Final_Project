package com.example.final_project;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.example.final_project.databinding.UserdetailsBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.HashMap;

public class UserDetails extends AppCompatActivity {


    UserdetailsBinding binding;
    String dashBoadrdUserName;
    String UserDetailsNDbNAme;
    TextView udashBoadrdUserName;

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = firebaseDatabase.getReference("Tahira/Authentication");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userdetails);

        getSupportActionBar().setTitle("User Profile");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        udashBoadrdUserName = findViewById(R.id.user_name_dashboard);

        String userData = getIntent().getStringExtra("UserDetails");
        UserDetailsNDbNAme = getIntent().getStringExtra("UserDetailsNDbNAme");
        Log.d("mydata112",userData);



//        udashBoadrdUserName.setText(UserDetailsNDbNAme);



        JsonObject jobj = new Gson().fromJson(userData, JsonObject.class);
         dashBoadrdUserName = jobj.get("fullname").toString().replace("\"", "");
        String dashBoadrdUserPass = jobj.get("password").toString().replace("\"", "");
        String dashBoadrdUserEmail = jobj.get("email").toString().replace("\"", "");
        String dashBoadrdUserDateofBirth = jobj.get("dateofbirth").toString().replace("\"", "");
        String dashBoadrdUserLocation = jobj.get("location").toString().replace("\"", "");
        String dashBoadrdUserPhoneNumber = jobj.get("phonenumber").toString().replace("\"", "");





        binding = UserdetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.userNameDashboardUpdate.setText(dashBoadrdUserName);
        binding.uFullName.setText(dashBoadrdUserName);
        binding.uPassword.setText(dashBoadrdUserPass);
        binding.uEmailAddress.setText(dashBoadrdUserEmail);
        binding.uDateofBirth.setText(dashBoadrdUserDateofBirth);
        binding.uLocation.setText(dashBoadrdUserLocation);
        binding.uPhoneNumber.setText(dashBoadrdUserPhoneNumber);


        binding.uSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fullname = binding.uFullName.getText().toString();
                String password = binding.uPassword.getText().toString();
                String email = binding.uEmailAddress.getText().toString();
                String phonenumber = binding.uPhoneNumber.getText().toString();
                String dateofbirth = binding.uDateofbirthTitle.getText().toString();
                String location = binding.uLocation.getText().toString();

                updateData(fullname,password,email,phonenumber,dateofbirth,location);
//               updateData(fullname);
//                Toast.makeText(UserDetails.this, "Updated Successfully", Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void updateData(String location, String password, String email, String phonenumber, String dateofbirth, String fullname) {
        HashMap User = new HashMap();
        User.put("fullname",fullname);
        User.put("password",password);
        User.put("email",email);
        User.put("phonenumber",phonenumber);
        User.put("location",location);
        User.put("dateofbirth",dateofbirth);
        Log.d("myUser", UserDetailsNDbNAme);


        DatabaseReference child = databaseReference.child(UserDetailsNDbNAme);


        child.child("fullname").setValue(fullname);
        child.child("password").setValue(password);
        child.child("email").setValue(email);
        child.child("location").setValue(location);
        child.child("dateofbirth").setValue(dateofbirth);
        child.child("phonenumber").setValue(phonenumber);
        Toast.makeText(UserDetails.this, "Successfully updated", Toast.LENGTH_SHORT).show();

//        databaseReference.child(fullname).updateChildren(User).addOnCompleteListener(new OnCompleteListener() {
//            @Override
//            public void onComplete(@NonNull Task task) {
//                if (task.isSuccessful()){
//                    databaseReference.setValue(fullname);
//
////                    binding.uFullName.setText(fullname);
////                    binding.uPassword.setText(password);
////                    binding.uEmailAddress.setText(email);
//                    Toast.makeText(UserDetails.this, "Successfully updated", Toast.LENGTH_SHORT).show();
//
//                }else{
//                    Toast.makeText(UserDetails.this, "error", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
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