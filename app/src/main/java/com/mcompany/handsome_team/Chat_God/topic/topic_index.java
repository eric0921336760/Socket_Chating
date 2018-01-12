package com.mcompany.handsome_team.Chat_God.topic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mcompany.handsome_team.Chat_God.R;

public class topic_index extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topic_index);
    }

    public void topic_add(View v){
        Intent it= new Intent();
        it.setClass(this,topic_add.class);
        startActivity(it);
    }

    public void topic_chat(View v){
        Intent it= new Intent();
        it.setClass(this,topic_chat.class);
        startActivity(it);
    }


}
