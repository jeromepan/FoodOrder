package cn.edu.neusoft.lixu524.foodorder.Modul;

import cn.edu.neusoft.lixu524.foodorder.Bean.RegisterBean;
import cn.edu.neusoft.lixu524.foodorder.Bean.UserBean;
import cn.edu.neusoft.lixu524.foodorder.Iface.CommentDelIface;
import cn.edu.neusoft.lixu524.foodorder.Iface.UserIface;
import cn.edu.neusoft.lixu524.foodorder.Listener.TListener;
import cn.edu.neusoft.lixu524.foodorder.Service.Service;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by www44 on 2017/11/1.
 */

public class CommentDelModel extends BaseModel implements CommentDelIface<RegisterBean> {
    Service service;
    Retrofit retrofit;

    public CommentDelModel(){
        retrofit=getRetrofit();
    }

    @Override
    public void getDelMeg(int order_id, TListener<RegisterBean> tListener) {
        service=getService();
        Call<RegisterBean> call = service.getdelCommentMeg(order_id);
        callenqueue(call,tListener);
    }
}
