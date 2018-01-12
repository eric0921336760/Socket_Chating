package com.mcompany.handsome_team.Chat_God.Myactivity;

import android.app.ActivityManager;
import android.support.v7.app.AppCompatActivity;

public class MyActivity extends AppCompatActivity {

    static public String User_NickName;

    public boolean isServiceRunning() {
        ActivityManager manager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)){
            if("com.mcompany.handsome_team.Chat_God.MyService".equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

}
