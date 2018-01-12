package com.mcompany.handsome_team.Chat_God;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mcompany.handsome_team.Chat_God.Myactivity.MyActivity;

public class register extends MyActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
    }


    public void onbuttonclick(View v){
        Intent it= new Intent();
        it.setClass(this,MainActivity.class);
        startActivity(it);
        finish();
        login.instance.finish();
    }
}
