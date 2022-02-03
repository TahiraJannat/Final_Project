package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class PropertyEditNew extends AppCompatActivity {
    EditText propertyType, propertySize, propertyPrice, propertyBathroom, propertyLocation;
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = firebaseDatabase.getReference("Tahira/Property");
    String UserDetailsNDbNAme;
    List<String> arraylist1= new ArrayList<String>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.propertyeditnew);

        getSupportActionBar().setTitle("Property List");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        UserDetailsNDbNAme = getIntent().getStringExtra("UserDetailsNDbNAme");

        propertyType =findViewById(R.id.property_type);

//        List<String> arraylist1= new ArrayList<String>();

        List<String> arraylist1=(ArrayList<String>) getIntent().getSerializableExtra("propertyList");


        ListView listView = (ListView) findViewById(R.id.listview);
        final TextView textView = (TextView) findViewById(R.id.textview);
//
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arraylist1);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                textView.setText("Selected Property: " + selectedItem);
            }
        });



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