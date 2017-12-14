package cn.edu.neusoft.lixu524.foodorder.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cn.edu.neusoft.lixu524.foodorder.Bean.LoginBean;
import cn.edu.neusoft.lixu524.foodorder.Listener.TListener;
import cn.edu.neusoft.lixu524.foodorder.Modul.LoginModul;
import cn.edu.neusoft.lixu524.foodorder.R;

import static cn.edu.neusoft.lixu524.foodorder.Server.BOOL_FLAG;
import static cn.edu.neusoft.lixu524.foodorder.Server.user_id_remember;

public class LoginActivity extends BaseActivity {
    EditText et_user,et_password;
    Button btn_login;
    TextView tv_register;
    String username,userpass;
    CheckBox checkBox;
    String userid;

    public void initView(){
        setLayout_file(R.layout.activity_login);
        et_user = (EditText)findViewById(R.id.editText_user);
        et_password = (EditText)findViewById(R.id.editText_password);
        btn_login = (Button)findViewById(R.id.button_login);
        tv_register = (TextView)findViewById(R.id.register);
        checkBox = (CheckBox)findViewById(R.id.checkBox);

        boolean check=getUser_remember();
        String receive = getIntent().getStringExtra("username");

        if(check){
            username = getUser_name();
            userpass = getUser_password();
            et_user.setText(username);
            et_password.setText(userpass);
        }

        if(BOOL_FLAG) {
            et_user.setText(receive);
            et_password.setText("");
            BOOL_FLAG=false;
        }
        et_user.setSelection(et_user.getText().length());
        et_password.setSelection(et_password.getText().length());
    }

    @Override
    void initEvent() {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_user.getText().toString().trim().equals("")||et_password.getText().toString().trim().equals("")){
                    Toast.makeText(LoginActivity.this,"用户名和密码不能为空",Toast.LENGTH_SHORT).show();
                }
                else{
                    TListener<LoginBean> tListener = new TListener<LoginBean>() {
                        @Override
                        public void onResponse(LoginBean loginBean) {
                            userid = loginBean.getUserid().toString();
                            user_id_remember= Integer.parseInt(userid);
//                            Toast.makeText(LoginActivity.this,"用户id:"+userid,Toast.LENGTH_SHORT).show();
                            if(loginBean.getUserid().toString().equals("0")){
                                Toast.makeText(LoginActivity.this,"登陆失败",Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(LoginActivity.this,"登陆成功",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent();
                                intent.setClass(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        }

                        @Override
                        public void onFail(String msg) {
                            Toast.makeText(LoginActivity.this,"登陆失败",Toast.LENGTH_SHORT).show();
                        }
                    };
                    //先到服务器判断用户名密码信息是否存在再决定是否保存
                    String username = et_user.getText().toString();
                    String password = et_password.getText().toString();
                    LoginModul loginModul = new LoginModul();
                    loginModul.getUserList(username,password,tListener);

                    if(checkBox.isChecked()){
                        saveUser();
                    }
                }
            }
        });
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    void initData() {

    }

    //保存用户名和密码
    public void saveUser(){
        SharedPreferences sp = getSharedPreferences("userInfo",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("username",et_user.getText().toString());
        editor.putString("userpass",et_password.getText().toString());
        editor.putBoolean("remember",checkBox.isChecked());
        editor.putString("id",userid);
//        showToast(userid);
        editor.commit();
    }
}
