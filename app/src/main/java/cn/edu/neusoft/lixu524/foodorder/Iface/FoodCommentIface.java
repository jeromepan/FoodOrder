package cn.edu.neusoft.lixu524.foodorder.Iface;

import cn.edu.neusoft.lixu524.foodorder.Listener.ListListener;
import cn.edu.neusoft.lixu524.foodorder.Listener.TListener;

/**
 * Created by www44 on 2017/11/1.
 */

public interface OrderOrCommentIface<T> {
    void getOrderMeg(int user_id, ListListener<T> listListener);
    void getCommentMeg(int user_id, ListListener<T> listListener);
}
