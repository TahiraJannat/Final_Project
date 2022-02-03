//package com.example.final_project;
//
//import android.os.Bundle;
//import android.util.Log;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//
//import java.util.ArrayList;
//
//public class EditProperty extends AppCompatActivity {
//
//    RecyclerView recyclerView;
//    DatabaseReference databaseReference;
//    MyAdapter myAdapter;
//    ArrayList<DataStorage> list;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.editproperty);
//        getSupportActionBar().setTitle("Edit Property");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        recyclerView = findViewById(R.id.property_list);
//        databaseReference = FirebaseDatabase.getInstance().getReference("Tahira/Property");
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        list = new ArrayList<>();
//        myAdapter = new MyAdapter(this,list);
//        recyclerView.setAdapter(myAdapter);
//
//
//        DataStorage[] DataStorage = new DataStorage[]{
//                new DataStorage("propertytype")
////               Log.d("myPropertyType",propertytype);
//        };
//
//
//
//
//
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                DataSnapshot dataSnapshot = null;
//                Log.d("myData Che ck", dataSnapshot.getValue(String.class));
////                Log.d("myData   list", String.valueOf(arraylist1));
////                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
////                    DataStorage propertyData = dataSnapshot.getValue(DataStorage.class);
////                    list.add(propertyData);
////                }
//                myAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//
//    }
//
//
//}