package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.cardview.widget.CardView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Dashboard extends AppCompatActivity implements View.OnClickListener {
    GridLayout gridLayout;
    TextView user_name_dashboard;
    String dashBoadrdUserDetails;
    String UserDetailsNDbNAme;
    List<String> arraylist1= new ArrayList<String>();

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = firebaseDatabase.getReference("Tahira/Property");


    private  CardView addProperty, editProperty, purchaseProperty, userDetails, messageBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("User Dashboard");
//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        user_name_dashboard = findViewById(R.id.user_name_dashboard);


        checkProperty();

//
//        gridLayout=(GridLayout)findViewById(R.id.mainGrid);
//
//        setSingleEvent(gridLayout);
        //defining card
        addProperty = (CardView) findViewById(R.id.add_property);
        editProperty = (CardView) findViewById(R.id.edit_property);
        purchaseProperty = (CardView) findViewById(R.id.purchase_property);
        userDetails = (CardView) findViewById(R.id.user_details);
        messageBox = (CardView) findViewById(R.id.message_box);

        //add onclicklistener the card

        addProperty.setOnClickListener(this);
        editProperty.setOnClickListener(this);
        purchaseProperty.setOnClickListener(this);
        userDetails.setOnClickListener(this);
        messageBox.setOnClickListener(this);
        dashBoadrdUserDetails = getIntent().getStringExtra("UserDetails");
        UserDetailsNDbNAme = getIntent().getStringExtra("UserDetailsNDbNAme");

        JsonObject jobj = new Gson().fromJson(dashBoadrdUserDetails, JsonObject.class);
        String dashBoadrdUserName = jobj.get("fullname").toString().replace("\"", "");
        Log.d("mydata112",dashBoadrdUserName);

        user_name_dashboard.setText(dashBoadrdUserName);

    }


    ////backbutton
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId()==android.R.id.home) {
//            finish();
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    ///logout
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.exit) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(Dashboard.this, Login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
        Toast.makeText(Dashboard.this, "Logged out successully", Toast.LENGTH_SHORT).show();

    }
//    private void setSingleEvent(GridLayout gridLayout) {
//
//        for(int i = 0; i<gridLayout.getChildCount();i++){
//            CardView cardView=(CardView)gridLayout.getChildAt(i);
//            final int finalI= i;
//            cardView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                    Toast.makeText(Dashboard.this,"Clicked at index "+ finalI,
//                            Toast.LENGTH_SHORT).show();
//
//                    Intent intent = new Intent(getApplicationContext(),AddProperty.class);
//                    startActivity(intent);
//                    finish();
//                }
//            });
//        }
//    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.add_property: i = new Intent(this, AddProperty.class)
                    .putExtra("UserDetailsNDbNAme",UserDetailsNDbNAme.toString()); startActivity(i);break;
            case R.id.edit_property: i = new Intent(this, PropertyEditNew.class).
                    putExtra("UserDetailsNDbNAme",UserDetailsNDbNAme.toString()).
                    putExtra("propertyList", (Serializable) arraylist1);

            startActivity(i);break;

            case R.id.purchase_property: i = new Intent(this, PropertyEditNew.class).
                    putExtra("UserDetailsNDbNAme",UserDetailsNDbNAme.toString()).
                    putExtra("propertyList", (Serializable) arraylist1);

                startActivity(i);break;

//            case R.id.purchase_property: i = new Intent(this, EditProperty.class); startActivity(i);break;
            case R.id.user_details: i =
                    new Intent(Dashboard.this, UserDetails.class).
                            putExtra("UserDetails", dashBoadrdUserDetails.toString()).
                            putExtra("UserDetailsNDbNAme",UserDetailsNDbNAme.toString());
            startActivity(i);break;
            default:break;
        }

    }

    private void checkProperty() {
        Log.d("myData", "Checking data ");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    String uid = ds.getKey();
                    Log.d("myData", String.valueOf(uid));
                    getPropertyData(uid);

                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("blabla1", "onCancelled", databaseError.toException());
            }
        });
    }


    private void getPropertyData(String propertyChild) {
        DatabaseReference child = databaseReference.child(propertyChild);
        DatabaseReference childProperty = child.child("propertytype");

        child.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.child("propertyowner").getValue(String.class).equals(UserDetailsNDbNAme)) {
                    arraylist1.add(dataSnapshot.child("propertytype").getValue(String.class));
                    }

//                Log.d("myData Check", dataSnapshot.child("propertytype").getValue(String.class));
//                Log.d("myData Check name", dataSnapshot.child("propertyowner").getValue(String.class));
//                arraylist1.add(dataSnapshot.getValue(String.class).toString());
                Log.d("myData   list", String.valueOf(arraylist1));

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("onCancelled", "onCancelled", databaseError.toException());
            }
        });

    }
}
