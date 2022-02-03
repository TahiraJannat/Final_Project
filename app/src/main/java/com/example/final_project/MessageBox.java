//package com.example.final_project;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.os.Bundle;
//
//import java.util.List;
//
//public class MessageBox extends AppCompatActivity {
//    private RecyclerView mMessageRecycler;
//    private MessageListAdapter mMessageAdapter;
//    private List<UserModel> messageList;
//
//    @Override
//
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.messagebox);
//
//        mMessageRecycler = (RecyclerView) findViewById(R.id.recycler_gchat);
//        mMessageAdapter = new MessageListAdapter(this, messageList);
//        mMessageRecycler.setLayoutManager(new LinearLayoutManager(this));
//        mMessageRecycler.setAdapter(mMessageAdapter);
//    }
//}