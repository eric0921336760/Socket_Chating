package com.mcompany.handsome_team.Chat_God.multiple_chat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mcompany.handsome_team.Chat_God.Myactivity.MyActivity;
import com.mcompany.handsome_team.Chat_God.R;

public class multiple_chatlist extends MyActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiple_chatlist);
    }

    public void multiple_chatview(View v){
        Intent it= new Intent();
        it.setClass(this,multiple_chatview.class);
        startActivity(it);
    }


}
