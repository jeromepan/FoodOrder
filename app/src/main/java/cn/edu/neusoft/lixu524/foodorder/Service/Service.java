package cn.edu.neusoft.lixu524.foodorder.Service;

import java.util.List;

import cn.edu.neusoft.lixu524.foodorder.Bean.FoodDetailBean;
import cn.edu.neusoft.lixu524.foodorder.Bean.FoodListBean;
import cn.edu.neusoft.lixu524.foodorder.Bean.GetCollectBean;
import cn.edu.neusoft.lixu524.foodorder.Bean.IsCollectBean;
import cn.edu.neusoft.lixu524.foodorder.Bean.LoginBean;
import cn.edu.neusoft.lixu524.foodorder.Bean.PurchaseBean;
import cn.edu.neusoft.lixu524.foodorder.Bean.RegisterBean;
import cn.edu.neusoft.lixu524.foodorder.Bean.ShopListBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by www44 on 2017/11/1.
 */

public interface Service {
    @GET("userLogin.do")
    Call<LoginBean> getAddress(@Query("username") String username, @Query("userpass") String userpass);
    @GET("userRegister.do")
    Call<RegisterBean> getRegmessage(@Query("username") String username, @Query("userpass") String userpass,
                                     @Query("mobilenum") String mobilenum,@Query("address") String address,
                                     @Query("comment") String comment);

    @GET("getAllShops.do")
    Call<List<ShopListBean>> getShoplist();

    @GET("getFoodByShop.do")
    Call<List<FoodListBean>> getFoodlist(@Query("shop_id") int shop_id);

    @GET("getFoodById.do")
    Call<FoodDetailBean> getFooddetail(@Query("food_id") int food_id);

    @GET("insertOrder.do")
    Call<PurchaseBean> getPurchase(@Query("user_id") int user_id, @Query("food_id") int food_id,
                                   @Query("num") int num, @Query("sum") double sum, @Query("suggesttime") String suggesttime);

    @GET("isCollected.do")
    Call<IsCollectBean> getIscollected(@Query("user_id") int user_id,@Query("shop_food_id") int shop_food_id,@Query("flag") int flag);

    @GET("userCollectShop.do")
    Call<RegisterBean> getShopcollect(@Query("user_id") int user_id,@Query("shop_id") int shop_id);

    @GET("userCollectFood.do")
    Call<RegisterBean> getFoodcollect(@Query("user_id") int user_id,@Query("food_id") int food_id);

    @GET("getAllUserCollection.do")
    Call<List<GetCollectBean>> getCollect(@Query("user_id") int user_id,@Query("flag") int flag);

    @GET("getFoodBySearch.do")
    Call<List<FoodListBean>> getSearchMsg(@Query("search") String  search);
}
