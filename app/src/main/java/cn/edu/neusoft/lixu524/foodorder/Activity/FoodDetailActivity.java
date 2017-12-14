package cn.edu.neusoft.lixu524.foodorder.Activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import cn.edu.neusoft.lixu524.foodorder.Bean.FoodDetailBean;
import cn.edu.neusoft.lixu524.foodorder.Bean.IsCollectBean;
import cn.edu.neusoft.lixu524.foodorder.Bean.RegisterBean;
import cn.edu.neusoft.lixu524.foodorder.Listener.TListener;
import cn.edu.neusoft.lixu524.foodorder.Modul.CollectFoodorShopModel;
import cn.edu.neusoft.lixu524.foodorder.Modul.FoodDetailModel;
import cn.edu.neusoft.lixu524.foodorder.Modul.IsCollectedModel;
import cn.edu.neusoft.lixu524.foodorder.R;

import static cn.edu.neusoft.lixu524.foodorder.Server.food_flag;
import static cn.edu.neusoft.lixu524.foodorder.Server.user_id_remember;

/**
 * Created by www44 on 2017/12/6.
 */

public class FoodDetailActivity extends BaseActivity {
    ImageView imageView;
    TextView tv_foodname,tv_foodprice,tv_foodintro;
    Button btn_buy,btn_back;
    double foodprice;
    String food_name;
    EditText et_num;
    private ImageButton bnt_collect;
    int collect_flag;

    TListener<IsCollectBean> ttListener=new TListener<IsCollectBean>() {
        @Override
        public void onResponse(IsCollectBean isCollectBean) {
            if(isCollectBean.getCollected().equals("1")){
                collect_flag=1;
                bnt_collect.setImageResource(R.drawable.ic_favor_press);
//                showToast("已收藏");
            }else{
                collect_flag=0;
                bnt_collect.setImageResource(R.drawable.ic_favor_nomal);
//                showToast("未收藏");
            }
        }

        @Override
        public void onFail(String msg) {
            showToast("判断收藏失败");
        }
    };

    TListener<RegisterBean> collectListener=new TListener<RegisterBean>() {
        @Override
        public void onResponse(RegisterBean registerBean) {
            if(collect_flag==1&&registerBean.getSuccess().equals("1")){
                bnt_collect.setImageResource(R.drawable.ic_favor_nomal);
                showToast("取消成功");
            }else if(collect_flag==0&&registerBean.getSuccess().equals("1")){
                bnt_collect.setImageResource(R.drawable.ic_favor_press);
                showToast("收藏成功");
            }else{
                showToast("操作失败");
            }
        }

        @Override
        public void onFail(String msg) {
            showToast("操作失败");
        }
    };
    @Override
    void initView() {
        setLayout_file(R.layout.activity_foodinfo);
        getSupportActionBar().hide();
        imageView= (ImageView) findViewById(R.id.image_Food);
        tv_foodname = (TextView) findViewById(R.id.tv_foodname);
        tv_foodprice = (TextView) findViewById(R.id.tv_foodprice);
        tv_foodintro = (TextView) findViewById(R.id.tv_foodintro);
        btn_buy = (Button) findViewById(R.id.btn_buy);
        btn_back= (Button) findViewById(R.id.button_back);
        et_num= (EditText) findViewById(R.id.et_num);
        bnt_collect= (ImageButton) findViewById(R.id.btn_collectf);
    }

    @Override
    void initEvent() {
        TListener<FoodDetailBean> tListener = new TListener<FoodDetailBean>() {
            @Override
            public void onResponse(FoodDetailBean foodDetailBean) {
                foodprice=foodDetailBean.getPrice();
                tv_foodname.setText("菜名:"+foodDetailBean.getFoodname());
                food_name=foodDetailBean.getFoodname().toString();
                tv_foodprice.setText("价格:￥"+foodDetailBean.getPrice());
                tv_foodintro.setText("简介:"+foodDetailBean.getIntro());
                Picasso.with(FoodDetailActivity.this).load(foodDetailBean.getPic()).into(imageView);
            }

            @Override
            public void onFail(String msg) {
                Toast.makeText(FoodDetailActivity.this,"获取店铺详情失败",Toast.LENGTH_SHORT).show();
            }
        };

        //加载菜品详情
        final int id=getIntent().getIntExtra("food_id",0);
        FoodDetailModel foodDetailModel = new FoodDetailModel();
        foodDetailModel.getFoodMeg(id,tListener);

        //返回上一级
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //点击购买
        btn_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodDetailActivity.this,PurchaseActivity.class);
                intent.putExtra("food_id",id);
                intent.putExtra("food_price",foodprice);
                intent.putExtra("food_name",food_name);
                intent.putExtra("food_num",et_num.getText().toString());
                startActivity(intent);
            }
        });

        //判断是否收藏过当前栏目
        final IsCollectedModel isCollectedModel=new IsCollectedModel();
        isCollectedModel.getcollectedMsg(user_id_remember,id,food_flag,ttListener);

        //点击收藏或取消收藏
        bnt_collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isCollectedModel.getcollectedMsg(user_id_remember,id,food_flag,ttListener);
                CollectFoodorShopModel modul = new CollectFoodorShopModel();
                modul.getfoodcollectedMsg(user_id_remember,id,collectListener);
            }
        });
    }

    @Override
    void initData() {

    }
}
