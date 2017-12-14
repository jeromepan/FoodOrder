package cn.edu.neusoft.lixu524.foodorder.Modul;

import java.util.List;

import cn.edu.neusoft.lixu524.foodorder.Bean.FoodDetailBean;
import cn.edu.neusoft.lixu524.foodorder.Iface.FoodDetailIface;
import cn.edu.neusoft.lixu524.foodorder.Listener.ListListener;
import cn.edu.neusoft.lixu524.foodorder.Listener.TListener;
import cn.edu.neusoft.lixu524.foodorder.Service.Service;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by www44 on 2017/11/1.
 */

public class FoodDetailModel extends BaseModel implements FoodDetailIface<FoodDetailBean> {
    Service service;
    Retrofit retrofit;

    public FoodDetailModel(){
        retrofit=getRetrofit();
    }


    @Override
    public void getFoodMeg(int food_id, TListener<FoodDetailBean> tListener) {
        service=getService();
        Call<FoodDetailBean> call = service.getFooddetail(food_id);
        callenqueue(call,tListener);
    }
}
