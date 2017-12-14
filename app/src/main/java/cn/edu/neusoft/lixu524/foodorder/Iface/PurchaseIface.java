package cn.edu.neusoft.lixu524.foodorder.Iface;

import cn.edu.neusoft.lixu524.foodorder.Listener.TListener;

/**
 * Created by www44 on 2017/12/10.
 */

public interface PurchaseIface<T> {
    void getPurchaseMsg(int user_id,int food_id,int num,double sum,String suggesttion,TListener<T> tListener);
}
