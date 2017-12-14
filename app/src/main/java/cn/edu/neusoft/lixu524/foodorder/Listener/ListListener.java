package cn.edu.neusoft.lixu524.foodorder.Listener;

import java.util.List;

/**
 * Created by www44 on 2017/11/1.
 */

public interface ListListener<T> {
    void onResponse(List<T> t);
    void onFail(String msg);
}
