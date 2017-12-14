package cn.edu.neusoft.lixu524.foodorder.Listener;

import cn.edu.neusoft.lixu524.foodorder.Bean.LoginBean;

/**
 * Created by www44 on 2017/11/1.
 */

public interface TListener<T> {
    void onResponse(T t);
    void onFail(String msg);
}
