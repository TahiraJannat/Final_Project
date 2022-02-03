package com.example.final_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Dashboardcopy extends AppCompatActivity implements View.OnClickListener {
    GridLayout gridLayout;
    TextView user_name_dashboard;
    String dashBoadrdUserDetails;
    String UserDetailsNDbNAme;

    private  CardView addProperty, editProperty, purchaseProperty, userDetails, messageBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        user_name_dashboard = findViewById(R.id.user_name_dashboard);

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


        user_name_dashboard.setText(dashBoadrdUserName);

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

            case R.id.edit_property: i = new Intent(this, PropertyEditNew.class)
                    .putExtra("UserDetailsNDbNAme",UserDetailsNDbNAme.toString()); startActivity(i);break;

            case R.id.purchase_property: i = new Intent(this, PurchaseProperty.class); startActivity(i);break;
            case R.id.user_details: i =
                    new Intent(Dashboardcopy.this, UserDetails.class).
                            putExtra("UserDetails", dashBoadrdUserDetails.toString()).
                            putExtra("UserDetailsNDbNAme",UserDetailsNDbNAme.toString());
            startActivity(i);break;
            default:break;
        }

    }
}
