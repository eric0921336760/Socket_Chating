package com.mcompany.handsome_team.Chat_God.multiple_chat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mcompany.handsome_team.Chat_God.Myactivity.MyActivity;
import com.mcompany.handsome_team.Chat_God.R;

public class multiple_chat_index extends MyActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiple_chat_index);
    }

    public void multiple_chat_new(View v){
        Intent it= new Intent();
        it.setClass(this,multiple_chat_new.class);
        startActivity(it);
    }

    public void multiple_chatlist(View v){
        Intent it= new Intent();
        it.setClass(this,multiple_chatlist.class);
        startActivity(it);
    }



}
