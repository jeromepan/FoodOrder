package cn.edu.neusoft.lixu524.foodorder.Iface;

import cn.edu.neusoft.lixu524.foodorder.Listener.TListener;

/**
 * Created by www44 on 2017/11/1.
 */

public interface UserIface<T> {
    void getUserMeg(int user_id, TListener<T> tListener);
}
