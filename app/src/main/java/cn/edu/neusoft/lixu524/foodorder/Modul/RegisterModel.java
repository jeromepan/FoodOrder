package cn.edu.neusoft.lixu524.foodorder.Modul;

import cn.edu.neusoft.lixu524.foodorder.Bean.RegisterBean;
import cn.edu.neusoft.lixu524.foodorder.Iface.RegisterIface;
import cn.edu.neusoft.lixu524.foodorder.Listener.TListener;
import cn.edu.neusoft.lixu524.foodorder.Service.Service;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by www44 on 2017/11/13.
 */

public class RegisterModel extends BaseModel implements RegisterIface<RegisterBean> {
    Service service;
    Retrofit retrofit;

    public RegisterModel(){
        retrofit=getRetrofit();
    }


    @Override
    public void getReglist(String username, String password, String mobilenum, String address, String comment, TListener<RegisterBean> tListener) {
        service=getService();
        Call<RegisterBean> call = service.getRegmessage(username,password,mobilenum,address,comment);
        callenqueue(call,tListener);
    }
}
