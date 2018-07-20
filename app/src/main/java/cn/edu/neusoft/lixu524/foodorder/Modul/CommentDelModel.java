package cn.edu.neusoft.lixu524.foodorder.Modul;

import java.util.List;

import cn.edu.neusoft.lixu524.foodorder.Bean.FoodListBean;
import cn.edu.neusoft.lixu524.foodorder.Bean.PurchaseBean;
import cn.edu.neusoft.lixu524.foodorder.Bean.UserBean;
import cn.edu.neusoft.lixu524.foodorder.Iface.FoodIface;
import cn.edu.neusoft.lixu524.foodorder.Iface.UserIface;
import cn.edu.neusoft.lixu524.foodorder.Listener.ListListener;
import cn.edu.neusoft.lixu524.foodorder.Listener.TListener;
import cn.edu.neusoft.lixu524.foodorder.Service.Service;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by www44 on 2017/11/1.
 */

public class UserModel extends BaseModel implements UserIface<UserBean> {
    Service service;
    Retrofit retrofit;

    public UserModel(){
        retrofit=getRetrofit();
    }

    @Override
    public void getUserMeg(int user_id, TListener<UserBean> tListener) {
        service=getService();
        Call<UserBean> call = service.getUserMeg(user_id);
        callenqueue(call,tListener);
    }
}
