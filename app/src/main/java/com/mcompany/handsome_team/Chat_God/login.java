package com.mcompany.handsome_team.Chat_God;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.mcompany.handsome_team.Chat_God.Myactivity.MyActivity;

public class login extends MyActivity {

    public static login instance = null;
    EditText account;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        instance = this;

        account = (EditText)findViewById(R.id.editText);

        if(!isServiceRunning()){
            Intent intent = new Intent(login.this,MyService.class);
            startService(intent);
        }



    }


    public void onbuttonclick(View v){
        User_NickName = account.getText().toString();
        Intent it= new Intent();
        it.setClass(this,MainActivity.class);
        startActivity(it);
        finish();
    }

    public void onbuttonclick2(View v){
        Intent it= new Intent();
        it.setClass(this,register.class);
        startActivity(it);
    }
}
