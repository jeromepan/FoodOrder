package cn.edu.neusoft.lixu524.foodorder.Modul;

import java.util.List;

import cn.edu.neusoft.lixu524.foodorder.Bean.FoodListBean;
import cn.edu.neusoft.lixu524.foodorder.Bean.OrderBean;
import cn.edu.neusoft.lixu524.foodorder.Iface.FoodIface;
import cn.edu.neusoft.lixu524.foodorder.Iface.OrderIface;
import cn.edu.neusoft.lixu524.foodorder.Listener.ListListener;
import cn.edu.neusoft.lixu524.foodorder.Service.Service;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by www44 on 2017/11/1.
 */

public class OrderModel extends BaseModel implements OrderIface<OrderBean> {
    Service service;
    Retrofit retrofit;

    public OrderModel(){
        retrofit=getRetrofit();
    }

    @Override
    public void getOrderMeg(int user_id, ListListener<OrderBean> listListener) {
        service=getService();
        Call<List<OrderBean>> call = service.getOrderMeg(user_id);
        callenqueueList(call,listListener);
    }
}
