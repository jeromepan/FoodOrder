package cn.edu.neusoft.lixu524.foodorder.Fragment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import cn.edu.neusoft.lixu524.foodorder.Activity.FoodDetailActivity;
import cn.edu.neusoft.lixu524.foodorder.Activity.FoodListActivity;
import cn.edu.neusoft.lixu524.foodorder.Adapter.CollectFoodAdapter;
import cn.edu.neusoft.lixu524.foodorder.Adapter.CollectShopAdapter;
import cn.edu.neusoft.lixu524.foodorder.Bean.GetCollectBean;
import cn.edu.neusoft.lixu524.foodorder.Listener.ListListener;
import cn.edu.neusoft.lixu524.foodorder.Modul.GetCollectedModel;
import cn.edu.neusoft.lixu524.foodorder.R;

import static cn.edu.neusoft.lixu524.foodorder.Server.food_flag;
import static cn.edu.neusoft.lixu524.foodorder.Server.shop_flag;
import static cn.edu.neusoft.lixu524.foodorder.Server.user_id_remember;

/**
 * Created by www44 on 2017/11/22.
 */

public class Collect_two_Fragment extends BaseFragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<GetCollectBean> list=null;
    private CollectFoodAdapter shopAdapter;
    private Context context;
    private static int cur_page=1;
    private int lastVisibleItemPosition;

    ListListener<GetCollectBean> listListener=new ListListener<GetCollectBean>() {
        @Override
        public void onResponse(List<GetCollectBean> listbean) {
            list=listbean;
            shopAdapter.setList(list);
        }

        @Override
        public void onFail(String msg) {
            Toast.makeText(context,"fail:"+msg,Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    void initLayout() {
        setLayout_file(R.layout.fragment_collect_two);
    }

    @Override
    void initView() {
        context=view.getContext();
        recyclerView=view.findViewById(R.id.rv_collect2_list);

        //创建默认的线性LayoutManager
        layoutManager =new LinearLayoutManager(context);
        //设置布局
        recyclerView.setLayoutManager(layoutManager);
        //创建适配器
        shopAdapter=new CollectFoodAdapter(getActivity(),list,R.layout.item);

        CollectFoodAdapter.OnItemClickListener onItemClickListener= new CollectFoodAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent=new Intent(getActivity(), FoodDetailActivity.class);
                intent.putExtra("food_id",list.get(position).getFood_id());
                startActivity(intent);
            }
        };


        shopAdapter.setOnItemClickListener(onItemClickListener);

        shopAdapter.setList(list);
        recyclerView.setAdapter(shopAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItemPosition + 1 == list.size()) {
                    cur_page+=1;

                    new GetCollectedModel().getcollectMsg(user_id_remember,food_flag,listListener);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItemPosition=list.size()-1;
            }
        });
    }

    @Override
    void initEvent() {
        GetCollectedModel getCollectedModel = new GetCollectedModel();
        getCollectedModel.getcollectMsg(user_id_remember,food_flag,listListener);
    }

    @Override
    void initData() {

    }
}
