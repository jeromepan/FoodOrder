package cn.edu.neusoft.lixu524.foodorder.Modul;

import java.util.List;

import cn.edu.neusoft.lixu524.foodorder.Bean.ShopListBean;
import cn.edu.neusoft.lixu524.foodorder.Iface.ShopIface;
import cn.edu.neusoft.lixu524.foodorder.Listener.ListListener;
import cn.edu.neusoft.lixu524.foodorder.Service.Service;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by www44 on 2017/11/1.
 */

public class ShopModel extends BaseModel implements ShopIface<ShopListBean> {
    Service service;
    Retrofit retrofit;

    public ShopModel(){
        retrofit=getRetrofit();
    }

    @Override
    public void getShopMeg(ListListener<ShopListBean> listListener) {
        service=getService();
        Call<List<ShopListBean>> call = service.getShoplist();
        callenqueueList(call,listListener);
    }
}
