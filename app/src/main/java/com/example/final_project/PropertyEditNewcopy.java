package com.example.final_project;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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

public class PropertyEditNewcopy extends AppCompatActivity {
    EditText propertyType, propertySize, propertyPrice, propertyBathroom, propertyLocation;
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = firebaseDatabase.getReference("Tahira/Property");
    String UserDetailsNDbNAme;
    List<String> arraylist1= new ArrayList<String>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.propertyeditnew);

        UserDetailsNDbNAme = getIntent().getStringExtra("UserDetailsNDbNAme");

        propertyType =findViewById(R.id.property_type);

        Log.d("mystart", "Checking data ");

        checkProperty();
        Log.d("mystartend", "Checking end ");




        Log.d("mystartend", String.valueOf(arraylist1));


//        ListView listView = (ListView) findViewById(R.id.listview);
//        final TextView textView = (TextView) findViewById(R.id.textview);
//        String[] players = new String[] {"CR7", "Messi", "Hazard", "Neymar"};
//        List<String> Players_list = new ArrayList<String>(Arrays.asList(players));
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Players_list);
//        listView.setAdapter(arrayAdapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String selectedItem = (String) parent.getItemAtPosition(position);
//                textView.setText("The best football player is : " + selectedItem);
//            }
//        });

//        checkProperty();

    }
    private void checkProperty() {
        Log.d("myData", "Checking data ");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                Log.d("myData", String.valueOf(dataSnapshot));
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    String uid = ds.getKey();
                    Log.d("myData", String.valueOf(uid));
                    getPropertyData(uid);

                }

                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        // this code will be executed after 2 seconds
                        Log.d("my", "loop over"+arraylist1);
                        String[] stockArr = new String[arraylist1.size()];
                        stockArr = arraylist1.toArray(stockArr);

                        for(String s : stockArr){
                            Log.d("myafterloop", "loop over"+s);

                        }

//                        addPropertyToList(arraylist1);
//                        addPropertyToList();
                    }
                }, 2000);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("blabla1", "onCancelled", databaseError.toException());
            }
        });
    }


    private void getPropertyData(String propertyChild) {
        Log.d("myData ok", String.valueOf("Ok"));
        DatabaseReference child = databaseReference.child(propertyChild);
        DatabaseReference childProperty = child.child("propertytype");
        Log.w("myLast", String.valueOf(childProperty.orderByKey().limitToLast(1)));
        Query query = childProperty.orderByKey().limitToLast(1);
        Log.w("myLastQ", String.valueOf(query));


        childProperty.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Log.d("myData Che ck", dataSnapshot.getValue(String.class));
                arraylist1.add(dataSnapshot.getValue(String.class).toString());
                Log.d("myData   list", String.valueOf(arraylist1));

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("onCancelled", "onCancelled", databaseError.toException());
            }
        });

    }

    public void addPropertyToList(){
        ListView listView = (ListView) findViewById(R.id.listview);
        final TextView textView = (TextView) findViewById(R.id.textview);
        String[] players = new String[] {"CR7", "Messi", "Hazard", "Neymar"};
        List<String> Players_list = new ArrayList<String>(Arrays.asList(players));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Players_list);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                textView.setText("The best football player is : " + selectedItem);
            }
        });
    }
}