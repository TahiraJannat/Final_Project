//package com.example.final_project;
//
//import android.text.format.DateUtils;
//import android.view.View;
//import android.widget.TextView;
//
//import androidx.recyclerview.widget.RecyclerView;
//
//public class SentMessageHolder extends RecyclerView.ViewHolder {
//    TextView messageText, timeText;
//    private DateUtils Utils;
//
//    SentMessageHolder(View itemView) {
//        super(itemView);
//
//        messageText = (TextView) itemView.findViewById(R.id.text_message_body);
//        timeText = (TextView) itemView.findViewById(R.id.text_message_time);
//    }
//
//    void bind(DataStorage message) {
//        messageText.setText(message.getMessage());
//
//        // Format the stored timestamp into a readable String using method.
//        timeText.setText(Utils.formatDateTime(message.getCreatedAt()));
//    }
//}
