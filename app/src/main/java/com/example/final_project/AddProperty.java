
package com.example.final_project;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.text.TextUtils;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
        import android.widget.CheckBox;
        import android.widget.EditText;
        import android.widget.ProgressBar;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.google.android.gms.tasks.OnFailureListener;
        import com.google.android.gms.tasks.OnSuccessListener;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;

        import java.util.HashMap;
        import java.util.Map;

public class AddProperty extends AppCompatActivity {

    EditText propertyType, propertySize, propertyPrice, propertyBathroom, propertyLocation;
    CheckBox propertyBalcony, propertyGarage, propertyPool;
    Button addProperty;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    String UserDetailsNDbNAme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addproperty);

        UserDetailsNDbNAme = getIntent().getStringExtra("UserDetailsNDbNAme");


        getSupportActionBar().setTitle("Add Property");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        propertyType = findViewById(R.id.property_type);
        propertySize = findViewById(R.id.property_size);
        propertyPrice = findViewById(R.id.property_price);
        propertyBathroom = findViewById(R.id.property_bathroom);
        propertyLocation = findViewById(R.id.property_location);
        propertyBalcony = (CheckBox)findViewById(R.id.property_balcony);
        propertyGarage = (CheckBox)findViewById(R.id.property_garage);
        propertyPool = (CheckBox)findViewById(R.id.property_pool);
        addProperty = findViewById(R.id.add_property);


        addProperty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processinsert();
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void processinsert() {
        Map<String,Object>map = new HashMap();
        map.put("propertyowner", UserDetailsNDbNAme.toString());
        map.put("propertytype", propertyType.getText().toString());
        map.put("propertysize", propertySize.getText().toString());
        map.put("propertyprice", propertyPrice.getText().toString());
        map.put("propertybathroom", propertyBathroom.getText().toString());
        map.put("propertylocation", propertyLocation.getText().toString());
        map.put("propertybalcony", propertyBalcony.getText().toString());
        map.put("propertygarage", propertyGarage.getText().toString());
        map.put("propertypool", propertyPool.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("Tahira/Property").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        propertyType.setText("");
                        propertySize.setText("");
                        propertyPrice.setText("");
                        propertyBathroom.setText("");
                        propertyLocation.setText("");
                        propertyBalcony.setText("");
                        propertyGarage.setText("");
                        propertyPool.setText("");


                        Intent intent = new Intent(getApplicationContext(),Dashboard.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "Added Succesfully", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(getApplicationContext(), "Could not insert", Toast.LENGTH_SHORT).show();
                    }
                });

    }

//    public void addPropertyclick(View view) {
//        Intent intent = new Intent(getApplicationContext(), Login.class);
//        startActivity(intent);
//    }

//    public void addPropertyclick(View view) {
//        String propertytype = propertyType.getText().toString();
//        String propertysize = propertySize.getText().toString();
//        String propertyprice = propertyPrice.getText().toString();
//        String propertybathroom = propertyBathroom.getText().toString();
//        String propertylocation = propertyLocation.getText().toString();
//        String propertybalcony = propertyBalcony.getText().toString();
//        String propertygarage = propertyGarage.getText().toString();
//        String propertypool = propertyPool.getText().toString();
//
//        if (!propertytype.isEmpty()) {
//            propertyType.setError(null);
//
//            if (!propertysize.isEmpty()) {
//                propertySize.setError(null);
//
//                if (!propertyprice.isEmpty()) {
//                    propertyBathroom.setError(null);
//
//                    if (!propertybathroom.isEmpty()) {
//                        propertyPrice.setError(null);
//                        firebaseDatabase = FirebaseDatabase.getInstance();
//                        reference = firebaseDatabase.getReference("Tahira/Property");
//
//                        String propertytype_s = propertyType.getText().toString().trim();
//                        String propertysize_s = propertySize.getText().toString().trim();
//                        String propertybathroom_s = propertyPrice.getText().toString().trim();
//                        String propertyprice_s = propertyBathroom.getText().toString().trim();
//
//                        DataStorage dataStorage = new DataStorage(propertytype_s,propertysize_s,propertyprice_s,propertybathroom_s);
//                        reference.child(propertytype_s).setValue(dataStorage);
//                        Toast.makeText(getApplicationContext(),"register succesfully",Toast.LENGTH_SHORT).show();
//
//                        Intent intent = new Intent(getApplicationContext(),Dashboard.class);
//                        startActivity(intent);
//                        finish();
//
//                    } else {
//                        propertyPrice.setError("Please Enter The Birth");
//
//                    }
//                } else {
//                    propertyBathroom.setError("Please Enter The propertybathroom");
//
//                }
//            } else {
//                propertySize.setError("Please Enter The propertysize");
//
//            }
//
//        } else {
//            propertyType.setError("Please Enter propertytype");
//
//        }
//
//    }
}