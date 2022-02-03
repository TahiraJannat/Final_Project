//package com.example.final_project;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.EditText;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//import androidx.recyclerview.widget.RecyclerView.ViewHolder;
//
//import com.google.firebase.firestore.auth.User;
//
//import java.util.ArrayList;
//
//public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyviewHolder> {
//    Context context;
//
//    ArrayList<DataStorage> list;
//
//
//
//    public MyAdapter(Context context, ArrayList<DataStorage> list) {
//        this.context = context;
//        this.list = list;
//    }
//
////    public MyAdapter(DataStorage[] myListData) {
////    }
//
//    @NonNull
//    @Override
//    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(context).inflate(R.layout.propertylist,parent,false);
//        return new MyviewHolder(v);
////        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
////        View listItem= layoutInflater.inflate(R.layout.propertylist, parent, false);
//
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
//
//        DataStorage data = list.get(position);
//        holder.ePropertyType.setText(data.getPropertytype());
//        holder.ePropertySize.setText(data.getPropertysize());
//        holder.ePropertyPrice.setText(data.getPropertyprice());
//        holder.ePropertyBathroom.setText(data.getPropertybathroom());
//        holder.ePropertyLocation.setText(data.getPropertylocation());
//        holder.ePropertyBalcony.setText(data.getPropertybalcony());
//        holder.ePropertyGarage.setText(data.getPropertygarage());
//        holder.ePropertyPool.setText(data.getPropertypool());
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//    public static class MyviewHolder extends RecyclerView.ViewHolder{
//
//        EditText ePropertyType, ePropertySize, ePropertyPrice, ePropertyBathroom,
//                ePropertyLocation, ePropertyBalcony, ePropertyGarage, ePropertyPool;
//
//        public MyviewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            ePropertyType = itemView.findViewById(R.id.eProperty_type);
//            ePropertySize = itemView.findViewById(R.id.eProperty_size);
//            ePropertyPrice = itemView.findViewById(R.id.eProperty_price);
//            ePropertyBathroom = itemView.findViewById(R.id.eProperty_bathroom);
//            ePropertyLocation = itemView.findViewById(R.id.eProperty_location);
//            ePropertyBalcony = itemView.findViewById(R.id.eProperty_balcony);
//            ePropertyGarage = itemView.findViewById(R.id.eProperty_garage);
//            ePropertyPool = itemView.findViewById(R.id.eProperty_pool);
//        }
//    }
//
//}
