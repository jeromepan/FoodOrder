package cn.edu.neusoft.lixu524.foodorder.Modul;

import java.util.List;

import cn.edu.neusoft.lixu524.foodorder.Bean.GetCollectBean;
import cn.edu.neusoft.lixu524.foodorder.Bean.IsCollectBean;
import cn.edu.neusoft.lixu524.foodorder.Iface.GetCollectedIface;
import cn.edu.neusoft.lixu524.foodorder.Iface.IsCollectedIface;
import cn.edu.neusoft.lixu524.foodorder.Listener.ListListener;
import cn.edu.neusoft.lixu524.foodorder.Listener.TListener;
import cn.edu.neusoft.lixu524.foodorder.Service.Service;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by www44 on 2017/11/1.
 */

public class GetCollectedModel extends BaseModel implements GetCollectedIface<GetCollectBean> {
    Service service;
    Retrofit retrofit;

    public GetCollectedModel(){
        retrofit=getRetrofit();
    }

    @Override
    public void getcollectMsg(int user_id, int flag, ListListener<GetCollectBean> listListener) {
        service=getService();
        Call<List<GetCollectBean>> call = service.getCollect(user_id,flag);
        callenqueueList(call,listListener);
    }
}
