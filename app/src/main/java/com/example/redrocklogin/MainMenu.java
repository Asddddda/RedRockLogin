package com.example.redrocklogin;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainMenu extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        Button button_sign_up = (Button) findViewById(R.id.sign_up_main);
        Button button_login_account = (Button) findViewById(R.id.account);
        Button button_login_xinlang = (Button) findViewById(R.id.xinlang);
        Button button_login_tengxun = (Button) findViewById(R.id.tengxun);
        button_login_account.setOnClickListener(this);
        button_login_xinlang.setOnClickListener(this);
        button_login_tengxun.setOnClickListener(this);
        button_sign_up.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_up_main:
                Intent intent_sign_up_main = new Intent(MainMenu.this, SignUpActivity.class);
                startActivityForResult(intent_sign_up_main, 1);
                break;
            case R.id.xinlang:
                Intent intent_xinlang = new Intent(Intent.ACTION_VIEW);
                intent_xinlang.setData(Uri.parse("https://weibo.com"));
                startActivity(intent_xinlang);
                break;
            case R.id.tengxun:
                Toast.makeText(MainMenu.this,"腾讯微博登陆",Toast.LENGTH_SHORT).show();
                onStart();
                break;
            case R.id.account:
                Intent intent_login = new Intent(MainMenu.this, LoginActivity.class);
                startActivityForResult(intent_login, 1);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:
                if(resultCode==RESULT_OK){
                    String returned_data=data.getStringExtra("data_return");
                    Toast.makeText(MainMenu.this,returned_data,Toast.LENGTH_SHORT).show();
                }
        }
    }
}
