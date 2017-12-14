package cn.edu.neusoft.lixu524.foodorder.Modul;

import cn.edu.neusoft.lixu524.foodorder.Bean.LoginBean;
import cn.edu.neusoft.lixu524.foodorder.Iface.LoginIface;
import cn.edu.neusoft.lixu524.foodorder.Listener.TListener;
import cn.edu.neusoft.lixu524.foodorder.Server;
import cn.edu.neusoft.lixu524.foodorder.Service.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by www44 on 2017/11/1.
 */

public class LoginModul extends BaseModel implements LoginIface<LoginBean> {
    Service service;
    Retrofit retrofit;

    public LoginModul(){
        retrofit=getRetrofit();
    }

    @Override
    public void getUserList(String username, String password, final TListener<LoginBean> tListener) {
        service=getService();
        Call<LoginBean> call = service.getAddress(username,password);
        callenqueue(call,tListener);
    }
}
