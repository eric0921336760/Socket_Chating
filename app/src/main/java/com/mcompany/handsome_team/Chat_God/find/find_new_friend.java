package com.mcompany.handsome_team.Chat_God.find;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mcompany.handsome_team.Chat_God.Myactivity.MyActivity;
import com.mcompany.handsome_team.Chat_God.R;

public class find_new_friend extends MyActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_new_friend);
    }

    public void onbuttonclick1(View v){
        Intent it= new Intent();
        it.setClass(this,find_id.class);
        startActivity(it);
    }

    public void onbuttonclick2(View v){
        Intent it= new Intent();
        it.setClass(this,find_random.class);
        startActivity(it);
    }

    public void onbuttonclick3(View v){
        Intent it= new Intent();
        it.setClass(this,find_near.class);
        startActivity(it);
    }
}
