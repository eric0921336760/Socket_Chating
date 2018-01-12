package com.mcompany.handsome_team.Chat_God;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mcompany.handsome_team.Chat_God.Myactivity.MyActivity;
import com.mcompany.handsome_team.Chat_God.find.find_new_friend;
import com.mcompany.handsome_team.Chat_God.mood.mood_me;
import com.mcompany.handsome_team.Chat_God.multiple_chat.multiple_chatview;
import com.mcompany.handsome_team.Chat_God.topic.topic_index;

public class MainActivity extends MyActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    //Intent to other Activity
    public void onbuttonclick(View v){
        Intent it= new Intent();
        it.setClass(this,find_new_friend.class);
        startActivity(it);
    }

    public void people_list(View v){
        Intent it= new Intent();
        it.setClass(this,people_list.class);
        startActivity(it);
    }

    public void single_chat(View v){
        Intent it= new Intent();
        it.setClass(this,single_chat.class);
        startActivity(it);
    }

    public void multiple_chat_index(View v){
        Intent it= new Intent();
        it.setClass(this,multiple_chatview.class);
        startActivity(it);
    }

    public void topic_index(View v){
        Intent it= new Intent();
        it.setClass(this,topic_index.class);
        startActivity(it);
    }

    public void mood_me(View v){
        Intent it= new Intent();
        it.setClass(this,mood_me.class);
        startActivity(it);
    }

    public void Service_Control(View v){
        Intent intent = new Intent(MainActivity.this,MyService.class);
        stopService(intent);
    }
    public void Service_Check(View v){
        if(isServiceRunning()){
            Toast.makeText(this, "Service still running", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Service closed", Toast.LENGTH_SHORT).show();
        }
    }
}
