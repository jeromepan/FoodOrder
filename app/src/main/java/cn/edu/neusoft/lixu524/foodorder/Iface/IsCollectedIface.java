package cn.edu.neusoft.lixu524.foodorder.Iface;

import cn.edu.neusoft.lixu524.foodorder.Listener.TListener;

/**
 * Created by www44 on 2017/12/10.
 */

public interface IsCollectedIface<T> {
    void getcollectedMsg(int user_id, int shop_food_id, int flag, TListener<T> tListener);
}
