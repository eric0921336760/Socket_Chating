package com.mcompany.handsome_team.Chat_God.multiple_chat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.mcompany.handsome_team.Chat_God.MainActivity;
import com.mcompany.handsome_team.Chat_God.MyService;
import com.mcompany.handsome_team.Chat_God.Myactivity.MyActivity;
import com.mcompany.handsome_team.Chat_God.R;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class multiple_chatview extends MyActivity {

    multiple_chatviewBroadcastReceiver receiver ;
    EditText edttxt;
    TextView chatbox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiple_chatview);
        edttxt=(EditText)findViewById(R.id.editText11);
        chatbox=(TextView) findViewById(R.id.textView19);
        //注册接收器
        receiver=new multiple_chatviewBroadcastReceiver();
        IntentFilter filter=new IntentFilter();
        filter.addAction("GroupMsg");
        registerReceiver(receiver,filter);
    }

    public class multiple_chatviewBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals("GroupMsg")){
                Log.d("我是GroupBR"  , "我聽到了喔");
                String s = intent.getStringExtra("msg");
                String tmp = chatbox.getText().toString();
                chatbox.setText( tmp+"\n"+s);
            }
        }
    }

    public void GroupChat_Send(View v){
        Intent intent = new Intent();
        intent.setAction("GroupChat_Send");
        intent.putExtra("Message",edttxt.getText().toString());
        sendBroadcast(intent);
        edttxt.setText("");
    }

}
