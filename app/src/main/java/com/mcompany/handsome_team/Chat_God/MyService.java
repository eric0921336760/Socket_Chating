package com.mcompany.handsome_team.Chat_God;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

import static com.mcompany.handsome_team.Chat_God.Myactivity.MyActivity.User_NickName;

public class MyService extends Service {
    boolean flag;
    BufferedWriter bw;
    String tmp;                // 暫存文字訊息
    Socket clientSocket;
    MyServiceBroadcastReceiver receiver;
    public MyService() {
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public void onStart(Intent intent, int startId) {
        Toast.makeText(this, "Service start", Toast.LENGTH_SHORT).show();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        flag=intent.getBooleanExtra("flag", true);
        new Thread(readData).start();

        receiver=new MyServiceBroadcastReceiver();
        IntentFilter filter=new IntentFilter();
        filter.addAction("GroupChat_Send");
        registerReceiver(receiver,filter);

        return super.onStartCommand(intent, flags, startId);
    }

    public void onDestroy(){
        flag=false;
        super.onDestroy();
        Toast.makeText(this, "Service stop", Toast.LENGTH_SHORT).show();
    }

    public class MyServiceBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals("GroupChat_Send")) {
                String s= intent.getStringExtra("Message");
                if(clientSocket.isConnected()){
                    try {
                        // 取得網路輸出串流
                        bw = new BufferedWriter( new OutputStreamWriter(clientSocket.getOutputStream()));
                        // 寫入訊息
                        bw.write(User_NickName+"  : "+s+"\n");
                        Thread t1 = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    bw.flush();
                                    // 立即發送
                                }catch (IOException e){
                                }
                            }
                        });
                        t1.start();
                    } catch (IOException e) {
                    }
                }
            }
        }
    }

    // 取得網路資料
    public Runnable readData = new Runnable() {
        public void run() {
            // server端的IP
            InetAddress serverIp;
            try {
                // 以內定(本機電腦端)IP為Server端
                serverIp = InetAddress.getByName("10.201.2.30");
                int serverPort = 5050;
                clientSocket = new Socket(serverIp, serverPort);

                // 取得網路輸入串流
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        clientSocket.getInputStream()));

                while (clientSocket.isConnected()) {

                    // 取得網路訊息
                    tmp = br.readLine();

                    // 如果不是空訊息則
                    if(tmp!=null){

                        Intent intent = new Intent();
                        intent.putExtra("msg",tmp);
                        intent.setAction("GroupMsg");
                        sendBroadcast(intent);
                        //發送廣播！
                    }
                }
            }catch (Exception e) {
            }
        }
    };
}
