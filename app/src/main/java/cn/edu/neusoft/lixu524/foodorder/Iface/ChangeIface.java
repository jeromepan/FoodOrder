package cn.edu.neusoft.lixu524.foodorder.Iface;

import cn.edu.neusoft.lixu524.foodorder.Listener.TListener;

/**
 * Created by www44 on 2017/11/8.
 */

public interface RegisterIface<T> {
    void getReglist(String username,String password, String mobilenum,String address,String comment,TListener<T> tListener);
}
