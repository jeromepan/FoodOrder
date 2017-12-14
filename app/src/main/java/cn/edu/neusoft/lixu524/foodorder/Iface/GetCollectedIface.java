package cn.edu.neusoft.lixu524.foodorder.Iface;

import cn.edu.neusoft.lixu524.foodorder.Listener.ListListener;

/**
 * Created by www44 on 2017/12/10.
 */

public interface GetCollectedIface<T> {
    void getcollectMsg(int user_id, int flag, ListListener<T> listListener);
}
