package cn.edu.neusoft.lixu524.foodorder.Activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import cn.edu.neusoft.lixu524.foodorder.R;

public abstract class BaseActivity extends AppCompatActivity {
    protected int layout_file = R.layout.activity_main;

    abstract void initView();
    abstract void initEvent();
    abstract void initData();
    void setLayout_file(int layout_file){
        setContentView(layout_file);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayout_file(layout_file);
        initView();
        initEvent();
        initData();
    }
    public String getUser_id(){
        SharedPreferences sp;
        sp = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        return sp.getString("id","");
    }
    //获取保存的用户名
    public String getUser_name(){
        SharedPreferences sp;
        sp = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        return sp.getString("username","");
    }
    //获取保存的密码
    public String getUser_password(){
        SharedPreferences sp;
        sp = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        return sp.getString("userpass","");
    }
    public boolean getUser_remember(){
        SharedPreferences sp;
        sp = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        return sp.getBoolean("remember",false);
    }
    public void showToast(String content){
        Toast.makeText(this,content,Toast.LENGTH_SHORT).show();
    }
}
