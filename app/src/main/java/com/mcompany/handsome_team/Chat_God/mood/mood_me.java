package com.mcompany.handsome_team.Chat_God.mood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mcompany.handsome_team.Chat_God.Myactivity.MyActivity;
import com.mcompany.handsome_team.Chat_God.R;

public class mood_me extends MyActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mood_me);
    }

    public void mood_me(View v){
        Intent it= new Intent();
        it.setClass(this,mood_me.class);
        startActivity(it);
    }

    public void mood_new(View v){
        Intent it= new Intent();
        it.setClass(this,mood_new.class);
        startActivity(it);
    }

    public void mood_friend(View v){
        Intent it= new Intent();
        it.setClass(this,mood_friend.class);
        startActivity(it);
    }
}
